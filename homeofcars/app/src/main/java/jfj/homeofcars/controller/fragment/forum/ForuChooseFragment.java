package jfj.homeofcars.controller.fragment.forum;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.MyNetUrlSet;
import jfj.homeofcars.controller.adapter.recyclerview.recommend.ReChooseFraRVAdapter;
import jfj.homeofcars.controller.base.AbsBaseFragment;
import jfj.homeofcars.model.bean.ChooseForumBean;
import jfj.homeofcars.model.net.VolleyInstance;
import jfj.homeofcars.model.net.VolleyResult;

/**
 * 论坛下的精选
 */
public class ForuChooseFragment extends AbsBaseFragment{
    private ChooseForumBean mChooseForumBean;
    private RecyclerView mRecyclerView;
    private ReChooseFraRVAdapter mAdapter;


    public static ForuChooseFragment newInstance() {

        Bundle args = new Bundle();

        ForuChooseFragment fragment = new ForuChooseFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    protected int setLayout() {
        return R.layout.fra_forum_choose;
    }

    @Override
    protected void initView() {
        mRecyclerView=bindView(R.id.fra_forum_choose_recyclerview);
        mAdapter=new ReChooseFraRVAdapter(mContext);
        mChooseForumBean=new ChooseForumBean();
    }

    @Override
    protected void initDatas() {
        VolleyInstance.getVolleyInstance().startRequest(MyNetUrlSet.URL_FORUM_CHOOSE, new VolleyResult() {
            @Override
            public void success(String resultStr) {

                Gson gson=new Gson();
                GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,2);
                mRecyclerView.setLayoutManager(gridLayoutManager);
                mChooseForumBean=gson.fromJson(resultStr,ChooseForumBean.class);
                mAdapter.setDatas(mChooseForumBean);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void failure() {
                Log.d("aaa", "推荐界面下的推荐网络数据解析失败");
            }
        });
    }
}
