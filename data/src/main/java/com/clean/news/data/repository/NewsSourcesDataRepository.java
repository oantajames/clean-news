package com.clean.news.data.repository;

import com.clean.news.domain.model.newssources.NewsSources;
import com.clean.news.domain.repository.NewsSourcesRepository;
import com.clean.news.data.entity.newssources.NewsSourceEntityDataMapper;
import com.clean.news.data.repository.datasource.newssources.NewsSourcesDataStore;
import com.clean.news.data.repository.datasource.newssources.NewsSourcesDataStoreFactory;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author james on 5/21/17.
 */
@Singleton
public class NewsSourcesDataRepository implements NewsSourcesRepository {

    private final NewsSourceEntityDataMapper newsSourceEntityDataMapper;
    private final NewsSourcesDataStoreFactory newsSourcesDataStoreFactory;

    @Inject
    public NewsSourcesDataRepository(NewsSourceEntityDataMapper newsSourceEntityDataMapper,
                                     NewsSourcesDataStoreFactory newsSourcesDataStoreFactory) {
        this.newsSourceEntityDataMapper = newsSourceEntityDataMapper;
        this.newsSourcesDataStoreFactory = newsSourcesDataStoreFactory;
    }

    @Override
    public Observable<NewsSources> getNewsSources() {
        NewsSourcesDataStore newsSourcesDataStore = newsSourcesDataStoreFactory.createNewsSourceCloudDataStore();
        return newsSourcesDataStore.getNewsSources().map(newsSourceEntityDataMapper::transform);

    }
}
