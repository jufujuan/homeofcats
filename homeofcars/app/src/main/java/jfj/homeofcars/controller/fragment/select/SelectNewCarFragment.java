package jfj.homeofcars.controller.fragment.select;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import jfj.homeofcars.R;
import jfj.homeofcars.controller.base.AbsBaseFragment;
import jfj.homeofcars.model.bean.HotCarBean;

/**
 * 选车界面的新车
 */
public class SelectNewCarFragment extends AbsBaseFragment{

    private HotCarBean mHotCarBean;
    private RecyclerView hotRecyclerview;

    public static SelectNewCarFragment newInstance() {
        Bundle args = new Bundle();
        SelectNewCarFragment fragment = new SelectNewCarFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fra_select_new;
    }

    @Override
    protected void initView() {
        hotRecyclerview=bindView(R.id.fra_select_new_hot_recyclerview);
    }

    @Override
    protected void initDatas() {

    }
}
