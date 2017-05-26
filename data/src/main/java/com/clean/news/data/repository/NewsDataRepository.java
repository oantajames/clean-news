package com.clean.news.data.repository;

import com.clean.news.domain.model.news.News;
import com.clean.news.domain.repository.NewsRepository;
import com.clean.news.data.entity.news.NewsEntityDataMapper;
import com.clean.news.data.repository.datasource.news.NewsDataStore;
import com.clean.news.data.repository.datasource.news.NewsDataStoreFactory;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author james on 5/17/17.
 */
@Singleton
public class NewsDataRepository implements NewsRepository {

    private final NewsEntityDataMapper newsEntityDataMapper;
    private final NewsDataStoreFactory newsDataStoreFactory;

    @Inject
    NewsDataRepository(NewsEntityDataMapper newsEntityDataMapper, NewsDataStoreFactory newsDataStoreFactory) {
        this.newsEntityDataMapper = newsEntityDataMapper;
        this.newsDataStoreFactory = newsDataStoreFactory;
    }

    @Override
    public Observable<News> getNews(String source) {
        final NewsDataStore newsDataStore = this.newsDataStoreFactory.createCloudDataStore();
        return newsDataStore.getNews(source).map(this.newsEntityDataMapper::transform);
    }
}
