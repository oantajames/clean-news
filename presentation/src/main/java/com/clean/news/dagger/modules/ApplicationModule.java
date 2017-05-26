package com.clean.news.dagger.modules;

import com.clean.news.UIThread;
import com.clean.news.dagger.components.ApplicationComponent;
import com.clean.news.dagger.modules.base.BaseApplicationModule;
import com.clean.news.view.navigator.DemoAppNavigator;
import com.clean.news.domain.executor.PostExecutionThread;
import com.clean.news.domain.executor.ThreadExecutor;
import com.clean.news.data.executor.JobExecutor;
import com.clean.news.NewsApplication;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule extends BaseApplicationModule<NewsApplication> {

    public ApplicationModule(NewsApplication application) {
        super(application);
    }

    @Provides
    @Singleton
    public NewsApplication provideDemoApplication() {
        return getApplication();
    }

    @Provides
    @Singleton
    public ApplicationComponent provideApplicationComponent() {
        return getApplication().getApplicationComponent();
    }

    @Provides
    @Singleton
    public DemoAppNavigator provideDemoActivityNavigator() {
        DemoAppNavigator demoAppNavigator = new DemoAppNavigator();
        getApplication().getApplicationComponent().inject(demoAppNavigator);
        return demoAppNavigator;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

}
