package jfj.homeofcars.controller.fragment.forum;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import jfj.homeofcars.R;
import jfj.homeofcars.controller.base.AbsBaseFragment;

/**
 * 论坛下的论坛
 */
public class ForumAllFragment extends AbsBaseFragment{

    private LinearLayout historyLL,nullLL;
    private ListView historyLV;

    public static ForumAllFragment newInstance() {

        Bundle args = new Bundle();

        ForumAllFragment fragment = new ForumAllFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fra_forum_forum;
    }

    @Override
    protected void initView() {
        historyLL=bindView(R.id.fra_forum_history_ll);
        nullLL=bindView(R.id.fra_forum_null_ll);
        historyLV=bindView(R.id.fra_forum_history_listview);
    }

    @Override
    protected void initDatas() {
        historyLL.setVisibility(View.GONE);
        historyLV.setVisibility(View.GONE);

    }
}
