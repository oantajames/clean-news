package com.clean.news;

import android.app.Application;
import com.clean.news.dagger.components.ApplicationComponent;
import com.clean.news.dagger.components.DaggerApplicationComponent;
import com.clean.news.dagger.modules.ApplicationModule;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author james
 */
public class NewsApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}

