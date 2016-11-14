package jfj.homeofcars.controller.fragment.recommend;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.MyNetUrlSet;
import jfj.homeofcars.controller.adapter.recyclerview.recommend.ReRecommendFraRVAdapter;
import jfj.homeofcars.controller.base.AbsBaseFragment;
import jfj.homeofcars.model.bean.RecommendBean;
import jfj.homeofcars.model.net.VolleyInstance;
import jfj.homeofcars.model.net.VolleyResult;

/**
 * 推荐界面下的推荐页面
 */
public class ReRecommendFragment extends AbsBaseFragment{

    private RecommendBean mRecommendBean;
    private RecyclerView mRecyclerView;
    private ReRecommendFraRVAdapter mAdapter;


    public static ReRecommendFragment newInstance() {

        Bundle args = new Bundle();

        ReRecommendFragment fragment = new ReRecommendFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    protected int setLayout() {
        return R.layout.fra_re_recommend;
    }

    @Override
    protected void initView() {
        mRecyclerView=bindView(R.id.fra_re_recommend_recyclerview);
        mAdapter=new ReRecommendFraRVAdapter(mContext);
        mRecommendBean=new RecommendBean();
    }

    @Override
    protected void initDatas() {
        VolleyInstance.getVolleyInstance().startRequest(MyNetUrlSet.URL_NEW, new VolleyResult() {
            @Override
            public void success(String resultStr) {

                Gson gson=new Gson();
                GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,2);
                mRecyclerView.setLayoutManager(gridLayoutManager);
                mRecommendBean=gson.fromJson(resultStr,RecommendBean.class);
                mAdapter.setDatas(mRecommendBean);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void failure() {
                Log.d("aaa", "推荐界面下的推荐网络数据解析失败");
            }
        });
    }
}
