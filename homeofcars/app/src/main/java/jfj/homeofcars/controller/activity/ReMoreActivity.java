package jfj.homeofcars.controller.activity;

import android.content.Intent;
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
import jfj.homeofcars.Utils.MyStaticValues;
import jfj.homeofcars.Utils.SharedPreferencesUtil;
import jfj.homeofcars.controller.adapter.recyclerview.recommend.ReRecommendMoreRVApter;
import jfj.homeofcars.controller.base.AbsBaseActivity;
import jfj.homeofcars.model.myinterface.OnRecyclerViewItemClickListener;

/**
 * 推荐界面的的更多
 */
public class ReMoreActivity extends AbsBaseActivity implements OnClickListener {
    private RecyclerView mRecyclerView;
    private List<String> mTitles;
    private ReRecommendMoreRVApter mApter;
    private final static String SP_RECOMMEND_LIST = "recommend";
    private ImageView backImg;
    private List<Integer> types;
    private final static int TYPE_RECOMMEND = 1;
    private final static int TYPE_YC = 2;
    private final static int TYPE_SPEAK = 3;
    private final static int TYPE_VIEDIO = 4;
    private final static int TYPE_FAST = 5;
    private final static int TYPE_MARKET = 6;
    private final static int TYPE_NEWS = 7;
    private final static int TYPE_TESTCAR = 8;
    private final static int TYPE_SHOP = 9;
    private final static int TYPE_USECAR = 10;
    private final static int TYPE_Tel = 11;
    private final static int TYPE_CULTURE = 12;
    private final static int TYPE_CHANGE = 13;

    @Override
    protected int getLayout() {
        return R.layout.ac_recommend_more;
    }

    @Override
    protected void initView() {
        mRecyclerView = bindView(R.id.ac_re_recommend_more_tab_recyclerview);
        mApter = new ReRecommendMoreRVApter(ReMoreActivity.this);
        mTitles = new ArrayList<>();
        backImg = bindView(R.id.ac_recommend_more_back_img);
    }

    @Override
    protected void initDatas() {
        backImg.setOnClickListener(this);

        //查询Sp数据库
        if (SharedPreferencesUtil.getInListSize(ReMoreActivity.this, SP_RECOMMEND_LIST) > 0) {
            types = SharedPreferencesUtil.getIntListValue(ReMoreActivity.this, SP_RECOMMEND_LIST);
        } else {
            SharedPreferencesUtil.putIntListValue(ReMoreActivity.this, SP_RECOMMEND_LIST, types);
        }
        chageTab();
        mApter.setDatas(mTitles);
        mApter.setOnRecyclerViewItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View v,int position) {
                Intent intent=getIntent();
                intent.putExtra("position",position);
                setResult(MyStaticValues.CODE_MORE_TO_RECOMMEND,intent);
                finish();
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ReMoreActivity.this, 4);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mApter);
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            /**
             * 用于设置是否拖拽事件和滑动事件,以及拖拽和滑动操作的方向
             * 1.如果是列表类型的recyclerview,拖动的只有up,down方向
             * 2.如果是网络类型的则有UP,DOWN,LEFT,RIGHT四个方向
             */
            @Override
            public int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
                int dragFlags;//dragFlags 是拖拽标志
                int swipeFlags;//swipeFlags是滑动标志,我们把swipeFlags 都设置为0，暂时不考虑滑动相关操作。
                dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                swipeFlags = 0;
                return makeMovementFlags(dragFlags, swipeFlags);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder target) {
                //得到拖动ViewHolder的position
                int formPosition = viewHolder.getAdapterPosition();
                //得到目标ViewHolder的position
                int toposition = target.getAdapterPosition();
                Collections.swap(types, formPosition, toposition);
                mApter.notifyItemMoved(formPosition, toposition);
                //将数据库进行更新
                SharedPreferencesUtil.clear(ReMoreActivity.this);
                SharedPreferencesUtil.putIntListValue(ReMoreActivity.this, SP_RECOMMEND_LIST, types);


                return true;
            }

            @Override
            public void onSwiped(ViewHolder viewHolder, int direction) {

            }

            //当长按选中item的时候(拖拽开始的时候)调用
            @Override
            public void onSelectedChanged(ViewHolder viewHolder, int actionState) {
                if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
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
        switch (view.getId()) {
            case R.id.ac_recommend_more_back_img:
                finish();
                break;
        }
    }

    private void chageTab() {
        //这里是更换type的重要逻辑
        for (int i = 0; i < 13; i++) {
            switch (types.get(i)) {
                case TYPE_RECOMMEND:
                    mTitles.add("推荐");
                    break;
                case TYPE_YC:
                    mTitles.add("优创+");
                    break;
                case TYPE_SPEAK:
                    mTitles.add("说客");

                    break;
                case TYPE_VIEDIO:
                    mTitles.add("视频");

                    break;
                case TYPE_FAST:
                    mTitles.add("快报");

                    break;
                case TYPE_MARKET:
                    mTitles.add("行情");

                    break;
                case TYPE_NEWS:
                    mTitles.add("新闻");

                    break;
                case TYPE_TESTCAR:
                    mTitles.add("评测");

                    break;
                case TYPE_SHOP:
                    mTitles.add("导购");

                    break;
                case TYPE_USECAR:
                    mTitles.add("用车");

                    break;
                case TYPE_Tel:
                    mTitles.add("技术");

                    break;
                case TYPE_CULTURE:
                    mTitles.add("文化");

                    break;
                case TYPE_CHANGE:
                    mTitles.add("改装");
                    break;
            }
        }
    }
}
