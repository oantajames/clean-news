package com.clean.news.domain.repository;

import com.clean.news.domain.model.newssources.NewsSources;
import io.reactivex.Observable;

/**
 * @author james on 5/21/17.
 */

public interface NewsSourcesRepository {
    Observable<NewsSources> getNewsSources();
}
