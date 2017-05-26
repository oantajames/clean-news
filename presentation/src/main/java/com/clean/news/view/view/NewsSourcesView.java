package com.clean.news.view.view;

import com.clean.news.model.newssources.NewsSourcesModel;
import com.clean.news.model.newssources.SourceModel;

/**
 * @author james on 5/22/17.
 */

public interface NewsSourcesView extends LoadDataView {
    void renderNewsSources(NewsSourcesModel newsSourcesModel);

    void viewNews(SourceModel sourceModel);
}
