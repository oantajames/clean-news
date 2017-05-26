package com.clean.news.data.repository.datasource.news;

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
 * @author james on 5/24/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class CloudNewsDataStoreTest {

    private static final String FAKE_SOURCE = "FAKE_SOURCE";

    @Mock
    private NewsInteractor newsInteractor;
    @Mock
    private NewsApi newsApi;

    @Before
    public void setUp() {
        newsInteractor = new NewsInteractorImpl(newsApi);
    }

    @Test
    public void getNews_getNewsFromNewsApiCalled() throws Exception {
        newsInteractor.getNews(FAKE_SOURCE);
        verify(newsApi).getNews(FAKE_SOURCE);
    }

}