package jfj.homeofcars.controller.adapter.listview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.CommonViewHolder;
import jfj.homeofcars.model.bean.FoundBean;

/**
 * listview的适配器
 */
public class FoundFraLVAdapter extends BaseAdapter{
    private FoundBean mFoundBean;
    private Context mContext;
    private final static int FOCUS_TYPE=0;//焦点图
    private final static int ENTRANCE_TYPE=1;//业务接口
    private final static int TIME_TYPE=2;//图文时限专区
    private final static int SMALL_LINE_TYPE=3;//单帧小号横栏
    private final static int TIME_GOGO_TYPE=4;//限时抢购
    private final static int FIELD_TYPE=5;//田字小号专区
    private final static int ACTIVITY_TYPE=6;//活动专区
    private final static int MODE_TYPE=7;//模块列表
    private final static int PRODUCE_TYPE=8;//商品列表

    public FoundFraLVAdapter(Context context) {
        mContext = context;
    }

    public void setFoundBean(FoundBean foundBean) {
        mFoundBean = foundBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mFoundBean!=null&&mFoundBean.getResult().getCardlist().size()!=0?mFoundBean.getResult().getCardlist().size():0;
    }

    @Override
    public Object getItem(int i) {
        return mFoundBean!=null&&mFoundBean.getResult().getCardlist().size()!=0?mFoundBean.getResult().getCardlist().get(i):null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        int returnType=0;//当没找到该类型的时候

        if (mFoundBean.getResult().getCardlist().get(position).getDescription().equals("业务入口")){
            returnType=ENTRANCE_TYPE;
        }else if(mFoundBean.getResult().getCardlist().get(position).getDescription().equals("图文限时专区")){
            returnType=TIME_TYPE;
        }
        else if(mFoundBean.getResult().getCardlist().get(position).getDescription().equals("单帧小号横栏")){
            returnType=SMALL_LINE_TYPE;
        }
        else if(mFoundBean.getResult().getCardlist().get(position).getDescription().equals("限时抢购")){
            returnType=TIME_GOGO_TYPE;
        }
        else if(mFoundBean.getResult().getCardlist().get(position).getDescription().equals("田字小号专区")){
            returnType=FIELD_TYPE;
        }
        else if(mFoundBean.getResult().getCardlist().get(position).getDescription().equals("活动专区")){
            returnType=ACTIVITY_TYPE;
        }
        else if(mFoundBean.getResult().getCardlist().get(position).getDescription().equals("模块列表")){
            returnType=MODE_TYPE;
        }
        else if(mFoundBean.getResult().getCardlist().get(position).getDescription().equals("商品列表")){
            returnType=PRODUCE_TYPE;
        }else if (mFoundBean.getResult().getCardlist().get(position).getDescription().equals("焦点图")){
            returnType=FOCUS_TYPE;
        }
        Log.d("aaa", "returnType"+returnType);
        return returnType;
    }

    @Override
    public int getViewTypeCount() {
        return 9;
    }

    /**
     * 对行布局的各种数据进行初始化
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        CommonViewHolder viewHolder=CommonViewHolder.getViewHolder(view,viewGroup,i);
//        return viewHolder.getItemView();
        View currentItemView = null;
        switch (getItemViewType(i)){
            case FOCUS_TYPE:
                CommonViewHolder focusVH=CommonViewHolder.getViewHolder(view,viewGroup, R.layout.item_found_entrance);
                Log.d("aaa", "第零种type");
                //entranceVH.setText(R.id.aaa,mFoundBean.getResult().getCardlist().get(i).getDescription().toString());
                currentItemView=focusVH.getItemView();
                break;
            case ENTRANCE_TYPE:
                CommonViewHolder entranceVH=CommonViewHolder.getViewHolder(view,viewGroup, R.layout.item_found_entrance);
                Log.d("aaa", "第一种type");
                //entranceVH.setText(R.id.aaa,mFoundBean.getResult().getCardlist().get(i).getDescription().toString());
                currentItemView=entranceVH.getItemView();
                break;
            case TIME_TYPE:
                CommonViewHolder timeVH=CommonViewHolder.getViewHolder(view,viewGroup, R.layout.item_found_limit);
               // timeVH.setText(R.id.bbb,mFoundBean.getResult().getCardlist().get(i).getDescription().toString());
                Log.d("aaa", "第二种type");
                currentItemView=timeVH.getItemView();
                break;
            case SMALL_LINE_TYPE:
                CommonViewHolder smallLineVH=CommonViewHolder.getViewHolder(view,viewGroup, R.layout.item_found_entrance);
                Log.d("aaa", "第三种type");
                currentItemView=smallLineVH.getItemView();
                break;
            case TIME_GOGO_TYPE:
                CommonViewHolder timeGoGoVH=CommonViewHolder.getViewHolder(view,viewGroup, R.layout.item_found_entrance);
                currentItemView=timeGoGoVH.getItemView();
                break;
            case FIELD_TYPE:
                CommonViewHolder fieldVH=CommonViewHolder.getViewHolder(view,viewGroup, R.layout.item_found_entrance);
                currentItemView=fieldVH.getItemView();
                break;
            case ACTIVITY_TYPE:
                CommonViewHolder activityVH=CommonViewHolder.getViewHolder(view,viewGroup, R.layout.item_found_entrance);
                currentItemView=activityVH.getItemView();
                break;
            case MODE_TYPE:
                CommonViewHolder modeVH=CommonViewHolder.getViewHolder(view,viewGroup, R.layout.item_found_entrance);
                currentItemView=modeVH.getItemView();
                break;
            case PRODUCE_TYPE:
                CommonViewHolder produceVH=CommonViewHolder.getViewHolder(view,viewGroup, R.layout.item_found_entrance);
                currentItemView=produceVH.getItemView();
                break;
        }
        return currentItemView;
    }
}
