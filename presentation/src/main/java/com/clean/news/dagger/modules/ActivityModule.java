package com.clean.news.dagger.modules;

import android.app.Activity;
import com.clean.news.dagger.PerActivity;
import dagger.Module;
import dagger.Provides;

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    public Activity activity() {
        return this.activity;
    }
}
