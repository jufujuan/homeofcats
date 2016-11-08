package jfj.homeofcars.controller.fragment;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.StaticValue;
import jfj.homeofcars.Utils.SystemBrightnessUtil;
import jfj.homeofcars.View.CircleDrawable;
import jfj.homeofcars.controller.base.AbsBaseFragment;

/**
 * 一级界面:我
 */
public class MineFragment extends AbsBaseFragment implements OnClickListener {

    private ImageView userImg;
    private TextView modeTv;
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
        userImg=bindView(R.id.fra_mine_user_img);
        modeTv=bindView(R.id.fra_mine_brightness_mode);
        mBrightnessUtil=new SystemBrightnessUtil(mContext);
    }

    @Override
    protected void initDatas() {
        //设置圆形图片
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.ahlib_userpic_default);
        CircleDrawable circleBitmap=new CircleDrawable(bitmap);
        userImg.setImageDrawable(circleBitmap);
        //调节亮度
        modeTv.setOnClickListener(this);
        if (mBrightnessUtil.getSystemBrightness()<= StaticValue.BRIGHTNESS_VALUE) {
            modeTv.setText("日间模式");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fra_mine_brightness_mode:
                if (modeTv.getText().toString().equals("夜间模式"))
                {
                    modeTv.setText("日间模式");
                    //在这里将屏幕设置成夜间模式
                    if (mBrightnessUtil.isAutoBrightness()){
                        mBrightnessUtil.closeAutoBrightness();
                    }
                    mBrightnessUtil.saveBrightness(StaticValue.BRIGHTNESS_VALUE);
                    //在这里将重新设置的这个亮度值存入到sp中
                    SharedPreferences sp=mContext.getSharedPreferences("appuse",MineFragment.this.getActivity().MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putInt("new_brightness",StaticValue.BRIGHTNESS_VALUE);
                    editor.commit();
                }else{
                    modeTv.setText("夜间模式");
                    SharedPreferences sp=mContext.getSharedPreferences("appuse",MineFragment.this.getActivity().MODE_PRIVATE);
                    int newBrightness= sp.getInt("new_brightness",-1);
                    //恢复原来的屏幕亮度
                    int originalBrightness= sp.getInt("original_brightness",-1);
                    //恢复原来的屏幕亮度
                    if (originalBrightness>0) {
                        mBrightnessUtil.saveBrightness(originalBrightness);
                    }
                }
                break;
        }
    }
}
