package com.clean.news.domain.interactor;

import com.clean.news.domain.executor.PostExecutionThread;
import com.clean.news.domain.executor.ThreadExecutor;
import com.clean.news.domain.repository.NewsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * @author james on 5/26/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class GetNewsTest {

    private static final String FAKE_SOURCE = "fake_source";

    private GetNews getNews;

    @Mock
    private NewsRepository newsRepository;
    @Mock
    private ThreadExecutor threadExecutor;
    @Mock
    private PostExecutionThread postExecutionThread;

    @Before
    public void setUp() {
        getNews = new GetNews(newsRepository, threadExecutor, postExecutionThread);
    }

    @Test
    public void buildUseCaseObservable_verifyHappyFlow() throws Exception {
        getNews.buildUseCaseObservable(GetNews.Params.forNews(FAKE_SOURCE));

        verify(newsRepository).getNews(FAKE_SOURCE);
        verifyNoMoreInteractions(newsRepository);
        verifyZeroInteractions(postExecutionThread);
        verifyZeroInteractions(threadExecutor);
    }

    @Test(expected = NullPointerException.class)
    public void buildUseCaseObservable_withNullValue_throwNullPointer() {
        getNews.buildUseCaseObservable(null);
    }

}