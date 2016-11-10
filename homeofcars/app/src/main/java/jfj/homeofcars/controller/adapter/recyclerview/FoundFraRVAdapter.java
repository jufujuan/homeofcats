package jfj.homeofcars.controller.adapter.recyclerview;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;

import com.youth.banner.BannerConfig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.CommonViewHolder;
import jfj.homeofcars.model.bean.FoundBean;

/**
 * "发现"界面的业务接口的recyclerview的适配器
 */
public class FoundFraRVAdapter extends RecyclerView.Adapter<CommonViewHolder> {

    private FoundBean datas;
    private Context mContext;
    private CommonViewHolder mCommonViewHolder;
    private int width, height;
    private final static int FOCUS_TYPE = 0;//焦点图
    private final static int ENTRANCE_TYPE = 1;//业务接口
    private final static int TIME_TYPE = 2;//图文时限专区
    private final static int SMALL_LINE_TYPE = 3;//单帧小号横栏
    private final static int TIME_GOGO_TYPE = 4;//限时抢购
    private final static int FIELD_TYPE = 5;//田字小号专区
    private final static int ACTIVITY_TYPE = 6;//活动专区
    private final static int MODE_TYPE = 7;//模块列表
    private final static int PRODUCE_TYPE = 8;//商品列表
    private String endDate = "2016-11-20 18:30:28";//限时疯抢的截止日期(网络没有获取到,在这里先用假数据)


    public FoundFraRVAdapter(Context context) {
        mContext = context;
    }

