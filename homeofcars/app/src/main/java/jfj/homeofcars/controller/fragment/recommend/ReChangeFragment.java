package jfj.homeofcars.controller.fragment.recommend;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.MyNetUrlSet;
import jfj.homeofcars.controller.adapter.recyclerview.recommend.ReTestCarFraRVAdapter;
import jfj.homeofcars.controller.base.AbsBaseFragment;
import jfj.homeofcars.model.bean.TestCarBean;
import jfj.homeofcars.model.net.VolleyInstance;
import jfj.homeofcars.model.net.VolleyResult;

/**
 * 推荐界面下的优创页面
 */
public class ReChangeFragment extends AbsBaseFragment{

    private TestCarBean mTestCarBean;
    private RecyclerView mRecyclerView;
    private ReTestCarFraRVAdapter mAdapter;


    public static ReChangeFragment newInstance() {

        Bundle args = new Bundle();

        ReChangeFragment fragment = new ReChangeFragment();
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
        mAdapter=new ReTestCarFraRVAdapter(mContext);
        mTestCarBean=new TestCarBean();
    }

    @Override
    protected void initDatas() {
        VolleyInstance.getVolleyInstance().startRequest(MyNetUrlSet.URL_CHANGE, new VolleyResult() {
            @Override
            public void success(String resultStr) {

                Gson gson=new Gson();
                GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,2);
                mRecyclerView.setLayoutManager(gridLayoutManager);
                mTestCarBean=gson.fromJson(resultStr,TestCarBean.class);
                mAdapter.setDatas(mTestCarBean);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void failure() {
                Log.d("aaa", "推荐界面下的推荐网络数据解析失败");
            }
        });
    }
}
