package com.clean.news.view.splashscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.clean.news.presentation.R;
import com.clean.news.NewsApplication;
import com.clean.news.view.BaseActivity;
import com.clean.news.view.navigator.DemoAppNavigator;
import javax.inject.Inject;

/**
 * @author james
 */

public class SplashScreenActivity extends BaseActivity {

    private static final int delay = 5000;

    @BindView(R.id.splash_screen_layout)
    ViewGroup layoutSplashScreen;

    @Inject
    DemoAppNavigator shopActivityNavigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        ((NewsApplication) getApplication()).getApplicationComponent().inject(this);

        layoutSplashScreen.postDelayed(() -> shopActivityNavigator.openSourcesActivity(this, this), delay);
    }
}
