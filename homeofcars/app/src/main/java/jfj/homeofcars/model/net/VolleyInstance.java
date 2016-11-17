package jfj.homeofcars.model.net;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import jfj.homeofcars.myapp.MyApp;

/**
 * Created by dllo on 16/9/9.
 * Volley使用单例
 */
public class VolleyInstance {
    /**
     * 双重校验法写单例
     */

    private static VolleyInstance volleyInstance;

    private RequestQueue queue;

    //私有化构造方法,外部不能随意的创建对象
    private VolleyInstance(){
       queue= Volley.newRequestQueue(MyApp.getContext());
    }
    //对外提供获取对象的静态方法
    public static VolleyInstance getVolleyInstance(){
        if(volleyInstance ==null){
            synchronized (VolleyInstance.class){
                if (volleyInstance ==null){
                    volleyInstance =new VolleyInstance();
                }
            }
        }
        return volleyInstance;
    }

    /**
     * 对外提供请求方法
     * @param url  输入的请求网址
     * @param result
     */
    public void startRequest(String url, final VolleyResult result){
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                result.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.failure();
            }
        });
        queue.add(stringRequest);
    }
    public void starImageRequest(String url, int maxWidth, int maxHeight, ImageView.ScaleType scaleType, Bitmap.Config config,final VolleyImageResult result){
        ImageRequest imageRequest=new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                result.success(response);
            }
        }, maxWidth, maxHeight, scaleType, config, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.failure();
            }
        });
        queue.add(imageRequest);
    }

    /**
     * 对外提供请求的方法
     * 利用json进行解析
     */
    public void startJsonObjectRequest(String url, final VolleyResult result){
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                result.success(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.failure();
            }
        });
        queue.add(jsonObjectRequest);
    }



}
