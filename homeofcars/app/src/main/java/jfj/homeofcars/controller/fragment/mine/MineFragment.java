package jfj.homeofcars.controller.fragment.mine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.SystemBrightnessUtil;
import jfj.homeofcars.View.CircleDrawable;
import jfj.homeofcars.controller.activity.LoginActivity;
import jfj.homeofcars.controller.base.AbsBaseFragment;

/**
 * 一级界面:我
 */
public class MineFragment extends AbsBaseFragment implements OnClickListener {

    private ImageView userImg;
    private TextView modeTv,nameTv;
    private SystemBrightnessUtil mBrightnessUtil;

    public static MineFragment newInstance() {

        Bundle args = new Bundle();

        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fra_mine;
    }

    @Override
    protected void initView() {
        userImg = bindView(R.id.fra_mine_user_img);
        modeTv = bindView(R.id.fra_mine_brightness_mode);
        mBrightnessUtil = new SystemBrightnessUtil(mContext);
        nameTv=bindView(R.id.fra_mine_user_name_tv);
    }

    @Override
    protected void initDatas() {
        //设置圆形图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ahlib_userpic_default);
        CircleDrawable circleBitmap = new CircleDrawable(bitmap);
        userImg.setImageDrawable(circleBitmap);
        //调节亮度
        modeTv.setOnClickListener(this);
        userImg.setOnClickListener(this);
        SharedPreferences sp=mContext.getSharedPreferences("LoginState",mContext.MODE_PRIVATE);
        if (sp.getBoolean("isLogin",false)){
            nameTv.setText(sp.getString("name","请登录"));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fra_mine_brightness_mode:
                setBrightnessMode();
                break;
            case R.id.fra_mine_user_img:
                //goTo(mContext, LoginActivity.class);
                Intent intent=new Intent(mContext, LoginActivity.class);
                //Log.d("aaa", "触发点击事件");
                startActivityForResult(intent,102);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==102&&resultCode==103){
            String name=data.getStringExtra("name");
            nameTv.setText(name);
            //将登陆的状态存储到sp中
            SharedPreferences sp=mContext.getSharedPreferences("LoginState",mContext.MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.putBoolean("isLogin",true);
            editor.putString("name",name);
            editor.commit();
        }

    }

    /**
     * 设置夜间和日间模式
     */
    private void setBrightnessMode() {
        if (modeTv.getText().toString().equals("夜间模式")) {
            modeTv.setText("日间模式");
            //在这里将屏幕设置成夜间模式
            if (mBrightnessUtil.isAutoBrightness()) {
                mBrightnessUtil.closeAutoBrightness();
            }

            //在这里将重新设置的这个亮度值存入到sp中
            SharedPreferences sp = mContext.getSharedPreferences("appuse", MineFragment.this.getActivity().MODE_PRIVATE);
            mBrightnessUtil.saveBrightness(sp.getInt("original_brightness", 254) / 2);
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("new_brightness", sp.getInt("original_brightness", 254) / 2);
            editor.commit();
        } else {
            modeTv.setText("夜间模式");
            SharedPreferences sp = mContext.getSharedPreferences("appuse", MineFragment.this.getActivity().MODE_PRIVATE);
            int newBrightness = sp.getInt("new_brightness", -1);
            //恢复原来的屏幕亮度
            int originalBrightness = sp.getInt("original_brightness", -1);
            //恢复原来的屏幕亮度
            if (originalBrightness > 0) {
                mBrightnessUtil.saveBrightness(originalBrightness);
            }
        }
    }
}
