package com.clean.news.data.repository.datasource.newssources;

import com.clean.news.data.entity.newssources.NewsSourcesEntity;
import io.reactivex.Observable;

/**
 * @author james on 5/21/17.
 */

public interface NewsSourcesDataStore {
    Observable<NewsSourcesEntity> getNewsSources();

}
