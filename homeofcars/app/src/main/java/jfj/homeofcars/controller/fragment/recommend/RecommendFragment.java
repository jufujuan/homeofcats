package jfj.homeofcars.controller.fragment.recommend;

import android.content.Intent;
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
import jfj.homeofcars.Utils.MyStaticValues;
import jfj.homeofcars.Utils.SharedPreferencesUtil;
import jfj.homeofcars.controller.activity.ReMoreActivity;
import jfj.homeofcars.controller.activity.SearchActivity;
import jfj.homeofcars.controller.adapter.viewpager.RecommendFraViewpagerAdapter;
import jfj.homeofcars.controller.base.AbsBaseFragment;

/**
 * 一级界面:推荐
 */
public class RecommendFragment extends AbsBaseFragment implements OnClickListener {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private RecommendFraViewpagerAdapter mViewpagerAdapter;
    private List<Fragment> mFragments;
    private List<String> mTitles;
    private ImageView moreImg,searchImg;
    private final static String SP_RECOMMEND_LIST = "recommend";
    private final static int TYPE_RECOMMEND = 1;
    private final static int TYPE_YC = 2;
    private final static int TYPE_SPEAK = 3;
    private final static int TYPE_VIEDIO = 4;
    private final static int TYPE_FAST = 5;
    private final static int TYPE_MARKET = 6;
    private final static int TYPE_NEWS= 7;
    private final static int TYPE_TESTCAR = 8;
    private final static int TYPE_SHOP = 9;
    private final static int TYPE_USECAR= 10;
    private final static int TYPE_Tel= 11;
    private final static int TYPE_CULTURE = 12;
    private final static int TYPE_CHANGE= 13;
    private int[] type=new int[]{TYPE_RECOMMEND,
            TYPE_YC,TYPE_SPEAK,TYPE_VIEDIO,TYPE_FAST,TYPE_MARKET
    ,TYPE_NEWS,TYPE_TESTCAR,TYPE_SHOP,TYPE_USECAR,TYPE_Tel,TYPE_CULTURE,TYPE_CHANGE};
    private List<Integer> types;

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
        moreImg=bindView(R.id.fra_recommend_more);
        types=new ArrayList<>();
        searchImg=bindView(R.id.ra_recommend_search);
    }

    @Override
    protected void initDatas() {
        for (int i = 0; i <type.length ; i++) {
            types.add(type[i]);
        }
        //查询Sp数据库
        if (SharedPreferencesUtil.getInListSize(mContext, SP_RECOMMEND_LIST) > 0) {
            types.clear();
            types = SharedPreferencesUtil.getIntListValue(mContext, SP_RECOMMEND_LIST);
        } else {
            SharedPreferencesUtil.putIntListValue(mContext, SP_RECOMMEND_LIST,types);
        }
        //这里是更换type的重要逻辑
        chageTab();

        mViewpagerAdapter.setFragments(mFragments);
        mViewpagerAdapter.setTitles(mTitles);
        mViewPager.setAdapter(mViewpagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        moreImg.setOnClickListener(this);
        searchImg.setOnClickListener(this);
    }
    //这里是更换type的重要逻辑
    private void chageTab() {
        for (int i = 0; i < 13; i++) {
            switch (types.get(i)){
                case TYPE_RECOMMEND:
                    mTitles.add("推荐");
                    mFragments.add(new ReRecommendFragment().newInstance());
                    break;
                case TYPE_YC:
                    mTitles.add("优创+");
                    mFragments.add(new ReYCFragment().newInstance());
                    break;
                case TYPE_SPEAK:
                    mTitles.add("说客");
                    mFragments.add(new ReSpeakFragment().newInstance());//说客

                    break;
                case TYPE_VIEDIO:
                    mTitles.add("视频");
                    mFragments.add(new ReVideioFragment().newInstance());
                    break;
                case TYPE_FAST:
                    mTitles.add("快报");
                    mFragments.add(new ReFastFragment().newInstance());//快报
                    break;
                case TYPE_MARKET:
                    mTitles.add("行情");
                    mFragments.add(new ReMarketFragment().newInstance());

                    break;
                case TYPE_NEWS:
                    mTitles.add("新闻");
                    mFragments.add(new ReNewsFragment().newInstance());//新闻

                    break;
                case TYPE_TESTCAR:
                    mTitles.add("评测");
                    mFragments.add(new ReTestCarFragment().newInstance());

                    break;
                case TYPE_SHOP:
                    mTitles.add("导购");
                    mFragments.add(new ReShopFragment().newInstance());
                    break;
                case TYPE_USECAR:
                    mTitles.add("用车");
                    mFragments.add(new ReUseCarsFragment().newInstance());//用车
                    break;
                case TYPE_Tel:
                    mTitles.add("技术");
                    mFragments.add(new ReTeFragment().newInstance());//技术

                    break;
                case TYPE_CULTURE:
                    mTitles.add("文化");
                    mFragments.add(new ReCultureFragment().newInstance());//文化

                    break;
                case TYPE_CHANGE:
                    mTitles.add("改装");
                    mFragments.add(new ReChangeFragment().newInstance());

                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fra_recommend_more:
                startActivityForResult(new Intent(mContext, ReMoreActivity.class), MyStaticValues.CODE_RECOMMEND_TO_MORE);
                break;
            case R.id.ra_recommend_search:
                goTo(mContext, SearchActivity.class);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //查询Sp数据库
        updateTab();
        if (requestCode==MyStaticValues.CODE_RECOMMEND_TO_MORE&&resultCode==MyStaticValues.CODE_MORE_TO_RECOMMEND){
            int currentPosition=data.getIntExtra("position",0);
            mViewPager.setCurrentItem(currentPosition);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateTab();

    }

    /**
     * 更新TabLayout和fragments
     */
    private void updateTab() {
        //查询Sp数据库
        if (SharedPreferencesUtil.getInListSize(mContext, SP_RECOMMEND_LIST) > 0) {
            types.clear();
            mTitles.clear();
            mFragments.clear();
            types = SharedPreferencesUtil.getIntListValue(mContext, SP_RECOMMEND_LIST);
        } else {
            SharedPreferencesUtil.putIntListValue(mContext, SP_RECOMMEND_LIST, types);
        }
        chageTab();
        mViewpagerAdapter.setTitles(mTitles);
        mViewpagerAdapter.setFragments(mFragments);
    }

}
