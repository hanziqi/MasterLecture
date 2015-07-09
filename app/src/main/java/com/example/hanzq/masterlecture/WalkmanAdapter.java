package com.example.hanzq.masterlecture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hb.views.PinnedSectionListView;

import java.util.ArrayList;

/**
 * Created by HanZQ on 2015/3/21.
 */
public class WalkmanAdapter extends BaseAdapter implements PinnedSectionListView.PinnedSectionListAdapter {
    private ArrayList<Walkman> list;
    private Context context;
    private ArrayList<Walkman> getList() {
        return list;
    }
    public void setList(ArrayList<Walkman> list) {
        if(list!=null){
            this.list = list;
        }else{
            list=new ArrayList<Walkman>();
        }
    }
    public WalkmanAdapter(Context context, ArrayList<Walkman> list){
        this.setList(list);
        this.context=context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Walkman getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup viewGrop) {
        ViewHolder vh=null;
        if(converView==null){
            vh=new ViewHolder();
            converView=LayoutInflater.from(context).inflate(R.layout.item, null);
            vh.title=(TextView)converView.findViewById(R.id.title);
            vh.content= (TextView) converView.findViewById(R.id.content);
            vh.imageView=(ImageView)converView.findViewById(R.id.imageView1);
            converView.setTag(vh);
        }else{
            vh=(ViewHolder) converView.getTag();
        }
        Walkman bean=getItem(position);
        vh.title.setText(bean.title);
        vh.content.setText(bean.content);
        vh.imageView.setImageResource(bean.imageViewId);
        if (bean.type == Walkman.SECTION) {
            vh.title.setBackgroundResource(R.drawable.section);
            vh.imageView.setVisibility(View.GONE);
            vh.title.setTextSize(14);
            vh.content.setVisibility(View.GONE);
        }else{
            vh.title.setBackgroundResource(R.drawable.details_layout_bg);
            vh.imageView.setVisibility(View.VISIBLE);
        }
        return converView;
    }
    @Override
    public boolean isItemViewTypePinned(int viewType) {
        return viewType == Walkman.SECTION;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
    @Override
    public int getItemViewType(int position) {
        return ((Walkman)getItem(position)).type;
    }

    class ViewHolder {
        public TextView title;
        public TextView content;
        public ImageView imageView;
    }
}
