package jfj.homeofcars.controller.adapter.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import jfj.homeofcars.R;
import jfj.homeofcars.Utils.CommonViewHolder;
import jfj.homeofcars.model.bean.KeyBean;

/**
 * 搜做列表的适配器
 */
public class SearchAcLVAdapter extends BaseAdapter{
    private KeyBean datas;
    private Context mContext;

    public SearchAcLVAdapter(Context context) {
        mContext = context;
    }

    public void setDatas(KeyBean datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas!=null&&datas.getResult().getWordlist().size()!=0?datas.getResult().getWordlist().size():0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CommonViewHolder commonViewHolder=CommonViewHolder.getViewHolder(view,viewGroup, R.layout.item_search);
        commonViewHolder.setText(R.id.item_search,datas.getResult().getWordlist().get(i).getName());
        return commonViewHolder.getItemView();
    }
}
