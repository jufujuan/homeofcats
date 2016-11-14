package jfj.homeofcars.controller.activity;

import android.content.SharedPreferences;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.SystemBrightnessUtil;
import jfj.homeofcars.controller.base.AbsBaseActivity;
import jfj.homeofcars.controller.fragment.forum.ForumFragment;
import jfj.homeofcars.controller.fragment.found.FoundFragment;
import jfj.homeofcars.controller.fragment.mine.MineFragment;
import jfj.homeofcars.controller.fragment.recommend.RecommendFragment;
import jfj.homeofcars.controller.fragment.select.SelectedFragment;

public class MainActivity extends AbsBaseActivity {

    private RadioButton recommendRb,forumRb,selectRb,foundRb,mineRb;
    private RadioGroup mRadioGroup;
    private android.support.v4.app.FragmentManager mFragmentManager;
    private android.support.v4.app.FragmentTransaction mFragmentTransaction;
    private SystemBrightnessUtil mBrightnessUtil;


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
        mBrightnessUtil=new SystemBrightnessUtil(MainActivity.this);
    }

    @Override
    protected void initDatas() {
        //将当前的屏幕亮度存储到sp
        SharedPreferences sp=getSharedPreferences("appuse",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt("original_brightness",mBrightnessUtil.getSystemBrightness());
        editor.commit();
        //设置默认状态下的下方选中状态
        recommendRb.setChecked(true);
        //初始状态下显示的fragment
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

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences sp=getSharedPreferences("appuse",MODE_PRIVATE);
        int newBrightness= sp.getInt("new_brightness",-1);
        //恢复原来的屏幕亮度
        if (newBrightness>0) {
            mBrightnessUtil.saveBrightness(newBrightness);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sp=getSharedPreferences("appuse",MODE_PRIVATE);
        int originalBrightness= sp.getInt("original_brightness",-1);
        //恢复原来的屏幕亮度
        if (originalBrightness>0) {
            mBrightnessUtil.saveBrightness(originalBrightness);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sp=getSharedPreferences("appuse",MODE_PRIVATE);
        int originalBrightness= sp.getInt("original_brightness",127);
        //恢复原来的屏幕亮度
        mBrightnessUtil.saveBrightness(originalBrightness);
        //将登陆的状态恢复为false
        SharedPreferences loginState=getSharedPreferences("LoginState",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean("isLogin",false);
        editor.commit();
    }
}
