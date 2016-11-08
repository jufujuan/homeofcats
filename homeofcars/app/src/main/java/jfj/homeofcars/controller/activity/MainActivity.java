package jfj.homeofcars.controller.activity;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import jfj.homeofcars.R;
import jfj.homeofcars.controller.base.AbsBaseActivity;
import jfj.homeofcars.controller.fragment.ForumFragment;
import jfj.homeofcars.controller.fragment.FoundFragment;
import jfj.homeofcars.controller.fragment.MineFragment;
import jfj.homeofcars.controller.fragment.RecommendFragment;
import jfj.homeofcars.controller.fragment.SelectedFragment;

public class MainActivity extends AbsBaseActivity {

    private RadioButton recommendRb,forumRb,selectRb,foundRb,mineRb;
    private RadioGroup mRadioGroup;
    private android.support.v4.app.FragmentManager mFragmentManager;
    private android.support.v4.app.FragmentTransaction mFragmentTransaction;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        recommendRb=bindView(R.id.ac_main_recommend);
        forumRb=bindView(R.id.ac_main_forum);
        selectRb=bindView(R.id.ac_main_select);
        foundRb=bindView(R.id.ac_main_found);
        mineRb=bindView(R.id.ac_main_mine);
        mRadioGroup=bindView(R.id.ac_main_radiogroup);
        mFragmentManager=getSupportFragmentManager();
        mFragmentTransaction=mFragmentManager.beginTransaction();
    }

    @Override
    protected void initDatas() {
        mFragmentTransaction.replace(R.id.ac_main_farmelayout,new RecommendFragment().newInstance());
        mFragmentTransaction.commit();
        mRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                android.support.v4.app.FragmentTransaction transaction=mFragmentManager.beginTransaction();
                switch (i){
                    case R.id.ac_main_recommend:
                        transaction.replace(R.id.ac_main_farmelayout,new RecommendFragment().newInstance());
                        break;
                    case R.id.ac_main_forum:
                        transaction.replace(R.id.ac_main_farmelayout,new ForumFragment().newInstance());
                        break;
                    case R.id.ac_main_select:
                        transaction.replace(R.id.ac_main_farmelayout,new SelectedFragment().newInstance());
                        break;
                    case R.id.ac_main_found:
                        transaction.replace(R.id.ac_main_farmelayout,new FoundFragment().newInstance());
                        break;
                    case R.id.ac_main_mine:
                        transaction.replace(R.id.ac_main_farmelayout,new MineFragment().newInstance());
                        break;
                }
                transaction.commit();
            }
        });

    }

}
