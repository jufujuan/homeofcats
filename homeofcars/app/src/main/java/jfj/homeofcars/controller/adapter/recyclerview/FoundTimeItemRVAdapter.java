package jfj.homeofcars.controller.adapter.recyclerview;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;

import java.util.List;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.CommonViewHolder;
import jfj.homeofcars.model.bean.FoundBean.ResultBean.CardlistBean.DataBean;

/**
 * 发现界面-图文限时专区--recyclerview--的适配器
 */
public class FoundTimeItemRVAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private List<DataBean> datas;
    private Context mContext;

    public FoundTimeItemRVAdapter(Context context) {
        mContext = context;
    }

    public void setDatas(List<DataBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent, R.layout.item_found_time_item);
    }

    @Override
    public void onBindViewHolder(final CommonViewHolder holder, final int position) {

        holder.setImg(R.id.item_found_time_item_img,datas.get(position).getImageurl(),2000,2000,ScaleType.CENTER,Config.ARGB_8888);
        holder.setText(R.id.item_found_time_item_title,datas.get(position).getTitle());
        holder.setText(R.id.item_found_time_item_price,datas.get(position).getSubtitle());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
