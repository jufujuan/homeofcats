package jfj.homeofcars.controller.activity;

import android.support.v7.widget.RecyclerView;

import jfj.homeofcars.R;
import jfj.homeofcars.controller.base.AbsBaseActivity;

/**
 * 推荐界面的的更多
 */
public class ReMoreActivity extends AbsBaseActivity{
    private RecyclerView mRecyclerView;
    @Override
    protected int getLayout() {
        return R.layout.ac_recommend_more;
    }

    @Override
    protected void initView() {
        mRecyclerView=bindView(R.id.ac_re_recommend_more_tab_recyclerview);


    }

    @Override
    protected void initDatas() {

    }
}