    public void setDatas(FoundBean datas) {
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
        return datas.getResult().getCardlist().get(position).getcType();
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
                switch (getItemViewType(position)) {
                    case FOCUS_TYPE:
                        return span;
                    case ENTRANCE_TYPE:
                        return span;
                    case TIME_TYPE:
                        return span;
                    case SMALL_LINE_TYPE:
                        return span;
                    case TIME_GOGO_TYPE:
                        return span;
                    case FIELD_TYPE:
                        return span;
                    case ACTIVITY_TYPE:
                        return span;
                    case MODE_TYPE:
                        return span;
                    case PRODUCE_TYPE:
                        return span;
                    default:
                        return span;
                }
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
            case FOCUS_TYPE:
                CommonViewHolder focusVH = CommonViewHolder.getViewHolder(parent, R.layout.item_found_focus);
                Log.d("aaa", "焦点图");
                //entranceVH.setText(R.id.aaa,mFoundBean.getResult().getCardlist().get(i).getDescription().toString());
                return focusVH;
            case ENTRANCE_TYPE:
                CommonViewHolder entranceVH = CommonViewHolder.getViewHolder(parent, R.layout.item_found_entrance);
                Log.d("aaa", "业务入口");
                //entranceVH.setText(R.id.aaa,mFoundBean.getResult().getCardlist().get(i).getDescription().toString());
                return entranceVH;
            case TIME_TYPE:
                CommonViewHolder timeVH = CommonViewHolder.getViewHolder(parent, R.layout.item_found_time);
                // timeVH.setText(R.id.bbb,mFoundBean.getResult().getCardlist().get(i).getDescription().toString());
                Log.d("aaa", "双11");
                return timeVH;
            case SMALL_LINE_TYPE:
                CommonViewHolder smallLineVH = CommonViewHolder.getViewHolder(parent, R.layout.item_found_single);
                Log.d("aaa", "单帧小号横栏");
                return smallLineVH;
            case TIME_GOGO_TYPE:
                CommonViewHolder timeGoGoVH = CommonViewHolder.getViewHolder(parent, R.layout.item_found_time_gogo);
                Log.d("aaa", "限时抢购");
                return timeGoGoVH;
            case FIELD_TYPE:
                CommonViewHolder fieldVH = CommonViewHolder.getViewHolder(parent, R.layout.item_found_field);
                Log.d("aaa", "田字小号专区");
                return fieldVH;
            case ACTIVITY_TYPE:
                CommonViewHolder activityVH = CommonViewHolder.getViewHolder(parent, R.layout.item_found_activity);
                Log.d("aaa", "活动专区");
                return activityVH;
            case MODE_TYPE:
                CommonViewHolder modeVH = CommonViewHolder.getViewHolder(parent, R.layout.item_null);
                return modeVH;
            case PRODUCE_TYPE:
                CommonViewHolder produceVH = CommonViewHolder.getViewHolder(parent, R.layout.item_found_produce);
                Log.d("aaa", "商品列表");
                return produceVH;
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case FOCUS_TYPE://焦点图
                List<String> imgUrls = new ArrayList<>();
                for (int i = 0; i < datas.getResult().getCardlist().get(position).getData().size(); i++) {
                    imgUrls.add(datas.getResult().getCardlist().get(position).getData().get(i).getImageurl());
                }
                holder.setBanner(R.id.item_found_focus_banner, BannerConfig.CENTER, 3000, BannerConfig.CIRCLE_INDICATOR, imgUrls);
                break;
            case ENTRANCE_TYPE://业务接口
                FoundEntranceItemRVAdapter entranceItemRVAdapter = new FoundEntranceItemRVAdapter(mContext);
                entranceItemRVAdapter.setDatas(datas.getResult().getCardlist().get(position).getData());
                holder.setRecyclerView(mContext, 5, R.id.item_found_entrance_rv, entranceItemRVAdapter);
                break;
            case SMALL_LINE_TYPE://单帧小号横栏
                holder.setImg(R.id.item_found_single_img,
                        datas.getResult().getCardlist().get(position).getData().get(0).getImageurl(),
                        3000, 3000,
                        ScaleType.FIT_XY,
                        Config.ARGB_8888);
                break;
            case FIELD_TYPE://田字小号专区
                FoundFieldItemRVAdapter fieldItemRVAdapter = new FoundFieldItemRVAdapter(mContext);
                fieldItemRVAdapter.setDatas(datas.getResult().getCardlist().get(position).getData());
                holder.setRecyclerView(mContext, 2, R.id.item_found_field_recyclerview, fieldItemRVAdapter);
                break;
            case ACTIVITY_TYPE://活动专区
                FoundAcItemRVAdapter acItemRVAdapter = new FoundAcItemRVAdapter(mContext);
                acItemRVAdapter.setDatas(datas.getResult().getCardlist().get(position).getData());
                holder.setRecyclerView(mContext, 3, R.id.item_found_activity_rv, acItemRVAdapter);
                break;
            case PRODUCE_TYPE://商品列表
                FoundProduceItemRVAdapter produceItemRVAdapter = new FoundProduceItemRVAdapter(mContext);
                produceItemRVAdapter.setDatas(datas.getResult().getCardlist().get(position).getData());
                holder.setRecyclerView(mContext, 1, R.id.item_found_produce_rv, produceItemRVAdapter);
                break;
            case TIME_GOGO_TYPE://限时抢购
                FoundTimeGoGoItemRVAdapter timeGoGoItemRVAdapter = new FoundTimeGoGoItemRVAdapter(mContext);
                timeGoGoItemRVAdapter.setDatas(datas.getResult().getCardlist().get(position).getData());
                holder.setRecyclerViewH(mContext, 1, R.id.item_found_time_gogo_rv, timeGoGoItemRVAdapter);
               // List<String> dataaaaa = getLeastTime(endDate);
//                    holder.setText(R.id.item_found_time_gogo_day_tv,);
//                    holder.setText(R.id.item_found_time_gogo_hour_tv,);
//                    holder.setText(R.id.item_found_time_gogo_minute_tv,);
//                    holder.setText(R.id.item_found_time_gogo_second_tv,);
                break;
            case TIME_TYPE://图文限时专区
                FoundTimeItemRVAdapter timeItemRVAdapter = new FoundTimeItemRVAdapter(mContext);
                timeItemRVAdapter.setDatas(datas.getResult().getCardlist().get(position).getData());
                holder.setRecyclerViewH(mContext, 1, R.id.item_found_time_rv, timeItemRVAdapter);
                break;
        }
    }

    /**
     * 对时间进行处理(限时抢购)
     * 用来获取剩余时间
     */
    public List<Integer> getLeastTime(String endTime) {
        List<Integer> time = new ArrayList<>();//用来存储日,时,分,秒
        List<Integer> end=timeChangeStrToInt(endTime);
        //获得当前的时间
        SimpleDateFormat currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTimeStr = currentTime.format(new Date());
        List<Integer> current=timeChangeStrToInt(currentTimeStr);
        /**
         *这里简化了一些判断(假定为当年当月)
         * 注:懒得写
         */
        int secondEndCount=end.get(2)*24*60*60+end.get(3)*60*60+end.get(4)*60+end.get(5);
        int secondCurrentCount=current.get(2)*24*60*60+current.get(3)*60*60+current.get(4)*60+current.get(5);
        if (secondEndCount-secondCurrentCount<=0){
            time.add(0);
            time.add(0);
            time.add(0);
            time.add(0);
        }else{
            int leastCount=secondEndCount-secondCurrentCount;
            int p=0,m=0;
//            time.add(leastCount/24/60/60);
//            p=leastCount/24/60/60;
//            m=leastCount-p*24*60*60;
//
//            time.add(m/60/60);
//            p=m/60/60;
//            m=leastCount-m;
//            time.add((m-p*60*60)/60);
//            p=(leastCount-p*60*60)/60;
//            time.add();

        }
        return time;
    }

    /**
     * 将yyy-MM-dd HH:mm:ss这种格式的转化成int的数组
     * @param timeStr
     * @return
     */
    public List<Integer> timeChangeStrToInt(String timeStr) {
        StringBuffer buffer = new StringBuffer(timeStr);
        //将字符串进行拆分
        int index = 0;
        int year = Integer.parseInt(buffer.substring(index, buffer.indexOf("-")));
        index = buffer.indexOf("-");
        int month = Integer.parseInt(buffer.substring(index + 1, buffer.indexOf("-", index + 1)));
        index = buffer.indexOf("-", index + 1);
        int day = Integer.parseInt(buffer.substring(index + 1, buffer.indexOf(" ")));
        index = buffer.indexOf(" ");
        int hour = Integer.parseInt(buffer.substring(index + 1, buffer.indexOf(":", index + 1)));
        index = buffer.indexOf(":", index + 1);
        int minute = Integer.parseInt(buffer.substring(index + 1, buffer.indexOf(":", index + 1)));
        index = buffer.indexOf(":", index + 1);
        int second = Integer.parseInt(buffer.substring(index + 1, buffer.length()));
        List<Integer> times = new ArrayList<>();
        times.add(year);
        times.add(month);
        times.add(day);
        times.add(hour);
        times.add(minute);
        times.add(second);
        Log.d("aaa", year + ":" + month + ":" + day + ":" + hour + ":" + minute + ":" + second);
        return times;
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.getResult().getCardlist().size();
    }
}
