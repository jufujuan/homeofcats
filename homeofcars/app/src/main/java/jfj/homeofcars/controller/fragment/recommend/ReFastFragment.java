package jfj.homeofcars.controller.fragment.recommend;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.MyNetUrlSet;
import jfj.homeofcars.controller.adapter.recyclerview.recommend.ReFastFraRVAdapter;
import jfj.homeofcars.controller.base.AbsBaseFragment;
import jfj.homeofcars.model.bean.FastBean;
import jfj.homeofcars.model.net.VolleyInstance;
import jfj.homeofcars.model.net.VolleyResult;

/**
 * 推荐界面下的快报页面
 */
public class ReFastFragment extends AbsBaseFragment{

    private FastBean mFastBean;
    private RecyclerView mRecyclerView;
    private ReFastFraRVAdapter mAdapter;


    public static ReFastFragment newInstance() {

        Bundle args = new Bundle();

        ReFastFragment fragment = new ReFastFragment();
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
        mAdapter=new ReFastFraRVAdapter(mContext);
        mFastBean=new FastBean();
    }

    @Override
    protected void initDatas() {
        VolleyInstance.getVolleyInstance().startRequest(MyNetUrlSet.URL_QUICK, new VolleyResult() {
            @Override
            public void success(String resultStr) {

                Gson gson=new Gson();
                GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,2);
                mRecyclerView.setLayoutManager(gridLayoutManager);
                mFastBean=gson.fromJson(resultStr,FastBean.class);
                mAdapter.setDatas(mFastBean);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void failure() {
                Log.d("aaa", "推荐界面下的推荐网络数据解析失败");
            }
        });
    }
}
