package com.clean.news.data.repository.datasource.news;

import com.clean.news.data.net.api.news.NewsApi;
import com.clean.news.data.net.api.news.NewsInteractorImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

/**
 * @author james on 5/26/17.
 */
public class NewsDataStoreFactoryTest {

    @Mock
    private NewsInteractorImpl newsInteractor;
    @Mock
    private NewsApi newsApi;

    private NewsDataStoreFactory newsDataStoreFactory;

    @Before
    public void setUp() {
        newsInteractor = new NewsInteractorImpl(newsApi);
        newsDataStoreFactory = new NewsDataStoreFactory(newsInteractor);
    }

    @Test
    public void createCloudDataStore_newsDataStoreObjectCreated() throws Exception {
        NewsDataStore newsDataStore = newsDataStoreFactory.createCloudDataStore();

        assertThat(newsDataStore, is(notNullValue()));
        assertThat(newsDataStore, instanceOf(NewsDataStore.class));
    }

}