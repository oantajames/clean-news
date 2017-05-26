package com.clean.news.data.repository;

import com.clean.news.data.entity.news.NewsEntity;
import com.clean.news.data.entity.news.NewsEntityDataMapper;
import com.clean.news.data.repository.datasource.news.CloudNewsDataStore;
import com.clean.news.data.repository.datasource.news.NewsDataStoreFactory;
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
public class NewsDataRepositoryTest {

    private static final String FAKE_SOURCE = "fake_source";
    private NewsDataRepository newsDataRepository;

    @Mock
    private NewsEntityDataMapper newsEntityDataMapper;
    @Mock
    private NewsDataStoreFactory newsDataStoreFactory;
    @Mock
    private CloudNewsDataStore mockNewsDataStore;

    @Before
    public void setUp() {
        newsDataRepository = new NewsDataRepository(newsEntityDataMapper, newsDataStoreFactory);
        given(newsDataStoreFactory.createCloudDataStore()).willReturn(mockNewsDataStore);
    }

    @Test
    public void getNews_newsObjectCreated() throws Exception {
        NewsEntity newsEntity = new NewsEntity();
        given(mockNewsDataStore.getNews(FAKE_SOURCE)).willReturn(Observable.just(newsEntity));

        newsDataRepository.getNews(FAKE_SOURCE);

        verify(newsDataStoreFactory).createCloudDataStore();
        verify(mockNewsDataStore).getNews(FAKE_SOURCE);
    }

}