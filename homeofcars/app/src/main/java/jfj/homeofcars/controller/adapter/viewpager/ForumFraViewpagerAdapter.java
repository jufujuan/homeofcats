package jfj.homeofcars.controller.adapter.viewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 论坛界面的viewpager的适配器
 */
public class ForumFraViewpagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> mFragments;
    private List<String> mTitles;
    private Context mContext;

    public ForumFraViewpagerAdapter(FragmentManager fm , Context context) {
        super(fm);
        mContext=context;
    }


    public void setFragments(List<Fragment> fragments) {
        mFragments = fragments;
    }

    public void setTitles(List<String> titles) {
        mTitles = titles;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

}
