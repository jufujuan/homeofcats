package jfj.homeofcars.controller.adapter.recyclerview.recommend;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.CommonViewHolder;

/**
 * 推荐更多的适配器
 */
public class ReRecommendMoreRVApter extends RecyclerView.Adapter<CommonViewHolder>{
    private List<String> datas;
    private Context mContext;

    public ReRecommendMoreRVApter(Context context) {
        mContext = context;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }


    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent, R.layout.item_re_recommend);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        holder.setText(R.id.item_re_recommend_tv,datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas!=null&&datas.size()!=0?datas.size():0;
    }
}
