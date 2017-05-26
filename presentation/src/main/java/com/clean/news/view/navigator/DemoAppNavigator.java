package com.clean.news.view.navigator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import com.clean.news.view.newssources.NewsSourceListActivity;
import com.thefinestartist.finestwebview.FinestWebView;
import com.clean.news.presentation.R;
import com.clean.news.view.newslist.NewsListActivity;

/**
 * @author james
 */

public class DemoAppNavigator {

    public void openSourcesActivity(Activity oldActivity, Context context) {
        if (context != null) {
            Intent intent = NewsSourceListActivity.getCallingIntent(context);
            context.startActivity(intent);
            oldActivity.finish();
        }
    }

    public void openNewsListActivity(Context context, String sourceId) {
        if (context != null) {
            Intent intent = NewsListActivity.getCallingIntent(context, sourceId);
            context.startActivity(intent);
        }
    }

    public void openFinesWebViewActivity(Context context, String articleUrl, String articleSource) {
        new FinestWebView.Builder(context).theme(R.style.FinestWebViewTheme)
                .titleDefault(articleSource)
                .showUrl(false)
                .statusBarColorRes(R.color.bluePrimaryDark)
                .toolbarColorRes(R.color.bluePrimary)
                .titleColorRes(R.color.finestWhite)
                .urlColorRes(R.color.bluePrimaryLight)
                .iconDefaultColorRes(R.color.finestWhite)
                .progressBarColorRes(R.color.finestWhite)
                .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                .showSwipeRefreshLayout(true)
                .swipeRefreshColorRes(R.color.bluePrimaryDark)
                .menuSelector(R.drawable.selector_light_theme)
                .menuTextGravity(Gravity.CENTER)
                .menuTextPaddingRightRes(R.dimen.defaultMenuTextPaddingLeft)
                .dividerHeight(0)
                .gradientDivider(false)
                .setCustomAnimations(R.anim.slide_left_in, R.anim.hold, R.anim.hold, R.anim.slide_right_out)
                .show(articleUrl);
    }

}
