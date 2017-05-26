package com.clean.news.dagger.components;

import com.clean.news.dagger.modules.ActivityModule;
import com.clean.news.dagger.PerActivity;
import com.clean.news.dagger.modules.NewsSourcesModule;
import com.clean.news.view.newssources.NewsSourcesFragment;
import dagger.Component;

/**
 * @author james on 5/22/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, NewsSourcesModule.class})
public interface NewsSourceComponent extends ActivityComponent {
    void injectTo(NewsSourcesFragment newsSourcesFragment);
}
