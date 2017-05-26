package com.clean.news.data.entity.news;

import com.clean.news.domain.model.news.Article;
import com.clean.news.domain.model.news.News;
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
public class NewsEntityDataMapperTest {

    private final static String FAKE_STATUS = "fake-status";
    private final static String FAKE_TITLE = "fake-tile";

    private NewsEntityDataMapper newsEntityDataMapper;

    @Before
    public void setUp() {
        this.newsEntityDataMapper = new NewsEntityDataMapper();
    }

    @Test
    public void transform_withNewsEntity_resultsNews() throws Exception {
        NewsEntity newsEntity = createFakeNewsEntity();

        News news = newsEntityDataMapper.transform(newsEntity);

        assertThat(news, is(instanceOf(News.class)));
        assertThat(news.getStatus(), is(FAKE_STATUS));
        assertThat(news.getArticles().get(0), is(instanceOf(Article.class)));
        assertThat(news.getArticles().get(0).getTitle(), is(FAKE_TITLE));
    }

    @Test
    public void transform_withNewsEntityList_resultNewsList() throws Exception {// TODO: 5/24/17
    }

    private NewsEntity createFakeNewsEntity() {
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setStatus(FAKE_STATUS);
        newsEntity.setArticles(createFakeArticleItemList());
        newsEntity.setArticles(createFakeArticleItemList());
        return newsEntity;
    }

    private List<ArticleItem> createFakeArticleItemList() {
        List<ArticleItem> articleItemList = new ArrayList<>(1);
        ArticleItem articleItem = new ArticleItem();
        articleItem.setTitle(FAKE_TITLE);
        articleItemList.add(articleItem);
        return articleItemList;
    }

}