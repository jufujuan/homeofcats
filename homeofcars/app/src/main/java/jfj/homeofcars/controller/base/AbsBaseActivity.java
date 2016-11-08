package jfj.homeofcars.controller.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * activity的基类
 */
public abstract class AbsBaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initDatas();
    }
    //绑定布局
    protected abstract int getLayout();
    //初始化组件
    protected abstract void initView();
    //初始化数据
    protected abstract void initDatas();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * findviewById的简化版
     * 自身的View
     * @return
     */
    protected <T extends View> T bindView(int id){
        return (T) findViewById(id);
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
}
