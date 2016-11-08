package jfj.homeofcars.controller.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import jfj.homeofcars.R;
import jfj.homeofcars.controller.adapter.viewpager.RecommendFraViewpagerAdapter;
import jfj.homeofcars.controller.base.AbsBaseFragment;

/**
 * 一级界面:推荐
 */
public class RecommendFragment extends AbsBaseFragment{
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private RecommendFraViewpagerAdapter mViewpagerAdapter;
    private List<Fragment> mFragments;
    private List<String> mTitles;
    public static RecommendFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RecommendFragment fragment = new RecommendFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fra_recommend;
    }

    @Override
    protected void initView() {
        mTabLayout=bindView(R.id.fra_recommend_tablayout);
        mViewPager=bindView(R.id.fra_recommend_viewpager);
        mViewpagerAdapter=new RecommendFraViewpagerAdapter(getChildFragmentManager(),mContext);
        mFragments=new ArrayList<>();
        mTitles=new ArrayList<>();
    }

    @Override
    protected void initDatas() {
        mFragments.add(new MineFragment().newInstance());
        mFragments.add(new MineFragment().newInstance());
        mFragments.add(new MineFragment().newInstance());
        mFragments.add(new MineFragment().newInstance());
        mFragments.add(new MineFragment().newInstance());
        mFragments.add(new MineFragment().newInstance());
        mFragments.add(new MineFragment().newInstance());
        mFragments.add(new MineFragment().newInstance());
        mFragments.add(new MineFragment().newInstance());
        mFragments.add(new MineFragment().newInstance());
        mFragments.add(new MineFragment().newInstance());
        mFragments.add(new MineFragment().newInstance());
        mFragments.add(new MineFragment().newInstance());
        mTitles.add("推荐");
        mTitles.add("优创+");
        mTitles.add("说客");
        mTitles.add("视频");
        mTitles.add("快报");
        mTitles.add("行情");
        mTitles.add("新闻");
        mTitles.add("评测");
        mTitles.add("导购");
        mTitles.add("用车");
        mTitles.add("技术");
        mTitles.add("文化");
        mTitles.add("改装");
        mViewpagerAdapter.setFragments(mFragments);
        mViewpagerAdapter.setTitles(mTitles);
        mViewPager.setAdapter(mViewpagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
