package jfj.homeofcars.controller.fragment.found;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.MyNetUrlSet;
import jfj.homeofcars.controller.adapter.recyclerview.found.FoundFraRVAdapter;
import jfj.homeofcars.controller.base.AbsBaseFragment;
import jfj.homeofcars.model.bean.FoundBean;
import jfj.homeofcars.model.net.VolleyInstance;
import jfj.homeofcars.model.net.VolleyResult;

/**
 * 一级界面:发现界面
 */
public class FoundFragment extends AbsBaseFragment {
    private FoundBean mFoundBean;
    private FoundBean mNewFoundBean;
    private RecyclerView mRecyclerView;
    private FoundFraRVAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private final static int THREAD_REFRESH=101;//下拉刷新的线程
    private RefreshHandler mHandler;


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
        mRecyclerView = bindView(R.id.fra_found_recyclerview);
        mFoundBean = new FoundBean();
        mAdapter = new FoundFraRVAdapter(mContext);
        GridLayoutManager gridM = new GridLayoutManager(mContext, 30);
        mRecyclerView.setLayoutManager(gridM);
        mSwipeRefreshLayout = bindView(R.id.fra_found_swipeRefreshlayout);
        mHandler=new RefreshHandler();
        mNewFoundBean=new FoundBean();
    }

    @Override
    protected void initDatas() {

        VolleyInstance.getVolleyInstance().startJsonObjectRequest(MyNetUrlSet.URL_FOUND, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Log.d("aaa", "发现界面网络数据获取成功");
                Gson gson = new Gson();
                mFoundBean = gson.fromJson(resultStr, FoundBean.class);
                if (mFoundBean != null) {
                    Log.d("aaa", "发现界面网络数据解析成功");
                } else {
                    Log.d("aaa", "发现界面网络数据解析失败");
                }
                //将网络的到的bean进行调整
                mAdapter.setDatas(changeNetToMy(mFoundBean));
                mRecyclerView.setAdapter(mAdapter);
                mSwipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        //下拉刷新
                        mSwipeRefreshLayout.setRefreshing(true);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                final Message msg=new Message();
                                msg.what=THREAD_REFRESH;
                                VolleyInstance.getVolleyInstance().startJsonObjectRequest(MyNetUrlSet.URL_FOUND, new VolleyResult() {
                                    @Override
                                    public void success(String resultStr) {
                                        Gson gson = new Gson();
                                        mNewFoundBean = gson.fromJson(resultStr, FoundBean.class);
                                        if (mNewFoundBean != null) {
                                            Log.d("aaa", "发现界面网络数据解析成功");
                                        } else {
                                            Log.d("aaa", "发现界面网络数据解析失败");
                                        }
                                        mAdapter.setDatas(changeNetToMy(mNewFoundBean));
                                    }

                                    @Override
                                    public void failure() {

                                    }
                                });
                                mHandler.handleMessage(msg);
                            }
                        }).start();
                    }
                });
            }

            @Override
            public void failure() {
                Log.d("aaa", "发现界面网络数据获取失败");

            }
        });
    }

    /**
     * 为网络得到的实体类添加type
     *
     * @param foundBean
     * @return
     */
    public FoundBean changeNetToMy(FoundBean foundBean) {
        int type = -1;
        for (int i = 0; i < foundBean.getResult().getCardlist().size(); i++) {
            switch (i) {
                case 0:
                    type=0;
                    break;
                case 1:
                    type=1;
                    break;
                case 2:
                    type=4;
                    break;
                case 3:
                    type=5;
                    break;
                case 4:
                    type=6;
                    break;
                case 5:
                    type=7;
                    break;
                case 6:
                    type=7;
                    break;
                case 7:
                    type=8;
                    break;

            }
            foundBean.getResult().getCardlist().get(i).setcType(type);
            for (int j = 0; j < foundBean.getResult().getCardlist().get(i).getData().size(); j++) {
                foundBean.getResult().getCardlist().get(i).getData().get(j).setType(type);
            }
        }
        return foundBean;
    }


    /**
     * 用来刷新加载数据
     */
    class RefreshHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==THREAD_REFRESH){
                mSwipeRefreshLayout.setRefreshing(false);//结束刷新
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdapter.setFlag(false);
    }
}
