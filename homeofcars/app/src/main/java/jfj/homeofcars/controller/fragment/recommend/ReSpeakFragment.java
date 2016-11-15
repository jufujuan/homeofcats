package jfj.homeofcars.controller.fragment.recommend;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.MyNetUrlSet;
import jfj.homeofcars.controller.adapter.recyclerview.recommend.ReSpeakFraRVAdapter;
import jfj.homeofcars.controller.base.AbsBaseFragment;
import jfj.homeofcars.model.bean.SpeakBean;
import jfj.homeofcars.model.net.VolleyInstance;
import jfj.homeofcars.model.net.VolleyResult;

/**
 * 推荐界面下的说客页面
 */
public class ReSpeakFragment extends AbsBaseFragment{

    private SpeakBean mSpeakBean;
    private RecyclerView mRecyclerView;
    private ReSpeakFraRVAdapter mAdapter;


    public static ReSpeakFragment newInstance() {

        Bundle args = new Bundle();

        ReSpeakFragment fragment = new ReSpeakFragment();
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
        mAdapter=new ReSpeakFraRVAdapter(mContext);
        mSpeakBean=new SpeakBean();
    }

    @Override
    protected void initDatas() {
        VolleyInstance.getVolleyInstance().startRequest(MyNetUrlSet.URL_SAY, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson=new Gson();
                GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,2);
                mRecyclerView.setLayoutManager(gridLayoutManager);
                mSpeakBean=gson.fromJson(resultStr,SpeakBean.class);
                mAdapter.setDatas(mSpeakBean);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void failure() {
                Log.d("aaa", "推荐界面下的推荐网络数据解析失败");
            }
        });
    }
}
