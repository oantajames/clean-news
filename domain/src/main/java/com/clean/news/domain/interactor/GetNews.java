package com.clean.news.domain.interactor;

import com.clean.news.domain.executor.PostExecutionThread;
import com.clean.news.domain.executor.ThreadExecutor;
import com.clean.news.domain.model.news.News;
import com.clean.news.domain.repository.NewsRepository;
import io.reactivex.Observable;
import javax.inject.Inject;

/**
 * @author james on 5/17/17.
 */

public class GetNews extends UseCase<News, GetNews.Params> {

    private NewsRepository newsRepository;

    @Inject
    GetNews(NewsRepository newsRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.newsRepository = newsRepository;
    }

    @Override
    public Observable<News> buildUseCaseObservable(Params params) {
        return newsRepository.getNews(params.source);
    }

    public static final class Params {

        private final String source;

        private Params(String source) {
            this.source = source;
        }

        public static GetNews.Params forNews(String source) {
            return new GetNews.Params(source);
        }
    }
}
