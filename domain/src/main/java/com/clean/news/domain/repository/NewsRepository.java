package com.clean.news.domain.repository;

import com.clean.news.domain.model.news.News;
import io.reactivex.Observable;

/**
 * @author james on 5/17/17.
 */

public interface NewsRepository {
    Observable<News> getNews(final String source);
}
