package jfj.homeofcars.controller.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import jfj.homeofcars.R;
import jfj.homeofcars.controller.adapter.viewpager.SelectFraViewpagerAdapter;
import jfj.homeofcars.controller.base.AbsBaseFragment;

/**
 * 一级界面:选车
 */
public class SelectedFragment extends AbsBaseFragment{

    private List<Fragment> mFragments;
    private List<String> mTitles;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private SelectFraViewpagerAdapter mAdapter;

    public static SelectedFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SelectedFragment fragment = new SelectedFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fra_select;
    }

    @Override
    protected void initView() {
        mFragments=new ArrayList<>();
        mTitles=new ArrayList<>();
        mTabLayout=bindView(R.id.fra_select_tablayout);
        mViewPager=bindView(R.id.fra_select_viewpager);
        mAdapter=new SelectFraViewpagerAdapter(getChildFragmentManager(),mContext);
    }

    @Override
    protected void initDatas() {
        mFragments.add(new MineFragment().newInstance());
        mFragments.add(new MineFragment().newInstance());
        mTitles.add("新车");
        mTitles.add("二手车");
        mAdapter.setFragments(mFragments);
        mAdapter.setTitles(mTitles);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
