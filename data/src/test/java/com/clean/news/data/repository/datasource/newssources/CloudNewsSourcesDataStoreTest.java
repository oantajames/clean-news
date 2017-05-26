package com.clean.news.data.repository.datasource.newssources;

import com.clean.news.data.net.api.news.NewsApi;
import com.clean.news.data.net.api.news.NewsInteractor;
import com.clean.news.data.net.api.news.NewsInteractorImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;


/**
 * @author james on 5/26/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class CloudNewsSourcesDataStoreTest {

    @Mock
    private NewsInteractor newsInteractor;
    @Mock
    private NewsApi newsApi;

    @Before
    public void setUp() {
        newsInteractor = new NewsInteractorImpl(newsApi);
    }

    @Test
    public void getNewsSources_getNewsSourcesFromNewsApiCalled() throws Exception {
        newsInteractor.getNewsSources();
        verify(newsApi).getNewsSources();
    }

}