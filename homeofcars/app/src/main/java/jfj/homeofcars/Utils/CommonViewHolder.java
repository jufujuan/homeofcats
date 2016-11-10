package jfj.homeofcars.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.List;

import jfj.homeofcars.View.GlideImageLoader;
import jfj.homeofcars.model.net.VolleyImageResult;
import jfj.homeofcars.model.net.VolleyInstance;

/**
 * 一个通用的ViewHolder
 */
public class CommonViewHolder extends RecyclerView.ViewHolder {
    /**
     * SparesArray用法和hasMap一样(但是key固定是int类型)
     *
     * @param itemView
     */
    private SparseArray<View> views;//用来存放所有的View,key就是View的id
    private View itemView;//行布局

    public CommonViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        views = new SparseArray<>();
    }

    /**
     * 通过该方法获得指定id的控件(用来绑定控件)
     *
     * @param viewId 资源Id
     * @param <T>    所用控件的泛型
     * @return 返回该id对应的控件(如果不在views集合中, 放到集合中)
     */
    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 用于listView
     *
     * @param itemView
     * @param parent
     * @param itemId
     * @return
     */
    public static CommonViewHolder getViewHolder(View itemView, ViewGroup parent, int itemId) {
        CommonViewHolder commonViewHolder;
        if (itemView == null) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(itemId, parent, false);
            commonViewHolder = new CommonViewHolder(itemView);
            itemView.setTag(commonViewHolder);
        } else {
            commonViewHolder = (CommonViewHolder) itemView.getTag();
        }
        return commonViewHolder;
    }

    /**
     * 用于recyclerView
     *
     * @param parent
     * @param itemId
     * @return
     */
    public static CommonViewHolder getViewHolder(ViewGroup parent, int itemId) {
        return getViewHolder(null, parent, itemId);
    }

    /**
     * 返回行布局
     * @return
     */
    public View getItemView() {
        return itemView;
    }
    /********************对外设置控件数据的几种方法*********************/
    /**
     * 为文本框设置数据
     *
     * @param resId 控件的id
     * @param text 需要设置的文本内容
     * @return
     */
    public CommonViewHolder setText(int resId, String text) {
        TextView textView = getView(resId);
        textView.setText(text);
        return this;
    }

    /**
     * 为ImageView设置图片(重载)
     * @param resId 控件Id
     * @param imgId 需要设置的图片的本地资源ID
     * @return
     */
    public CommonViewHolder setImg(int resId,int imgId) {
        ImageView imageView=getView(resId);

        imageView.setImageResource(imgId);
        return this;
    }

    /**
     * 为ImageView设置图片(重载)
     * @param resId 控件Id
     * @param bitmap 需要设置的图片的bitmap(这里应该是网络图片获取后的bitmap)
     * @return
     */
    public CommonViewHolder setImg(int resId, Bitmap bitmap){
        ImageView imageView=getView(resId);
        imageView.setImageBitmap(bitmap);
        return this;
    }
    /**
     * 为ImageView设置图片(重载)
     * @param resId 控件Id
     * @param imgUrl 需要设置的网络图片的网址
     * @return
     */
    public CommonViewHolder setImg(int resId, final String imgUrl, final int width, final int height , final ScaleType scaleType, final Config config){
        final ImageView imageView=getView(resId);
        new Thread(new Runnable() {
            @Override
            public void run() {
                VolleyInstance.getVolleyInstance().starImageRequest(imgUrl, width, height, scaleType, config, new VolleyImageResult() {
                    @Override
                    public void failure() {
                        Log.d("CommonViewHolder", "获取图片失败");
                    }

                    @Override
                    public void success(Bitmap resultStr) {
                        imageView.setImageBitmap(resultStr);
                    }
                });
            }
        }).start();
        return this;
    }

    /**
     * 设置纵向的recyclerview
     * @param context
     * @param count
     * @param resId
     * @param adpater
     * @return
     */
    public CommonViewHolder setRecyclerView(Context context,int count,int resId, RecyclerView.Adapter<CommonViewHolder> adpater){
        RecyclerView recyclerView=getView(resId);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,count);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adpater);
        return this;
    }

    /**
     * 设置横向的recyclerview
     * @param context
     * @param count
     * @param resId
     * @param adpater
     * @return
     */
    public CommonViewHolder setRecyclerViewH(Context context,int count,int resId, RecyclerView.Adapter<CommonViewHolder> adpater){
        RecyclerView recyclerView=getView(resId);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,count);
        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adpater);
        return this;
    }

    /**
     * 设置轮播图控件
     * @return
     */
    public CommonViewHolder setBanner(int resId, int indicatorGravity, int time, int bannerStyle, List<String> images){
        Banner banner=getView(resId);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(indicatorGravity);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(time);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置banner样式
        banner.setBannerStyle(bannerStyle);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        return this;
    }

    /**
     * 为行布局设置监听事件
     * @param listener
     * @return
     */
    public CommonViewHolder setItemClick(View.OnClickListener listener){
        itemView.setOnClickListener(listener);
        return this;
    }

    /**
     * 为控件设置监听事件
     * @param resId
     * @param listener
     * @return
     */
    public CommonViewHolder setViewClick(int resId,View.OnClickListener listener){
        getView(resId).setOnClickListener(listener);
        return this;
    }
}
