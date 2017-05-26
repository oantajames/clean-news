package com.clean.news.data.repository;

import com.clean.news.data.entity.newssources.NewsSourceEntityDataMapper;
import com.clean.news.data.entity.newssources.NewsSourcesEntity;
import com.clean.news.data.repository.datasource.newssources.CloudNewsSourcesDataStore;
import com.clean.news.data.repository.datasource.newssources.NewsSourcesDataStoreFactory;
import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * @author james on 5/26/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsSourcesDataRepositoryTest {

    private NewsSourcesDataRepository newsSourcesDataRepository;

    @Mock
    private NewsSourceEntityDataMapper newsSourceEntityDataMapper;
    @Mock
    private NewsSourcesDataStoreFactory newsSourcesDataStoreFactory;
    @Mock
    private CloudNewsSourcesDataStore mockNewsSourceDataStore;


    @Before
    public void setUp() {
        newsSourcesDataRepository = new NewsSourcesDataRepository(newsSourceEntityDataMapper, newsSourcesDataStoreFactory);
        given(newsSourcesDataStoreFactory.createNewsSourceCloudDataStore()).willReturn(mockNewsSourceDataStore);
    }

    @Test
    public void getNewsSources_newsSourcesObjectCreated() throws Exception {
        NewsSourcesEntity newsSourcesEntity = new NewsSourcesEntity();
        given(mockNewsSourceDataStore.getNewsSources()).willReturn(Observable.just(newsSourcesEntity));

        newsSourcesDataRepository.getNewsSources();

        verify(newsSourcesDataStoreFactory).createNewsSourceCloudDataStore();
        verify(mockNewsSourceDataStore).getNewsSources();
    }

}