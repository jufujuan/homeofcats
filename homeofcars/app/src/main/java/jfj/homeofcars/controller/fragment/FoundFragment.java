package jfj.homeofcars.controller.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.StaticValue;
import jfj.homeofcars.controller.adapter.listview.FoundFraLVAdapter;
import jfj.homeofcars.controller.base.AbsBaseFragment;
import jfj.homeofcars.model.bean.FoundBean;
import jfj.homeofcars.model.net.VolleyInstance;
import jfj.homeofcars.model.net.VolleyResult;

/**
 * 一级界面:发现界面
 */
public class FoundFragment extends AbsBaseFragment {
    private FoundBean mFoundBean;
    private ListView mListView;
    private FoundFraLVAdapter mFoundFraLVAdapter;

    public static FoundFragment newInstance() {

        Bundle args = new Bundle();

        FoundFragment fragment = new FoundFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fra_found;
    }

    @Override
    protected void initView() {
        mListView = bindView(R.id.fra_found_listView);
        mFoundBean = new FoundBean();
        mFoundFraLVAdapter = new FoundFraLVAdapter(mContext);

    }

    @Override
    protected void initDatas() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                VolleyInstance.getVolleyInstance().startJsonObjectRequest(StaticValue.URL_FOUND, new VolleyResult() {
                    @Override
                    public void success(String resultStr) {
                        Log.d("FoundFragment", "发现界面网络数据获取成功");
                        Gson gson = new Gson();
                        mFoundBean = gson.fromJson(resultStr, FoundBean.class);
                        if (mFoundBean!=null){
                            Log.d("FoundFragment", "发现界面网络数据解析成功");
                        }else {
                            Log.d("FoundFragment", "发现界面网络数据解析失败");
                        }
                        mFoundFraLVAdapter.setFoundBean(mFoundBean);
                        mListView.setAdapter(mFoundFraLVAdapter);
                    }

                    @Override
                    public void failure() {
                        Log.d("FoundFragment", "发现界面网络数据获取失败");

                    }
                });
            }
        }).start();
    }



}
