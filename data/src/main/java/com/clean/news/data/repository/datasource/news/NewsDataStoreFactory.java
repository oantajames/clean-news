package com.clean.news.data.repository.datasource.news;

import com.clean.news.data.net.api.news.NewsInteractor;
import com.clean.news.data.net.api.news.NewsInteractorImpl;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author james on 5/17/17.
 */

@Singleton
public class NewsDataStoreFactory {

    private NewsInteractor newsInteractor;

    @Inject
    public NewsDataStoreFactory(NewsInteractorImpl newsInteractor) {
        this.newsInteractor = newsInteractor;
    }


    public CloudNewsDataStore createCloudDataStore() {
        return new CloudNewsDataStore(newsInteractor);
    }
    //// TODO: 5/22/17 add local DB
}
