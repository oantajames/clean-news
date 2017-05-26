package com.clean.news.domain.interactor;

import com.clean.news.domain.executor.PostExecutionThread;
import com.clean.news.domain.executor.ThreadExecutor;
import com.clean.news.domain.repository.NewsSourcesRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * @author james on 5/26/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class GetNewsSourcesTest {

    private GetNewsSources getNewsSources;

    @Mock
    private NewsSourcesRepository newsSourcesRepository;
    @Mock
    private ThreadExecutor threadExecutor;
    @Mock
    private PostExecutionThread postExecutionThread;


    @Before
    public void setUp() {
        getNewsSources = new GetNewsSources(newsSourcesRepository, threadExecutor, postExecutionThread);
    }

    @Test
    public void buildUseCaseObservable_verifyHappyFlow() throws Exception {
        getNewsSources.buildUseCaseObservable(null);

        verify(newsSourcesRepository).getNewsSources();
        verifyNoMoreInteractions(newsSourcesRepository);
        verifyZeroInteractions(threadExecutor);
        verifyZeroInteractions(postExecutionThread);
    }

}