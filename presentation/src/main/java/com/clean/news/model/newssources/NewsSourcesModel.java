package com.clean.news.model.newssources;

import java.util.List;

public class NewsSourcesModel {
    private List<SourceModel> sources;
    private String status;

    public void setSources(List<SourceModel> sources) {
        this.sources = sources;
    }

    public List<SourceModel> getSources() {
        return sources;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}