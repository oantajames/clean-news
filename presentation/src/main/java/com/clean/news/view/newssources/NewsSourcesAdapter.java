package com.clean.news.view.newssources;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.clean.news.presentation.R;
import com.clean.news.model.newssources.SourceModel;
import com.clean.news.view.utils.NewsSource;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/**
 * @author james on 5/21/17.
 */

public class NewsSourcesAdapter extends RecyclerView.Adapter<NewsSourcesAdapter.NewsSourceViewHolder> {

    public interface OnItemClickListener {
        void onNewsSourceItemClicked(SourceModel sourceModel);
    }

    private List<SourceModel> newsSourceList;
    private final LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;

    @Inject
    public NewsSourcesAdapter(Context context) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.newsSourceList = Collections.emptyList();
    }

    @Override
    public NewsSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.item_news_source, parent, false);
        return new NewsSourceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsSourceViewHolder holder, int position) {
        final SourceModel sourceModel = this.newsSourceList.get(position);
        bindView(sourceModel, holder);
        holder.itemView.setOnClickListener(v -> {
            if (this.onItemClickListener != null) {
                onItemClickListener.onNewsSourceItemClicked(sourceModel);
            }
        });
    }

    private void bindView(SourceModel sourceModel, NewsSourceViewHolder holder) {
        retrieveSourceLogoPath(sourceModel.getId(), holder.getImageView());
        holder.getNewsSourceTitleView().setText(sourceModel.getName());
        holder.getNewsSourceDecriptionView().setText(sourceModel.getDescription());

    }

    @Override
    public int getItemCount() {
        return (this.newsSourceList != null) ? this.newsSourceList.size() : 0;
    }

    public void setArticleModelList(List<SourceModel> sourceModels) {
        this.newsSourceList = sourceModels;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class NewsSourceViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.news_source_drawee_view)
        ImageView newsSourceLogoView;
        @BindView(R.id.news_source_description_text_view)
        TextView newsSourceDecriptionView;
        @BindView(R.id.news_source_title_text_view)
        TextView newsSourceTitleView;

        public NewsSourceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public ImageView getImageView() {
            return newsSourceLogoView;
        }

        public TextView getNewsSourceDecriptionView() {
            return newsSourceDecriptionView;
        }

        public TextView getNewsSourceTitleView() {
            return newsSourceTitleView;
        }
    }

    private void retrieveSourceLogoPath(String source, ImageView imageView) {
        switch (source) {
            case NewsSource.ABC_NEWS:
                imageView.setImageResource(R.drawable.abc_news);
                break;
            case NewsSource.AL_JAZEERA_ENGLISH:
                imageView.setImageResource(R.drawable.aljazeera);
                break;
            case NewsSource.ARC_TECHNICA:
                imageView.setImageResource(R.drawable.ars);
                break;
            case NewsSource.ASSOCIATED_PRESS:
                imageView.setImageResource(R.drawable.associatedpress);
                break;
            case NewsSource.BBC_NEWS:
                imageView.setImageResource(R.drawable.bbc_news);
                break;
            case NewsSource.BBC_SPORT:
                imageView.setImageResource(R.drawable.bbcsport);
                break;
            case NewsSource.BILD:
                imageView.setImageResource(R.drawable.bild);
                break;
            case NewsSource.BLOOMBERG:
                imageView.setImageResource(R.drawable.bloomberg);
                break;
            case NewsSource.BREITBART_NEWS:
                imageView.setImageResource(R.drawable.breitbart);
                break;
            case NewsSource.BUSINESS_INSIDER:
                imageView.setImageResource(R.drawable.businessinsider);
                break;
            case NewsSource.BUSINESS_INSIDER_UK:
                imageView.setImageResource(R.drawable.businessinsider);
                break;
            case NewsSource.BUZZFEED:
                imageView.setImageResource(R.drawable.buzzfeed);
                break;
            case NewsSource.CNN:
                imageView.setImageResource(R.drawable.cnn);
                break;
            case NewsSource.DAILY_MAIL:
                imageView.setImageResource(R.drawable.daily_mail);
                break;
            case NewsSource.ENGADGET:
                imageView.setImageResource(R.drawable.engadget);
                break;
            case NewsSource.ESPN:
                imageView.setImageResource(R.drawable.espn);
                break;
            case NewsSource.FINANCIAL_TIMES:
                imageView.setImageResource(R.drawable.financialtimes);
                break;
            case NewsSource.FORTUNE:
                imageView.setImageResource(R.drawable.fortune);
                break;
            case NewsSource.FOX_SPORTS:
                imageView.setImageResource(R.drawable.fox_sports);
                break;
            case NewsSource.GOOGLE_NEWS:
                imageView.setImageResource(R.drawable.googlenews);
                break;
            case NewsSource.HACKER_NEWS:
                imageView.setImageResource(R.drawable.nationalgeographi);
                break;
            case NewsSource.IGN:
                imageView.setImageResource(R.drawable.ign);
                break;
            case NewsSource.INDEPENDENT:
                imageView.setImageResource(R.drawable.independent);
                break;
            case NewsSource.MASHABLE:
                imageView.setImageResource(R.drawable.mashable);
                break;
            case NewsSource.MTV_NEWS:
                imageView.setImageResource(R.drawable.mtvnews);
                break;
            case NewsSource.NATIONAL_GEOGRAPHIC:
                imageView.setImageResource(R.drawable.nationalgeographi);
                break;
            case NewsSource.WIRTSCHAFTS_WOCHE:
                imageView.setImageResource(R.drawable.nationalgeographi);
                break;
            case NewsSource.WIRED:
                imageView.setImageResource(R.drawable.wired);
                break;
            case NewsSource.USA_TODAY:
                imageView.setImageResource(R.drawable.usatoday);
                break;
            case NewsSource.TIME:
                imageView.setImageResource(R.drawable.time);
                break;
            case NewsSource.THE_WASHINGTON_POST:
                imageView.setImageResource(R.drawable.thewashingtonpost);
                break;
            case NewsSource.THE_WALL_STREET_JOURNAL:
                imageView.setImageResource(R.drawable.thewallstreetjournal);
                break;
            case NewsSource.THE_VERGE:
                imageView.setImageResource(R.drawable.theverge);
                break;
            case NewsSource.THE_TELEGRAPH:
                imageView.setImageResource(R.drawable.thetelegraph);
                break;
            case NewsSource.THE_SPORT_BIBLE:
                imageView.setImageResource(R.drawable.thesportbible);
                break;
            case NewsSource.THE_NEXT_WEB:
                imageView.setImageResource(R.drawable.thenextweb);
                break;
            case NewsSource.THE_NEW_YORK_TIMES:
                imageView.setImageResource(R.drawable.nytimes);
                break;
            case NewsSource.THE_LAD_BIBLE:
                imageView.setImageResource(R.drawable.theladbible);
                break;
            case NewsSource.THE_HUFFINGTON_POST:
                imageView.setImageResource(R.drawable.thehuffingtonpost);
                break;
            case NewsSource.THE_HINDU:
                imageView.setImageResource(R.drawable.nationalgeographi);
                break;
            case NewsSource.THE_GUARDIAN_AU:
                imageView.setImageResource(R.drawable.theguardian);
                break;
            case NewsSource.THE_GUARDIAN:
                imageView.setImageResource(R.drawable.theguardian);
                break;
            case NewsSource.THE_ECONOMIST:
                imageView.setImageResource(R.drawable.theeconomist);
                break;
            case NewsSource.TEN:
                imageView.setImageResource(R.drawable.ten);
                break;
            case NewsSource.TECH_RADAR:
                imageView.setImageResource(R.drawable.techradar);
                break;
            case NewsSource.TALK_SPORT:
                imageView.setImageResource(R.drawable.talksport);
                break;
            case NewsSource.SPIEGEL_ONLINE:
                imageView.setImageResource(R.drawable.spiegelonline);
                break;
            case NewsSource.REUTERS:
                imageView.setImageResource(R.drawable.nationalgeographi);
                break;
            case NewsSource.REDDIT:
                imageView.setImageResource(R.drawable.reddit);
                break;
            case NewsSource.RECODE:
                imageView.setImageResource(R.drawable.recode);
                break;
            case NewsSource.POLYGON:
                imageView.setImageResource(R.drawable.polygon);
                break;
            case NewsSource.NFL_NEWS:
                imageView.setImageResource(R.drawable.nflnews);
                break;
            case NewsSource.NEWS_SCIENTIST:
                imageView.setImageResource(R.drawable.newscientist);
                break;
            case NewsSource.NEW_YORK_MAGAZINE:
                imageView.setImageResource(R.drawable.nymagazine);
                break;
            case NewsSource.NEW_WEEK:
                imageView.setImageResource(R.drawable.nationalgeographi);
                break;
            case NewsSource.MIRROR:
                imageView.setImageResource(R.drawable.mirror);
                break;
            case NewsSource.MTV_NEWS_UK:
                imageView.setImageResource(R.drawable.mtvnewsuk);
                break;
            case NewsSource.FOUR_FOUR_TWO:
                imageView.setImageResource(R.drawable.fourfourtwo);
                break;
            case NewsSource.FOOTBAL_ITALIA:
                imageView.setImageResource(R.drawable.footbalitalia);
                break;
            default:
                imageView.setImageResource(R.drawable.nationalgeographi);
                break;
        }
    }
}
