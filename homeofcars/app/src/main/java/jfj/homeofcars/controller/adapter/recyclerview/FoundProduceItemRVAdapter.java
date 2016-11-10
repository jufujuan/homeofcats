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
 * 发现界面-田字小号专区--recyclerview--的适配器
 */
public class FoundProduceItemRVAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private List<DataBean> datas;
    private Context mContext;

    public FoundProduceItemRVAdapter(Context context) {
        mContext = context;
    }

    public void setDatas(List<DataBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent, R.layout.item_found_produce_item);
    }

    @Override
    public void onBindViewHolder(final CommonViewHolder holder, final int position) {
        holder.setImg(R.id.item_found_produce_img,datas.get(position).getLogo(),2000,2000,ScaleType.CENTER,Config.ARGB_8888);
        holder.setText(R.id.item_found_produce_title_tv,datas.get(position).getTitle());
        holder.setText(R.id.item_found_produce_subtitle_tv,datas.get(position).getSubtitle());
        holder.setText(R.id.item_found_produce_price_tv,datas.get(position).getPrice());
        holder.setText(R.id.item_found_produce_orPrice_tv,datas.get(position).getFctprice());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
