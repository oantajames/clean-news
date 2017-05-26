package com.clean.news.domain.model.newssources;

import java.util.List;

public class NewsSources {
    private List<Source> sources;
    private String status;

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}