package jfj.homeofcars.controller.adapter.recyclerview.recommend;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.CommonViewHolder;
import jfj.homeofcars.model.bean.ShopBean;

/**
 * "发现"界面的业务接口的recyclerview的适配器
 */
public class ReShopFraRVAdapter extends RecyclerView.Adapter<CommonViewHolder> {

    private ShopBean datas;
    private Context mContext;


    public ReShopFraRVAdapter(Context context) {
        mContext = context;
    }


    public void setDatas(ShopBean datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    /**
     * 获得行布局的type
     *
     * @param position
     * @return
     */
//    @Override
//    public int getItemViewType(int position) {
//        return datas.getResult().getNewslist().get(position).getMediatype();
//    }

    /**
     * 当setAdapter执行的时候执行
     * 跨行显示的时候执行
     *
     * @param recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        final int span = gridLayoutManager.getSpanCount();
        gridLayoutManager.setSpanSizeLookup(new SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //switch (getItemViewType(position)) {
                //    default:
                return span;
                // }
            }
        });

    }

    /**
     * 当view显示到windows中调用该方法
     * 可以在这里加入动画
     *
     * @param holder
     */
    @Override
    public void onViewAttachedToWindow(CommonViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonViewHolder marketVH = CommonViewHolder.getViewHolder(parent, R.layout.item_re_news_center);
        return marketVH;
    }

    @Override
    public void onBindViewHolder(final CommonViewHolder holder, final int position) {
        holder.setText(R.id.item_re_news_center_title,datas.getResult().getNewslist().get(position).getTitle());
        holder.setText(R.id.item_re_news_center_play_count,datas.getResult().getNewslist().get(position).getReplycount()+"评论");
        holder.setText(R.id.item_re_news_center_date,datas.getResult().getNewslist().get(position).getTime());
        holder.setImg(R.id.item_re_news_center_logo,datas.getResult().getNewslist().get(position).getSmallpic(),2000,2000, ScaleType.CENTER, Config.ARGB_8888);

    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.getResult().getNewslist().size();
    }

}
