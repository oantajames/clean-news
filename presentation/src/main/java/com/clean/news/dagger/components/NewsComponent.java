package com.clean.news.dagger.components;

import com.clean.news.dagger.PerActivity;
import com.clean.news.dagger.modules.ActivityModule;
import com.clean.news.dagger.modules.NewsModule;
import com.clean.news.view.newslist.NewsListFragment;
import dagger.Component;

/**
 * @author james on 5/17/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, NewsModule.class})
public interface NewsComponent extends ActivityComponent {
    void injectTo(NewsListFragment newsListFragment);
}
