package jfj.homeofcars.controller.activity;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.SharedPreferencesUtil;
import jfj.homeofcars.controller.adapter.recyclerview.recommend.ReRecommendMoreRVApter;
import jfj.homeofcars.controller.base.AbsBaseActivity;

/**
 * 推荐界面的的更多
 */
public class ReMoreActivity extends AbsBaseActivity implements OnClickListener {
    private RecyclerView mRecyclerView;
    private List<String> mTitles;
    private ReRecommendMoreRVApter mApter;
    private final static String SP_RECOMMEND_LIST = "recommend";
    private ImageView backImg;

    @Override
    protected int getLayout() {
        return R.layout.ac_recommend_more;
    }

    @Override
    protected void initView() {
        mRecyclerView = bindView(R.id.ac_re_recommend_more_tab_recyclerview);
        mApter = new ReRecommendMoreRVApter(ReMoreActivity.this);
        mTitles = new ArrayList<>();
        backImg=bindView(R.id.ac_recommend_more_back_img);
    }

    @Override
    protected void initDatas() {
        backImg.setOnClickListener(this);
        mTitles.add("推荐");
        mTitles.add("优创+");
        mTitles.add("说客");
        mTitles.add("视频");
        mTitles.add("快报");
        mTitles.add("行情");
        mTitles.add("新闻");
        mTitles.add("评测");
        mTitles.add("导购");
        mTitles.add("用车");
        mTitles.add("技术");
        mTitles.add("文化");
        mTitles.add("改装");

        //查询Sp数据库
        if (SharedPreferencesUtil.getStrListSize(ReMoreActivity.this, SP_RECOMMEND_LIST) > 0) {
            mTitles.clear();
            mTitles = SharedPreferencesUtil.getStrListValue(ReMoreActivity.this, SP_RECOMMEND_LIST);

        } else {
            SharedPreferencesUtil.putStrListValue(ReMoreActivity.this, SP_RECOMMEND_LIST, mTitles);
        }
        mApter.setDatas(mTitles);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ReMoreActivity.this, 4);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mApter);
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            /**
             * 用于设置是否拖拽事件和滑动事件,以及拖拽和滑动操作的方向
             * 1.如果是列表类型的recyclerview,拖动的只有up,down方向
             * 2.如果是网络类型的则有UP,DOWN,LEFT,RIGHT四个方向
             * @param recyclerView
             * @param viewHolder
             * @return
             */
            @Override
            public int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
                int dragFlags;//dragFlags 是拖拽标志
                int swipeFlags;//swipeFlags是滑动标志,我们把swipeFlags 都设置为0，暂时不考虑滑动相关操作。
               // if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                    dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                    swipeFlags = 0;
              //  } else {
                  //  dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                  //  swipeFlags = 0;
             //   }
                return makeMovementFlags(dragFlags, swipeFlags);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder target) {
                //得到拖动ViewHolder的position
                int formPosition=viewHolder.getAdapterPosition();
                //得到目标ViewHolder的position
                int toposition=target.getAdapterPosition();
                Collections.swap(mTitles,formPosition,toposition);
                mApter.notifyItemMoved(formPosition,toposition);
                //将数据库进行更新
                SharedPreferencesUtil.clear(ReMoreActivity.this);
                SharedPreferencesUtil.putStrListValue(ReMoreActivity.this,SP_RECOMMEND_LIST,mTitles);
                return true;
            }

            @Override
            public void onSwiped(ViewHolder viewHolder, int direction) {

            }
            //当长按选中item的时候(拖拽开始的时候)调用
            @Override
            public void onSelectedChanged(ViewHolder viewHolder, int actionState) {
                if(actionState!=ItemTouchHelper.ACTION_STATE_IDLE){
                    viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
                }
                super.onSelectedChanged(viewHolder, actionState);
            }
            //当手指松开的时候(拖拽完成的时候)调用
            @Override
            public void clearView(RecyclerView recyclerView, ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                viewHolder.itemView.setBackgroundColor(0);
            }

        });

        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ac_recommend_more_back_img:
                finish();
                break;
        }
    }
}
