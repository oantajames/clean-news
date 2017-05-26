package com.clean.news.data.repository.datasource.news;

import com.clean.news.data.entity.news.NewsEntity;
import io.reactivex.Observable;

/**
 * @author james on 5/17/17.
 */

public interface NewsDataStore {
    Observable<NewsEntity> getNews(final String source);
}
