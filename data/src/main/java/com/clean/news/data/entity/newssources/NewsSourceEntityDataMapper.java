package com.clean.news.data.entity.newssources;

import com.clean.news.domain.model.newssources.NewsSources;
import com.clean.news.domain.model.newssources.Source;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author james on 5/22/17.
 */
@Singleton
public class NewsSourceEntityDataMapper {

    @Inject
    public NewsSourceEntityDataMapper() {
    }

    public NewsSources transform(NewsSourcesEntity newsSourcesEntity) {
        NewsSources newsSources = null;
        if (newsSourcesEntity != null) {
            newsSources = new NewsSources();
            setSourcesItem(newsSourcesEntity.getSources(), newsSources);
            newsSources.setStatus(newsSourcesEntity.getStatus());
        }
        return newsSources;
    }

    private void setSourcesItem(List<SourcesItemEntity> sourcesItemEntities, NewsSources newsSources) {
        List<Source> sourceList = new ArrayList<>();
        for (SourcesItemEntity sourcesItemEntity : sourcesItemEntities) {
            Source source = new Source();
            source.setDescription(sourcesItemEntity.getDescription());
            source.setCategory(sourcesItemEntity.getCategory());
            source.setCountry(sourcesItemEntity.getCountry());
            source.setId(sourcesItemEntity.getId());
            source.setLanguage(sourcesItemEntity.getLanguage());
            source.setUrl(sourcesItemEntity.getUrl());
            source.setName(sourcesItemEntity.getName());
            source.setSortBysAvailable(sourcesItemEntity.getSortBysAvailable());
            sourceList.add(source);
        }
        newsSources.setSources(sourceList);
    }

}
