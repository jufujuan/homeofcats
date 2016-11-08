package jfj.homeofcars.controller.fragment;

import android.os.Bundle;

import jfj.homeofcars.R;
import jfj.homeofcars.controller.base.AbsBaseFragment;

/**
 * 一级界面:我
 */
public class FoundFragment extends AbsBaseFragment{
    public static FoundFragment newInstance() {
        
        Bundle args = new Bundle();
        
        FoundFragment fragment = new FoundFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fra_mine;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initDatas() {

    }
}
