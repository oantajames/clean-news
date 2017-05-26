package com.clean.news.data.repository.datasource.newssources;

import com.clean.news.data.entity.newssources.NewsSourcesEntity;
import com.clean.news.data.net.api.news.NewsInteractor;
import io.reactivex.Observable;

/**
 * @author james on 5/21/17.
 */

public class CloudNewsSourcesDataStore implements NewsSourcesDataStore {

    NewsInteractor newsInteractor;

    public CloudNewsSourcesDataStore(NewsInteractor newsInteractor) {
        this.newsInteractor = newsInteractor;
    }


    @Override
    public Observable<NewsSourcesEntity> getNewsSources() {
        return newsInteractor.getNewsSources();
    }
}
