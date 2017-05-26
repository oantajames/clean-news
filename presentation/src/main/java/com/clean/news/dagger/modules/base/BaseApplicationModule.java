package com.clean.news.dagger.modules.base;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 *
 * @param <A>
 */
@Module
public abstract class BaseApplicationModule<A extends Application> {

    private final A application;

    public BaseApplicationModule(A application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return getApplication();
    }

    protected A getApplication() {
        return this.application;
    }

    @Singleton
    @Provides
    public Context provideApplicationContext() {
        return getApplication();
    }

}
