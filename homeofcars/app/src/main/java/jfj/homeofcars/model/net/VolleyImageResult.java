package jfj.homeofcars.model.net;

import android.graphics.Bitmap;

/**
 * Created by dllo on 16/9/9.
 * Volley的返回回调,用来显示返回成功的方法和返回失败的方法的接口
 */
public interface VolleyImageResult {
    void failure();
    void success(Bitmap resultStr);
}
