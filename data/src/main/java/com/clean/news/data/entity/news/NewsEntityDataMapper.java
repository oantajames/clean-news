package com.clean.news.data.entity.news;

import com.clean.news.domain.model.news.Article;
import com.clean.news.domain.model.news.News;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author james on 5/5/17.
 */

@Singleton
public class NewsEntityDataMapper {

    @Inject
    public NewsEntityDataMapper() {
    }

    public News transform(NewsEntity newsEntity) {
        News news = null;
        if (newsEntity != null) {
            news = new News();
            setArticles(newsEntity.getArticles(), news);
            news.setSortBy(newsEntity.getSortBy());
            news.setSource(newsEntity.getSource());
            news.setStatus(newsEntity.getStatus());
        }
        return news;
    }

    private void setArticles(List<ArticleItem> articles, News news) {
        List<Article> articleList = new ArrayList<>();
        for (ArticleItem article : articles) {
            Article newArticle = new Article();
            newArticle.setAuthor(article.getAuthor());
            newArticle.setDescription(article.getDescription());
            newArticle.setPublishedAt(article.getPublishedAt());
            newArticle.setTitle(article.getTitle());
            newArticle.setAuthor(article.getAuthor());
            newArticle.setUrlToImage(article.getUrlToImage());
            newArticle.setUrl(article.getUrl());
            articleList.add(newArticle);
        }
        news.setArticles(articleList);
    }

    public List<News> transform(List<NewsEntity> newsEntityList) {
        final List<News> newsList = new ArrayList<>();
        for (NewsEntity newsEntity : newsEntityList) {
            final News newsItem = transform(newsEntity);
            if (newsItem != null) {
                newsList.add(newsItem);
            }
        }
        return newsList;
    }
}
