package com.clean.news.domain.model.news;

import java.util.List;

public class News {
    private String sortBy;
    private String source;
    private List<Article> articles;
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

    public void setArticles(List<Article> article) {
        this.articles = article;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}