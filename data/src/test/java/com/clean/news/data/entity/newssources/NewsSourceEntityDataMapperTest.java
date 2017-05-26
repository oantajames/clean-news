package com.clean.news.data.entity.newssources;

import com.clean.news.domain.model.newssources.NewsSources;
import com.clean.news.domain.model.newssources.Source;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author james on 5/24/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsSourceEntityDataMapperTest {

    private final static String FAKE_STATUS = "fake_status";
    private final static String NAME = "name";

    private NewsSourceEntityDataMapper newsSourceEntityDataMapper;

    @Before
    public void setUp() {
        newsSourceEntityDataMapper = new NewsSourceEntityDataMapper();
    }

    @Test
    public void transform_withNewsSourceEntity_resultsNewsSource() throws Exception {
        NewsSourcesEntity newsSourcesEntity = createFakeNewsSourcesEntity();

        NewsSources newsSources = this.newsSourceEntityDataMapper.transform(newsSourcesEntity);

        assertThat(newsSources, is(instanceOf(NewsSources.class)));
        assertThat(newsSources.getSources().get(0), is(instanceOf(Source.class)));
        assertThat(newsSources.getStatus(), is(FAKE_STATUS));
        assertThat(newsSources.getSources().get(0).getName(), is(NAME));
    }

    private NewsSourcesEntity createFakeNewsSourcesEntity() {
        NewsSourcesEntity newsSourcesEntity = new NewsSourcesEntity();
        newsSourcesEntity.setSources(createFakeArticleItemList());
        newsSourcesEntity.setStatus("fake_status");
        return newsSourcesEntity;
    }

    private List<SourcesItemEntity> createFakeArticleItemList() {
        List<SourcesItemEntity> articleItemList = new ArrayList<>(1);
        SourcesItemEntity sourceItemEntity = new SourcesItemEntity();
        sourceItemEntity.setName(NAME);

        articleItemList.add(sourceItemEntity);
        return articleItemList;
    }

}