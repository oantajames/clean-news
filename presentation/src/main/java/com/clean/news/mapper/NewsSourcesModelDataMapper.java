package com.clean.news.mapper;

import com.clean.news.domain.model.newssources.NewsSources;
import com.clean.news.domain.model.newssources.Source;
import com.clean.news.dagger.PerActivity;
import com.clean.news.model.newssources.NewsSourcesModel;
import com.clean.news.model.newssources.SourceModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * @author james on 5/22/17.
 */

@PerActivity
public class NewsSourcesModelDataMapper {

    @Inject
    public NewsSourcesModelDataMapper() {
    }

    public NewsSourcesModel transform(NewsSources newsSources) {
        NewsSourcesModel newsSourcesModel = null;
        if (newsSources != null) {
            newsSourcesModel = new NewsSourcesModel();
            setSourcesItem(newsSources.getSources(), newsSourcesModel);
            newsSourcesModel.setStatus(newsSources.getStatus());
        }
        return newsSourcesModel;
    }

    private void setSourcesItem(List<Source> sources, NewsSourcesModel newsSourcesModel) {
        List<SourceModel> sourceModelList = new ArrayList<>();
        for (Source source : sources) {
            SourceModel sourceModel = new SourceModel();
            sourceModel.setDescription(source.getDescription());
            sourceModel.setCategory(source.getCategory());
            sourceModel.setCountry(source.getCountry());
            sourceModel.setId(source.getId());
            sourceModel.setLanguage(source.getLanguage());
            sourceModel.setUrl(source.getUrl());
            sourceModel.setName(source.getName());
            sourceModel.setSortBysAvailable(source.getSortBysAvailable());
            sourceModelList.add(sourceModel);
        }
        newsSourcesModel.setSources(sourceModelList);
    }
}
