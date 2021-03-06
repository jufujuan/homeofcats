package jfj.homeofcars.controller.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.MyNetUrlSet;
import jfj.homeofcars.View.AutoDeleteEditText;
import jfj.homeofcars.View.ProgressWebView;
import jfj.homeofcars.controller.adapter.listview.SearchAcLVAdapter;
import jfj.homeofcars.controller.base.AbsBaseActivity;
import jfj.homeofcars.model.bean.KeyBean;
import jfj.homeofcars.model.db.LiteOrmInstance;
import jfj.homeofcars.model.net.VolleyInstance;
import jfj.homeofcars.model.net.VolleyResult;


/**
 * 搜索界面
 */
public class SearchActivity extends AbsBaseActivity implements OnClickListener {

    private AutoDeleteEditText searchEt;
    private TextView deleteBtn;
    private String inputStr;
    private ListView resultLV;
    private KeyBean mKeyBean;
    private SearchAcLVAdapter mAdapter;
    private FragmentManager mManager;
    private Boolean isAuto;//用于判断是否是通过点击获得文本
    private ProgressWebView mWebView;
    private TextView historyDeleteTv;
    private ImageView historyDeleteImg;
    private LinearLayout historyLL;

    @Override
    protected int getLayout() {
        return R.layout.ac_search;
    }

    @Override
    protected void initView() {
        searchEt = bindView(R.id.ac_search_et);
        deleteBtn = bindView(R.id.ac_search_delete);
        resultLV = bindView(R.id.ac_search_listview);
        mAdapter = new SearchAcLVAdapter(SearchActivity.this);
        mKeyBean = new KeyBean();
        mManager = getSupportFragmentManager();
        isAuto = false;
        mWebView = bindView(R.id.ac_search_webview);
        historyDeleteImg=bindView(R.id.ac_search_history_delete_img);
        historyDeleteTv=bindView(R.id.ac_search_history_delete_tv);
        historyLL=bindView(R.id.ac_search_history_ll);
    }

    @Override
    protected void initDatas() {
        historyLL.setVisibility(View.GONE);
        mWebView.setVisibility(View.GONE);
        deleteBtn.setOnClickListener(this);
        inputStr = searchEt.getText().toString();
        searchEt.addTextChangedListener(new TextChangeListener());
        historyDeleteImg.setOnClickListener(this);
        historyDeleteTv.setOnClickListener(this);
        resultLV.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                resultLV.setVisibility(View.GONE);
                searchEt.setText(mKeyBean.getResult().getWordlist().get(i).getName());
                isAuto = true;
                mWebView.setVisibility(View.VISIBLE);
                setWebView();
                //查重
                if(LiteOrmInstance.getInstance().getQueryByWhere(KeyBean.ResultBean.WordlistBean.class,
                        "name",new String[]{mKeyBean.getResult().getWordlist().get(i).getName()}).size()==0){
                    LiteOrmInstance.getInstance().insert(mKeyBean.getResult().getWordlist().get(i));
                }else{
                    //数据库中存在这条数据,我就不存了
                }
            }
        });
    }

    private void setWebView() {
        //设置WebView属性，能够执行Javascript脚本
        mWebView.getSettings().setJavaScriptEnabled(true);
        //打开网页自适应屏幕
        mWebView.getSettings().setUseWideViewPort(true);//设置此属性可任意比例缩放
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setSupportZoom(true);
        StringBuffer buffer = new StringBuffer(MyNetUrlSet.URL_STR_SEARCH);
        String urlStr = buffer.replace(buffer.indexOf("替换字符串"), buffer.indexOf("替换字符串") + 5, searchEt.getText().toString()).toString();
        //加载需要显示的网页
        mWebView.loadUrl(urlStr);
        mWebView.setWebViewClient(new WebViewClient() {
            //打开网页事不调用系统浏览器,而是在本WebView中显示
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ac_search_delete:
                finish();
                break;
            case R.id.ac_search_history_delete_tv:
                showDialog();
                break;
            case R.id.ac_search_history_delete_img:
                showDialog();
                break;
        }
    }

    /**
     * 用来显示dialog(提示是否删除缓存)
     */
    private void showDialog() {
        final AlertDialog dialog=new Builder(SearchActivity.this).create();
        dialog.setMessage("是否清空历史记录");
        dialog.setButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                LiteOrmInstance.getInstance().delete(KeyBean.ResultBean.WordlistBean.class);
                historyLL.setVisibility(View.GONE);
                dialog.dismiss();
                mAdapter.setDatas(null);
            }
        });
        dialog.setButton2("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    public class TextChangeListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (!searchEt.getText().toString().isEmpty()) {
                if (isAuto) {
                    //如果是自动设置的输入框,隐藏历史
                    historyLL.setVisibility(View.GONE);
                    mWebView.setVisibility(View.GONE);
                    resultLV.setVisibility(View.VISIBLE);
                }
                historyLL.setVisibility(View.GONE);
                isAuto = false;
                inputStr = searchEt.getText().toString();
                //进行字符串的拼接
                StringBuffer buffer = new StringBuffer(MyNetUrlSet.URL_KEY_SEARCH);
                final String currentUrl = buffer.replace(buffer.indexOf("替换字符串"), buffer.indexOf("替换字符串") + 5, inputStr).toString();
                VolleyInstance.getVolleyInstance().startRequest(currentUrl, new VolleyResult() {
                    @Override
                    public void success(String resultStr) {
                        Gson gson = new Gson();
                        mKeyBean = gson.fromJson(resultStr, KeyBean.class);
                        if (!inputStr.isEmpty()) {
                            Log.d("aaa", "搜索数据集的大小:" + mKeyBean.getResult().getWordlist().size());
                            mAdapter.setDatas(mKeyBean.getResult().getWordlist());
                        } else {
                            mAdapter.setDatas(null);
                        }
                        resultLV.setAdapter(mAdapter);
                    }

                    @Override
                    public void failure() {

                    }
                });
            }else{
                //当搜索框为空的时候显示历史记录
                historyLL.setVisibility(View.VISIBLE);
                resultLV.setVisibility(View.VISIBLE);
                mWebView.setVisibility(View.GONE);
                List<KeyBean.ResultBean.WordlistBean> beans=LiteOrmInstance.getInstance().getQueryAll(KeyBean.ResultBean.WordlistBean.class);
                mAdapter.setDatas(beans);
            }


        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
}
