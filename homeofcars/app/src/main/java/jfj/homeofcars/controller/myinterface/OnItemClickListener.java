package jfj.homeofcars.controller.myinterface;

import android.view.View;

/**
 * recyclerView短按点击事件的接口
 */
public interface OnItemClickListener<T> {
    void OnClickListener(View view,T item);
}
