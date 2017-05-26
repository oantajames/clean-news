package com.clean.news.mapper;

import com.clean.news.domain.model.news.Article;
import com.clean.news.domain.model.news.News;
import com.clean.news.dagger.PerActivity;
import com.clean.news.model.news.ArticleModel;
import com.clean.news.model.news.NewsModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * @author james on 5/17/17.
 */

@PerActivity
public class NewsModelDataMapper {

    @Inject
    public NewsModelDataMapper() {
    }

    public NewsModel transform(News news) {
        if (news == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        NewsModel newsModel = new NewsModel();
        setArticleModel(news.getArticles(), newsModel);
        newsModel.setSortBy(news.getSortBy());
        newsModel.setSource(news.getSource());
        newsModel.setStatus(news.getStatus());
        return newsModel;
    }

    private void setArticleModel(List<Article> articles, NewsModel news) {
        List<ArticleModel> articleList = new ArrayList<>();
        for (Article article : articles) {
            ArticleModel newArticle = new ArticleModel();
            newArticle.setAuthor(article.getAuthor());
            newArticle.setDescription(article.getDescription());
            newArticle.setPublishedAt(article.getPublishedAt());
            newArticle.setTitle(article.getTitle());
            newArticle.setAuthor(article.getAuthor());
            newArticle.setUrlToImage(article.getUrlToImage());
            newArticle.setUrl(article.getUrl());
            articleList.add(newArticle);
        }
        news.setArticleModels(articleList);
    }

}
