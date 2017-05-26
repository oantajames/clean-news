package com.clean.news.data.entity.news;

import java.util.List;

public class NewsEntity {

    private String sortBy;
    private String source;
    private List<ArticleItem> articles;
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

    public void setArticles(List<ArticleItem> articles) {
        this.articles = articles;
    }

    public List<ArticleItem> getArticles() {
        return articles;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}