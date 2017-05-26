package com.clean.news.view.newslist;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import com.clean.news.dagger.HasComponent;
import com.clean.news.dagger.components.DaggerNewsComponent;
import com.clean.news.dagger.components.NewsComponent;
import com.clean.news.view.BaseActivity;
import com.clean.news.presentation.R;
import com.clean.news.model.news.ArticleModel;

/**
 * @author James
 */

public class NewsListActivity extends BaseActivity implements HasComponent<NewsComponent>, NewsListFragment.NewsListener {

    private static final String SOURCE_ID = "source_id";

    public static Intent getCallingIntent(Context context, String sourceId) {
        Intent callingIntent = new Intent(context, NewsListActivity.class);
        callingIntent.putExtra(SOURCE_ID, sourceId);
        return callingIntent;
    }

    private String sourceId;
    private NewsComponent newsComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        ButterKnife.bind(this);
        initializeActivity();
        initializeInjector();
    }

    private void initializeActivity() {
        this.sourceId = getIntent().getStringExtra(SOURCE_ID);
        addFragment(R.id.news_list_frame_layout, NewsListFragment.forNews(sourceId));
    }

    private void initializeInjector() {
        newsComponent = DaggerNewsComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public NewsComponent getComponent() {
        return newsComponent;
    }

    @Override
    public void onNewsItemClicked(ArticleModel model) {
        this.navigator.openFinesWebViewActivity(this, model.getUrl(), model.getTitle());
    }
}
