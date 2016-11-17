package jfj.homeofcars.controller.fragment.forum;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import jfj.homeofcars.R;
import jfj.homeofcars.controller.activity.SearchActivity;
import jfj.homeofcars.controller.adapter.viewpager.ForumFraViewpagerAdapter;
import jfj.homeofcars.controller.base.AbsBaseFragment;

/**
 * 一级界面:论坛
 */
public class ForumFragment extends AbsBaseFragment implements OnClickListener {

    private List<Fragment> mFragments;
    private List<String> mTitles;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ForumFraViewpagerAdapter mForumFraViewpagerAdapter;
    private ImageView searchImg;

    public static ForumFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ForumFragment fragment = new ForumFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fra_forum;
    }

    @Override
    protected void initView() {
        mFragments=new ArrayList<>();
        mTitles=new ArrayList<>();
        mTabLayout=bindView(R.id.fra_forum_tablayout);
        mViewPager=bindView(R.id.fra_forum_viewpager);
        mForumFraViewpagerAdapter=new ForumFraViewpagerAdapter(getChildFragmentManager(),mContext);
        searchImg=bindView(R.id.fra_forum_search);
    }

    @Override
    protected void initDatas() {
        mFragments.add(new ForuChooseFragment().newInstance());
        mFragments.add(new ForumAllFragment().newInstance());
        mTitles.add("精选");
        mTitles.add("论坛");
        mForumFraViewpagerAdapter.setFragments(mFragments);
        mForumFraViewpagerAdapter.setTitles(mTitles);
        mViewPager.setAdapter(mForumFraViewpagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        searchImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fra_forum_search:
                goTo(mContext, SearchActivity.class);
                break;
        }
    }
}
