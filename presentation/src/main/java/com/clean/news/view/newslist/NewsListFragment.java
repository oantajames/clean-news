package com.clean.news.view.newslist;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.clean.news.dagger.components.NewsComponent;
import com.fernandocejas.arrow.checks.Preconditions;
import com.clean.news.model.news.ArticleModel;
import com.clean.news.model.news.NewsModel;
import com.clean.news.presenter.news.NewsPresenter;
import com.clean.news.view.BaseFragment;
import com.clean.news.view.view.NewsView;
import com.clean.news.presentation.R;
import javax.inject.Inject;

/**
 * @author james on 5/8/17.
 */

public class NewsListFragment extends BaseFragment implements NewsView, NewsAdapter.OnItemClickListener {

    private static final String SOURCE_ID = "sourceId";
    private static final String TAG = NewsListFragment.class.getSimpleName();

    public interface NewsListener {
        void onNewsItemClicked(ArticleModel model);
    }

    @Inject
    NewsPresenter newsPresenter;
    @Inject
    NewsAdapter newsAdapter;
    @BindView(R.id.news_recycler_view)
    RecyclerView recyclerView;
    private NewsListener newsListener;

    public static NewsListFragment forNews(String sourceId) {
        final NewsListFragment newsListFragment = new NewsListFragment();
        final Bundle arguments = new Bundle();
        arguments.putString(SOURCE_ID, sourceId);
        newsListFragment.setArguments(arguments);
        return newsListFragment;
    }

    private String getSourceId() {
        final Bundle arguments = getArguments();
        Preconditions.checkNotNull(arguments, "Fragment arguments cannot be null");
        Log.d(TAG, "Source id : " + arguments.getString(SOURCE_ID));
        return arguments.getString(SOURCE_ID);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof NewsListActivity) {
            newsListener = (NewsListener) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        newsListener = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(NewsComponent.class).injectTo(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        ButterKnife.bind(this, view);
        setUpRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.newsPresenter.setNewsView(this);
        newsPresenter.initialize(getSourceId());
    }

    private void setUpRecyclerView() {
        newsAdapter.setOnItemClickListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(newsAdapter);
    }


    @Override
    public void renderNews(NewsModel newsModel) {
        Log.d(TAG, newsModel.getArticleModels().toString());
        newsAdapter.setArticleModelList(newsModel.getArticleModels());
    }

    @Override
    public void viewNews(ArticleModel articleModel) {
        if (this.newsListener != null) {
            this.newsListener.onNewsItemClicked(articleModel);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onNewsClicked(ArticleModel articleModel) {
        if (newsPresenter != null && articleModel != null) {
            newsPresenter.onNewsArticleClicekd(articleModel);
        }
    }

}
