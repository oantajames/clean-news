package com.clean.news.data.repository.datasource.news;

import com.clean.news.data.entity.news.NewsEntity;
import com.clean.news.data.net.api.news.NewsInteractor;
import io.reactivex.Observable;

/**
 * @author james on 5/17/17.
 */

public class CloudNewsDataStore implements NewsDataStore {

    private NewsInteractor newsInteractor;

    public CloudNewsDataStore(NewsInteractor newsInteractor) {
        this.newsInteractor = newsInteractor;
    }

    @Override
    public Observable<NewsEntity> getNews(String source) {
        return newsInteractor.getNews(source);
    }
}
