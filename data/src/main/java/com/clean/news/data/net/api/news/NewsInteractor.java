package com.clean.news.data.net.api.news;

import com.clean.news.data.entity.news.NewsEntity;
import com.clean.news.data.entity.newssources.NewsSourcesEntity;
import io.reactivex.Observable;

/**
 * @author james on 5/17/17.
 */

public abstract class NewsInteractor {
    public abstract Observable<NewsEntity> getNews(String source);

    public abstract Observable<NewsSourcesEntity> getNewsSources();
}
