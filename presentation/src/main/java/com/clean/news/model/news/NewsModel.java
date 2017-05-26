package com.clean.news.model.news;

import java.util.List;

public class NewsModel {
    private String sortBy;
    private String source;
    private List<ArticleModel> articleModels;
    private String status;

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setArticleModels(List<ArticleModel> articleModel) {
        this.articleModels = articleModel;
    }

    public List<ArticleModel> getArticleModels() {
        return articleModels;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}