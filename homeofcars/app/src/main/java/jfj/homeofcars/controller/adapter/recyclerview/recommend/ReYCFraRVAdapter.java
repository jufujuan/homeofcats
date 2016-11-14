package jfj.homeofcars.controller.adapter.recyclerview.recommend;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.CommonViewHolder;
import jfj.homeofcars.model.bean.ReYCBean;

/**
 * "发现"界面的业务接口的recyclerview的适配器
 */
public class ReYCFraRVAdapter extends RecyclerView.Adapter<CommonViewHolder> {

    private ReYCBean datas;
    private Context mContext;
    private final static int TYPE_V=3;//带视频大图
    private final static int TYPE_SMALL=1;//主编有话要说


    public ReYCFraRVAdapter(Context context) {
        mContext = context;
    }


    public void setDatas(ReYCBean datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    /**
     * 获得行布局的type
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return datas.getResult().getNewslist().get(position).getMediatype();
    }

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
        switch (viewType) {
            case TYPE_V://带视频大图
                CommonViewHolder flovarVH = CommonViewHolder.getViewHolder(parent, R.layout.item_re_yc_big_v);
                return flovarVH;
            case TYPE_SMALL:
                CommonViewHolder smallVH = CommonViewHolder.getViewHolder(parent, R.layout.item_re_yc_small_pic);
                return smallVH;
            default:
                Log.d("aaa", "抱歉布局为空");
                CommonViewHolder nullVH = CommonViewHolder.getViewHolder(parent, R.layout.item_null);
                return nullVH;
        }
    }

    @Override
    public void onBindViewHolder(final CommonViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case TYPE_V://带视频大图
                holder.setImg(R.id.fra_re_yc_user_img,datas.getResult().getNewslist().get(position).getUserpic(),2000,2000, ScaleType.FIT_XY, Config.ARGB_8888);
                holder.setText(R.id.fra_re_yc_user_name,datas.getResult().getNewslist().get(position).getUsername());
                holder.setText(R.id.fra_re_yc_user_title,datas.getResult().getNewslist().get(position).getTitle());
                holder.setImg(R.id.fra_re_yc_img_bg,datas.getResult().getNewslist().get(position).getThumbnailpics().get(0),2000,2000,ScaleType.CENTER,Config.ARGB_8888);
                holder.setText(R.id.fra_re_yc_date,datas.getResult().getNewslist().get(position).getPublishtime());
                holder.setText(R.id.fra_re_yc_speak,String.valueOf(datas.getResult().getNewslist().get(position).getReplycount()));
                holder.setText(R.id.fra_re_yc_like,String.valueOf(datas.getResult().getNewslist().get(position).getPraisenum()));
                break;
            case TYPE_SMALL://主编有话要说
                holder.setImg(R.id.fra_re_yc_small_user_img,datas.getResult().getNewslist().get(position).getUserpic(),2000,2000, ScaleType.FIT_XY, Config.ARGB_8888);
                holder.setText(R.id.fra_re_yc_small_user_name,datas.getResult().getNewslist().get(position).getUsername());
                holder.setText(R.id.fra_re_yc_small_title,datas.getResult().getNewslist().get(position).getTitle());
                holder.setImg(R.id.fra_re_yc_small_img,datas.getResult().getNewslist().get(position).getThumbnailpics().get(0),2000,2000,ScaleType.CENTER,Config.ARGB_8888);
                holder.setText(R.id.fra_re_yc_small_date,datas.getResult().getNewslist().get(position).getPublishtime());
                holder.setText(R.id.fra_re_yc_small_speak,String.valueOf(datas.getResult().getNewslist().get(position).getReplycount()));
                holder.setText(R.id.fra_re_yc_small_like,String.valueOf(datas.getResult().getNewslist().get(position).getPraisenum()));
                break;
        }
    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.getResult().getNewslist().size();
    }

}
