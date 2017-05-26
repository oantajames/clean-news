package com.clean.news.presenter.news;

import android.util.Log;
import com.clean.news.mapper.NewsModelDataMapper;
import com.clean.news.model.news.NewsModel;
import com.clean.news.presenter.Presenter;
import com.clean.news.view.view.NewsView;
import com.clean.news.domain.interactor.DefaultObserver;
import com.clean.news.domain.interactor.GetNews;
import com.clean.news.domain.model.news.News;
import com.clean.news.model.news.ArticleModel;
import javax.inject.Inject;

/**
 * @author james on 5/17/17.
 */

public class NewsPresenter implements Presenter {

    private static final String TAG = NewsPresenter.class.getSimpleName();

    private NewsView newsView;

    private final NewsModelDataMapper newsModelDataMapper;
    private final GetNews getNews;

    @Inject
    public NewsPresenter(GetNews getNews, NewsModelDataMapper newsModelDataMapper) {
        this.getNews = getNews;
        this.newsModelDataMapper = newsModelDataMapper;
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

    public void onNewsArticleClicekd(ArticleModel articleModel) {
        this.newsView.viewNews(articleModel);
    }

    public void setNewsView(NewsView newsView) {
        this.newsView = newsView;
    }

    public void initialize(String source) {
        this.getNews(source);
    }

    private void getNews(String source) {
        this.getNews.execute(new NewsObserver(), GetNews.Params.forNews(source));
    }

    private void showNewsInView(News news) {
        final NewsModel newsModel = this.newsModelDataMapper.transform(news);
        this.newsView.renderNews(newsModel);
    }

    private final class NewsObserver extends DefaultObserver<News> {
        @Override
        public void onNext(News news) {
            NewsPresenter.this.showNewsInView(news);
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
}
