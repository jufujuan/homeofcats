package jfj.homeofcars.controller.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import jfj.homeofcars.R;
import jfj.homeofcars.View.CircleDrawable;
import jfj.homeofcars.controller.base.AbsBaseFragment;

/**
 * 一级界面:我
 */
public class MineFragment extends AbsBaseFragment{

    private ImageView userImg;

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
    }

    @Override
    protected void initDatas() {
        //设置圆形图片
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.ahlib_userpic_default);
        CircleDrawable circleBitmap=new CircleDrawable(bitmap);
        userImg.setImageDrawable(circleBitmap);
    }
}
