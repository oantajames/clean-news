package com.clean.news.view.newssources;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import com.clean.news.dagger.components.DaggerNewsSourceComponent;
import com.clean.news.presentation.R;
import com.clean.news.dagger.HasComponent;
import com.clean.news.dagger.components.NewsSourceComponent;
import com.clean.news.model.newssources.SourceModel;
import com.clean.news.view.BaseActivity;

/**
 * @author james on 5/22/17.
 */

public class NewsSourceListActivity extends BaseActivity implements HasComponent<NewsSourceComponent>,
        NewsSourcesFragment.NewsSourcesListener {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, NewsSourceListActivity.class);
    }

    private NewsSourceComponent newsSourceComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_source_list);
        ButterKnife.bind(this);
        initializeInjector();
        addFragment(R.id.fragmentContainer, new NewsSourcesFragment());
    }

    private void initializeInjector() {
        newsSourceComponent = DaggerNewsSourceComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public NewsSourceComponent getComponent() {
        return newsSourceComponent;
    }

    @Override
    public void onSourceClicked(SourceModel sourceModel) {
        this.navigator.openNewsListActivity(this, sourceModel.getId());
    }
}
