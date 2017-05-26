package com.clean.news.view.newssources;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.clean.news.dagger.components.NewsSourceComponent;
import com.clean.news.view.view.NewsSourcesView;
import com.clean.news.presentation.R;
import com.clean.news.model.newssources.NewsSourcesModel;
import com.clean.news.model.newssources.SourceModel;
import com.clean.news.presenter.news.NewsSourcePresenter;
import com.clean.news.view.BaseFragment;
import javax.inject.Inject;

/**
 * @author james on 5/21/17.
 */

public class NewsSourcesFragment extends BaseFragment implements NewsSourcesView, NewsSourcesAdapter.OnItemClickListener {

    public interface NewsSourcesListener {
        void onSourceClicked(SourceModel sourceModel);
    }

    @Inject
    NewsSourcePresenter newsSourcePresenter;
    @Inject
    NewsSourcesAdapter newsSourcesAdapter;
    @BindView(R.id.news_source_recycler_view)
    RecyclerView recyclerView;
    private NewsSourcesListener newsSourcesListener;

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof NewsSourcesListener) {
            this.newsSourcesListener = (NewsSourcesListener) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.newsSourcesListener = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(NewsSourceComponent.class).injectTo(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_news_source_list, container, false);
        ButterKnife.bind(this, view);
        setUpRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.newsSourcePresenter.setNewsSourcesView(this);
        newsSourcePresenter.initialize();
    }

    private void setUpRecyclerView() {
        newsSourcesAdapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(newsSourcesAdapter);
    }

    @Override
    public void renderNewsSources(NewsSourcesModel newsSourcesModel) {
        newsSourcesAdapter.setArticleModelList(newsSourcesModel.getSources());
    }

    @Override
    public void viewNews(SourceModel sourceModel) {
        if (this.newsSourcesListener != null) {
            this.newsSourcesListener.onSourceClicked(sourceModel);
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
    public void onNewsSourceItemClicked(SourceModel sourceModel) {
        if (NewsSourcesFragment.this.newsSourcePresenter != null && sourceModel != null) {
            NewsSourcesFragment.this.newsSourcePresenter.onSourceClicked(sourceModel);
        }
    }
}
