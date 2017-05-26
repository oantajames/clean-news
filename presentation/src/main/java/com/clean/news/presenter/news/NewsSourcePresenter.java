package com.clean.news.presenter.news;

import android.util.Log;
import com.clean.news.mapper.NewsSourcesModelDataMapper;
import com.clean.news.model.newssources.NewsSourcesModel;
import com.clean.news.presenter.Presenter;
import com.clean.news.view.view.NewsSourcesView;
import com.clean.news.domain.interactor.DefaultObserver;
import com.clean.news.domain.interactor.GetNewsSources;
import com.clean.news.domain.model.newssources.NewsSources;
import com.clean.news.model.newssources.SourceModel;
import javax.inject.Inject;

/**
 * @author james on 5/21/17.
 */

public class NewsSourcePresenter implements Presenter {

    private static final String TAG = NewsSourcePresenter.class.getSimpleName();

    private NewsSourcesView newsSourcesView;

    private NewsSourcesModelDataMapper newsSourcesModelDataMapper;
    private GetNewsSources getNewsSources;

    @Inject
    public NewsSourcePresenter(NewsSourcesModelDataMapper newsSourcesModelDataMapper, GetNewsSources getNewsSources) {
        this.newsSourcesModelDataMapper = newsSourcesModelDataMapper;
        this.getNewsSources = getNewsSources;
    }

    public void setNewsSourcesView(NewsSourcesView newsSourcesView) {
        this.newsSourcesView = newsSourcesView;
    }

    public void initialize() {
        this.getNewsSources.execute(new NewsSourcesObserver(), null);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    public void onSourceClicked(SourceModel sourceModel) {
        this.newsSourcesView.viewNews(sourceModel);
    }

    private final class NewsSourcesObserver extends DefaultObserver<NewsSources> {
        @Override
        public void onNext(NewsSources newsSources) {
            NewsSourcePresenter.this.showNewsSourcesInView(newsSources);
        }

        @Override
        public void onComplete() {
            Log.d(TAG, "COMPLETED");
        }

        @Override
        public void onError(Throwable exception) {
            Log.e(TAG, exception.getMessage());
        }
    }

    private void showNewsSourcesInView(NewsSources newsSources) {
        final NewsSourcesModel newsSourcesModel = this.newsSourcesModelDataMapper.transform(newsSources);
        this.newsSourcesView.renderNewsSources(newsSourcesModel);
    }
}
