package com.clean.news.domain.interactor;

import com.clean.news.domain.executor.PostExecutionThread;
import com.clean.news.domain.executor.ThreadExecutor;
import com.clean.news.domain.model.newssources.NewsSources;
import com.clean.news.domain.repository.NewsSourcesRepository;
import io.reactivex.Observable;
import javax.inject.Inject;

/**
 * @author james on 5/22/17.
 */

public class GetNewsSources extends UseCase<NewsSources, Void> {

    private NewsSourcesRepository newsSourcesRepository;

    @Inject
    public GetNewsSources(NewsSourcesRepository newsSourcesRepository,
                          ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.newsSourcesRepository = newsSourcesRepository;
    }

    @Override
    public Observable<NewsSources> buildUseCaseObservable(Void aVoid) {
        return newsSourcesRepository.getNewsSources();
    }
}
