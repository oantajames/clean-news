package com.clean.news.data.net.api.news;

import com.clean.news.data.entity.news.NewsEntity;
import com.clean.news.data.entity.newssources.NewsSourcesEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author james on 5/17/17.
 */

public interface NewsApi {

    @GET("/v1/articles/")
    Observable<NewsEntity> getNews(@Query("source") String source);

    @GET("/v1/sources")
    Observable<NewsSourcesEntity> getNewsSources();

}
