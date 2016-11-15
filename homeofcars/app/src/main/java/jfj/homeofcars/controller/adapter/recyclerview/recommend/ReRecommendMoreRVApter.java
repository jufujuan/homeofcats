package jfj.homeofcars.controller.adapter.recyclerview.recommend;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import java.util.List;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.CommonViewHolder;
import jfj.homeofcars.model.myinterface.OnRecyclerViewItemClickListener;

/**
 * 推荐更多的适配器
 */
public class ReRecommendMoreRVApter extends RecyclerView.Adapter<CommonViewHolder>{
    private List<String> datas;
    private Context mContext;
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener=null;


    public ReRecommendMoreRVApter(Context context) {
        mContext = context;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonViewHolder commonViewHolder=CommonViewHolder.getViewHolder(parent, R.layout.item_re_recommend);

        return commonViewHolder;
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        holder.setText(R.id.item_re_recommend_tv,datas.get(position));
        holder.getItemView().setOnClickListener(new MyOnClickListener(holder));
//        holder.getItemView().setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    /**
     * 论写这个方法的必要性:
     * 1.如果不用这个方法上面就要写成:holder.getItemView().setOnClickListener(position);
     *   这时position就要变成final
     *   于是当我们重新排序的时候,position和监听时间就绑定在一起了(也就是position不会变)
     * 2.在这里写一个继承自onclick的监听传入holder(这样position就不会不变了)
     */
    class MyOnClickListener implements OnClickListener{
        CommonViewHolder mCommonViewHolder;

        public MyOnClickListener(CommonViewHolder commonViewHolder) {
            mCommonViewHolder = commonViewHolder;
        }

        @Override
        public void onClick(View view) {
            int layoutPosition = mCommonViewHolder.getLayoutPosition();
            mOnRecyclerViewItemClickListener.onItemClick(view,layoutPosition);
        }
    }

    @Override
    public int getItemCount() {
        return datas!=null&&datas.size()!=0?datas.size():0;
    }
}
