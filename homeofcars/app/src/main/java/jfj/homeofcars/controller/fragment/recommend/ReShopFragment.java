package jfj.homeofcars.controller.fragment.recommend;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.MyNetUrlSet;
import jfj.homeofcars.controller.adapter.recyclerview.recommend.ReShopFraRVAdapter;
import jfj.homeofcars.controller.base.AbsBaseFragment;
import jfj.homeofcars.model.bean.ShopBean;
import jfj.homeofcars.model.net.VolleyInstance;
import jfj.homeofcars.model.net.VolleyResult;

/**
 * 推荐界面下的优创页面
 */
public class ReShopFragment extends AbsBaseFragment{

    private ShopBean mShopBean;
    private RecyclerView mRecyclerView;
    private ReShopFraRVAdapter mAdapter;


    public static ReShopFragment newInstance() {

        Bundle args = new Bundle();

        ReShopFragment fragment = new ReShopFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    protected int setLayout() {
        return R.layout.fra_re_yc;
    }

    @Override
    protected void initView() {
        mRecyclerView=bindView(R.id.fra_re_yc_recyclerview);
        mAdapter=new ReShopFraRVAdapter(mContext);
        mShopBean=new ShopBean();
    }

    @Override
    protected void initDatas() {
        VolleyInstance.getVolleyInstance().startRequest(MyNetUrlSet.URL_SHOP, new VolleyResult() {
            @Override
            public void success(String resultStr) {

                Gson gson=new Gson();
                GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,2);
                mRecyclerView.setLayoutManager(gridLayoutManager);
                mShopBean=gson.fromJson(resultStr,ShopBean.class);
                mAdapter.setDatas(mShopBean);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void failure() {
                Log.d("aaa", "推荐界面下的推荐网络数据解析失败");
            }
        });
    }
}
