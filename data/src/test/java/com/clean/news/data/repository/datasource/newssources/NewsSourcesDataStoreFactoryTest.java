package com.clean.news.data.repository.datasource.newssources;

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
public class NewsSourcesDataStoreFactoryTest {

    @Mock
    private NewsInteractorImpl newsInteractor;
    @Mock
    private NewsApi newsApi;

    private NewsSourcesDataStoreFactory newsSourcesDataStoreFactory;

    @Before
    public void setUp() {
        newsInteractor = new NewsInteractorImpl(newsApi);
        newsSourcesDataStoreFactory = new NewsSourcesDataStoreFactory(newsInteractor);
    }

    @Test
    public void createNewsSourceCloudDataStore_NewsSourceCloudDataStoreObjectCreated() throws Exception {
        NewsSourcesDataStore newsSourceCloudDataStore = newsSourcesDataStoreFactory.createNewsSourceCloudDataStore();

        assertThat(newsSourceCloudDataStore, is(notNullValue()));
        assertThat(newsSourceCloudDataStore, instanceOf(NewsSourcesDataStore.class));
    }

}