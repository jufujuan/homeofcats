package jfj.homeofcars.controller.adapter.recyclerview.recommend;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;

import java.util.ArrayList;
import java.util.List;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.CommonViewHolder;
import jfj.homeofcars.model.bean.RecommendBean;

/**
 * "发现"界面的业务接口的recyclerview的适配器
 */
public class ReRecommendFraRVAdapter extends RecyclerView.Adapter<CommonViewHolder> {

    private RecommendBean datas;
    private Context mContext;
    private final static int TYPE_FLOVAR=3;//花边
    private final static int TYPE_COMMON=2;//一般
    private final static int TYPE_NEWS_CENTER=1;//新闻中心
    private final static int TYPE_THREE_PICTURE=6;//三个图
    private final static int TYPE_FORUM=5;//论坛


    public ReRecommendFraRVAdapter(Context context) {
        mContext = context;
    }


    public void setDatas(RecommendBean datas) {
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
            case TYPE_FLOVAR://花边
                CommonViewHolder flovarVH = CommonViewHolder.getViewHolder(parent, R.layout.item_re_flovar);
                return flovarVH;
            case TYPE_COMMON://一般
                CommonViewHolder commonVH=CommonViewHolder.getViewHolder(parent,R.layout.item_re_common);
                return commonVH;
            case TYPE_NEWS_CENTER://新闻中心
                CommonViewHolder newsCenterVH = CommonViewHolder.getViewHolder(parent, R.layout.item_re_news_center);
                return newsCenterVH;
            case TYPE_THREE_PICTURE://三个图片
                CommonViewHolder threePctureVH = CommonViewHolder.getViewHolder(parent, R.layout.item_re_three_picture);
                return threePctureVH;
            case TYPE_FORUM://论坛(和新闻中心一个布局)
                CommonViewHolder forumVH=CommonViewHolder.getViewHolder(parent,R.layout.item_re_news_center);
                return forumVH;
            default:
                Log.d("aaa", "抱歉布局为空");
                CommonViewHolder nullVH = CommonViewHolder.getViewHolder(parent, R.layout.item_null);
                return nullVH;
        }
    }

    @Override
    public void onBindViewHolder(final CommonViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case TYPE_FLOVAR://花边
                holder.setText(R.id.item_re_flovar_title,datas.getResult().getNewslist().get(position).getTitle());
                holder.setText(R.id.item_re_flovar_play_count,datas.getResult().getNewslist().get(position).getReplycount()+"播放");
                holder.setText(R.id.item_re_flovar_date,datas.getResult().getNewslist().get(position).getTime());
                holder.setImg(R.id.item_re_flovar_logo,datas.getResult().getNewslist().get(position).getSmallpic(),2000,2000, ScaleType.CENTER, Config.ARGB_8888);
               break;
            case TYPE_COMMON://一般
                holder.setText(R.id.item_re_common_title,datas.getResult().getNewslist().get(position).getTitle());
                holder.setText(R.id.item_re_common_play_count,datas.getResult().getNewslist().get(position).getReplycount()+"评论");
                holder.setText(R.id.item_re_common_date,datas.getResult().getNewslist().get(position).getTime());
                holder.setImg(R.id.item_re_common_logo,datas.getResult().getNewslist().get(position).getSmallpic(),2000,2000, ScaleType.CENTER, Config.ARGB_8888);
                break;
            case TYPE_NEWS_CENTER://新闻中心
                holder.setText(R.id.item_re_news_center_title,datas.getResult().getNewslist().get(position).getTitle());
                holder.setText(R.id.item_re_news_center_play_count,datas.getResult().getNewslist().get(position).getReplycount()+"评论");
                holder.setText(R.id.item_re_news_center_date,datas.getResult().getNewslist().get(position).getTime());
                holder.setImg(R.id.item_re_news_center_logo,datas.getResult().getNewslist().get(position).getSmallpic(),2000,2000, ScaleType.CENTER, Config.ARGB_8888);
                break;
            case TYPE_THREE_PICTURE://三个图
                holder.setText(R.id.item_re_three_pic_title,datas.getResult().getNewslist().get(position).getTitle());
                holder.setText(R.id.item_re_three_pic_count,datas.getResult().getNewslist().get(position).getReplycount()+"图片");
                holder.setText(R.id.item_re_three_pic_date,datas.getResult().getNewslist().get(position).getTime());
                /**
                 * 对三张图片的图片网址进行字符串拆分
                 */
                String threePicUrls=datas.getResult().getNewslist().get(position).getIndexdetail();
                List<String> imgList=getThreeUrls(threePicUrls);
                holder.setImg(R.id.item_re_three_pic_left,imgList.get(0),2000,2000, ScaleType.CENTER, Config.ARGB_8888);
                holder.setImg(R.id.item_re_three_pic_center,imgList.get(1),2000,2000, ScaleType.CENTER, Config.ARGB_8888);
                holder.setImg(R.id.item_re_three_pic_right,imgList.get(2),2000,2000, ScaleType.CENTER, Config.ARGB_8888);
                break;
            case TYPE_FORUM://论坛(和新闻中心一个布局)
                holder.setText(R.id.item_re_news_center_title,datas.getResult().getNewslist().get(position).getTitle());
                holder.setText(R.id.item_re_news_center_play_count,datas.getResult().getNewslist().get(position).getReplycount()+"回帖");
                holder.setText(R.id.item_re_news_center_date,datas.getResult().getNewslist().get(position).getTime());
                holder.setImg(R.id.item_re_news_center_logo,datas.getResult().getNewslist().get(position).getSmallpic(),2000,2000, ScaleType.CENTER, Config.ARGB_8888);
                break;

        }
    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.getResult().getNewslist().size();
    }

    /**
     *  用来拆分三个图片的网址
     */
     private List<String> getThreeUrls(String threeImgUrl){
         List<String> imgUrls=new ArrayList<>();
         String imgurl;
         StringBuffer buffer=new StringBuffer(threeImgUrl);
         imgurl=buffer.substring(buffer.indexOf("http"),buffer.indexOf(","));
         int position=buffer.indexOf(",");
         imgUrls.add(imgurl);

         imgurl=buffer.substring(position+1,buffer.indexOf(",",position+1));
         imgUrls.add(imgurl);

         position=buffer.indexOf(",",position+1);
         imgurl=buffer.substring(position+1,buffer.length());
         imgUrls.add(imgurl);
         return imgUrls;
     }


}
