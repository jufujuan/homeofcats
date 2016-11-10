package jfj.homeofcars.controller.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * fragment的基类
 */
public abstract class AbsBaseFragment extends Fragment{
    protected Context mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setLayout(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDatas();
    }

    /**
     * findviewById的简化版
     * 自身的View
     * @return
     */
    protected <T extends View> T bindView(int id){
        return (T) getView().findViewById(id);
    }

    /**
     *  findViewById的简化版
     *  其他的View
     * @param view
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T bindView(View view,int id){
        return (T) view.findViewById(id);
    }

    //设置布局
    protected abstract int setLayout();
    //初始化组件
    protected abstract void initView();
    //初始化数据
    protected abstract void initDatas();
    /**
     * 设置跳转(不带返回值)
     * 在这里可以设置跳转动画
     */
    protected void goTo(Context context,Class<? extends AbsBaseActivity> to){
        context.startActivity(new Intent(context,to));
    }

}
