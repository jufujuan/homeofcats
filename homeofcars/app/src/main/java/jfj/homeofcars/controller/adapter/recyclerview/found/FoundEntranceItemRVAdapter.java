package jfj.homeofcars.controller.adapter.recyclerview.found;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;

import java.util.List;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.CommonViewHolder;
import jfj.homeofcars.model.bean.FoundBean;
import jfj.homeofcars.model.bean.FoundBean.ResultBean.CardlistBean.DataBean;
import jfj.homeofcars.model.net.VolleyImageResult;
import jfj.homeofcars.model.net.VolleyInstance;

/**
 * 发现界面-业务接口--recyclerview--的适配器
 */
public class FoundEntranceItemRVAdapter extends RecyclerView.Adapter<CommonViewHolder>{
    private List<FoundBean.ResultBean.CardlistBean.DataBean> datas;
    private Context mContext;

    public FoundEntranceItemRVAdapter(Context context) {
        mContext = context;
    }

    public void setDatas(List<DataBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent, R.layout.item_found_entrance_item);
    }

    @Override
    public void onBindViewHolder(final CommonViewHolder holder, final int position) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                VolleyInstance.getVolleyInstance().starImageRequest(datas.get(position).getImageurl(), 200, 200, ScaleType.CENTER, Config.ARGB_8888, new VolleyImageResult() {
                    @Override
                    public void failure() {
                        Log.d("aaa", "业务入口的图片获取失败");
                    }

                    @Override
                    public void success(Bitmap resultStr) {
                        holder.setImg(R.id.item_found_entrance_item_img,resultStr);
                    }
                });
            }
        }).start();
        holder.setText(R.id.item_found_entrance_item_tv,datas.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
