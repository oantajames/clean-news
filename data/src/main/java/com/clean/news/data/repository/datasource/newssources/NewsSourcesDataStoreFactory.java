package com.clean.news.data.repository.datasource.newssources;

import com.clean.news.data.net.api.news.NewsInteractor;
import com.clean.news.data.net.api.news.NewsInteractorImpl;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author james on 5/21/17.
 */
@Singleton
public class NewsSourcesDataStoreFactory {

    private NewsInteractor newsInteractor;

    @Inject
    public NewsSourcesDataStoreFactory(NewsInteractorImpl newsInteractor) {
        this.newsInteractor = newsInteractor;
    }

    public CloudNewsSourcesDataStore createNewsSourceCloudDataStore() {
        return new CloudNewsSourcesDataStore(newsInteractor);
    }
    // TODO: 5/22/17 add local DB
}
