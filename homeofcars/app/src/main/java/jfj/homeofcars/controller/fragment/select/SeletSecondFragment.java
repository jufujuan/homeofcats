package jfj.homeofcars.controller.fragment.select;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.MyNetUrlSet;
import jfj.homeofcars.controller.base.AbsBaseFragment;

/**
 * 选车界面的二手车
 */
public class SeletSecondFragment extends AbsBaseFragment{

    private WebView mWebView;

    public static SeletSecondFragment newInstance() {
        Bundle args = new Bundle();
        SeletSecondFragment fragment = new SeletSecondFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fra_select_second;
    }

    @Override
    protected void initView() {
        mWebView=bindView(R.id.fra_select_second_progress_webview);
    }

    @Override
    protected void initDatas() {
        setWebView();
    }

    private void setWebView() {
        //设置WebView属性，能够执行Javascript脚本
        mWebView.getSettings().setJavaScriptEnabled(true);
        //打开网页自适应屏幕
        mWebView.getSettings().setUseWideViewPort(true);//设置此属性可任意比例缩放
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setSupportZoom(true);
       //加载需要显示的网页
        mWebView.loadUrl(MyNetUrlSet.DISCOVER_FIND_CAR);
        mWebView.setWebViewClient(new WebViewClient() {
            //打开网页事不调用系统浏览器,而是在本WebView中显示
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
