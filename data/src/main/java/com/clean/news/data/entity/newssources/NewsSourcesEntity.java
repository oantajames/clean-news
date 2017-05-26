package com.clean.news.data.entity.newssources;

import java.util.List;

public class NewsSourcesEntity {
    private List<SourcesItemEntity> sources;
    private String status;

    public void setSources(List<SourcesItemEntity> sources) {
        this.sources = sources;
    }

    public List<SourcesItemEntity> getSources() {
        return sources;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}