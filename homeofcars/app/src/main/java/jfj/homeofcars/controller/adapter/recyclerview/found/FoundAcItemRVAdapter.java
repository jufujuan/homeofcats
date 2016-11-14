package jfj.homeofcars.controller.adapter.recyclerview.found;

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
public class FoundAcItemRVAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private List<DataBean> datas;
    private Context mContext;

    public FoundAcItemRVAdapter(Context context) {
        mContext = context;
    }

    public void setDatas(List<DataBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent, R.layout.item_found_activity_item);
    }

    @Override
    public void onBindViewHolder(final CommonViewHolder holder, final int position) {
        holder.setImg(R.id.item_found_activity_item_img,datas.get(position).getImageurl(),2000,2000,ScaleType.CENTER,Config.ARGB_8888);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
