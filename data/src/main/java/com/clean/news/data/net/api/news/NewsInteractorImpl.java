package com.clean.news.data.net.api.news;

import com.clean.news.data.entity.news.NewsEntity;
import com.clean.news.data.entity.newssources.NewsSourcesEntity;
import io.reactivex.Observable;
import javax.inject.Inject;

/**
 * @author james on 5/17/17.
 */

public class NewsInteractorImpl extends NewsInteractor {

    private NewsApi newsApi;

    @Inject
    public NewsInteractorImpl(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    @Override
    public Observable<NewsEntity> getNews(String source) {
        return newsApi.getNews(source);
    }

    @Override
    public Observable<NewsSourcesEntity> getNewsSources() {
        return newsApi.getNewsSources();
    }
}
