package jfj.homeofcars.controller.myinterface;

import android.view.View;

/**
 * recyclerView长按点击事件
 */
public interface OnItemLongClickListener<T> {
    void onClick(View view,T item);
}
