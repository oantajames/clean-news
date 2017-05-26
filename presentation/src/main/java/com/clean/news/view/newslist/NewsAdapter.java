package com.clean.news.view.newslist;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.clean.news.model.news.ArticleModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.clean.news.presentation.R;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/**
 * @author james on 5/9/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ArticleViewHolder> {

    public interface OnItemClickListener {
        void onNewsClicked(ArticleModel articleModel);
    }

    private List<ArticleModel> articleModelList;
    private final LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;

    @Inject
    NewsAdapter(Context context) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.articleModelList = Collections.emptyList();
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.item_news, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        final ArticleModel newsModel = this.articleModelList.get(position);
        bindView(newsModel, holder);
        holder.itemView.setOnClickListener(onclick -> {
            if (onItemClickListener != null) {
                onItemClickListener.onNewsClicked(newsModel);
            }
        });
    }

    private void bindView(ArticleModel articleModel, ArticleViewHolder holder) {
        Uri uri = Uri.parse(articleModel.getUrlToImage());
        holder.getNewsDraweeView().setImageURI(uri);
        holder.getNewsTitleView().setText(articleModel.getTitle());
        holder.getAuthorViwe().setText(articleModel.getAuthor());
        holder.getNewsInfoView().setText(articleModel.getDescription());
        holder.getDateView().setText(articleModel.getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return (this.articleModelList != null) ? this.articleModelList.size() : 0;
    }

    public void setArticleModelList(List<ArticleModel> articleModelList) {
        this.validateBannersCollection(articleModelList);
        this.articleModelList = articleModelList;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    private void validateBannersCollection(List<ArticleModel> articleModelList) {
        if (articleModelList == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.news_drawee)
        SimpleDraweeView newsDraweeView;
        @BindView(R.id.news_title)
        TextView newsTitleView;
        @BindView(R.id.news_info)
        TextView newsInfoView;
        @BindView(R.id.author_text_view)
        TextView authorViwe;
        @BindView(R.id.date_text_view)
        TextView dateView;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public SimpleDraweeView getNewsDraweeView() {
            return newsDraweeView;
        }

        public TextView getNewsTitleView() {
            return newsTitleView;
        }

        public TextView getNewsInfoView() {
            return newsInfoView;
        }

        public TextView getAuthorViwe() {
            return authorViwe;
        }

        public TextView getDateView() {
            return dateView;
        }
    }

}
