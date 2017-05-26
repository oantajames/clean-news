package com.clean.news.view.view;

import com.clean.news.model.news.NewsModel;
import com.clean.news.model.news.ArticleModel;

/**
 * @author james on 5/17/17.
 */

public interface NewsView extends LoadDataView {

    void renderNews(NewsModel newsModel);

    void viewNews(ArticleModel articleModel);

}
