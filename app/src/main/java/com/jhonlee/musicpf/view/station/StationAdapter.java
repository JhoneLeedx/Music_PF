package com.jhonlee.musicpf.view.station;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jhonlee.musicpf.R;
import com.jhonlee.musicpf.listener.PlayListListener;
import com.jhonlee.musicpf.pojo.PlayList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/22.
 */

public class StationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<PlayList.PlaylistBean> mList;
    private Context mContext;
    private PlayListListener listener;
    private int TYPE_NORMAL = 0x110 ;
    private int TYPE_HEADER = 0x112 ;
    private int TYPE_FOOT = 0x114;
    public StationAdapter(List<PlayList.PlaylistBean> mList, Context mContext, PlayListListener listener) {

        this.mList = mList;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder = null;
        if (viewType == TYPE_HEADER){
            view = LayoutInflater.from(mContext).inflate(R.layout.head_view, parent, false);
            holder =  new HeaderViewHolder(view);
        }else if (viewType == TYPE_NORMAL){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_type, parent, false);
            holder =  new StationHolder(view);
        }else if (viewType == TYPE_FOOT){
            view = LayoutInflater.from(mContext).inflate(R.layout.foot_view, parent, false);
            holder =  new FootViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof StationHolder){
            StationHolder sholder = (StationHolder)holder;
            final PlayList.PlaylistBean bean = mList.get(position);
            Glide.with(mContext).load(bean.getCoverImgUrl()).into(sholder.ivTitle);
            sholder.tvCount.setText(bean.getPlayCount() + "");
            sholder.tvDesc.setText(bean.getName().length()<=11?bean.getName():bean.getName().substring(0,7)+"...");

            sholder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.showDetailSong(bean.getCoverImgUrl(),bean.getId(),bean.getName());
                }
            });
        }
    }

    //变换底部占满 有footview或headerView
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
       RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager g = (GridLayoutManager) manager;
            g.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    if (type==TYPE_HEADER){
                        return g.getSpanCount();
                    }
                    if (type==TYPE_FOOT){
                        return g.getSpanCount();
                    }
                    return 1;
                }
            });
        }

    }
    @Override
    public int getItemViewType(int position) {
            if (position<0){
                return TYPE_HEADER;
            }else if (position==mList.size()){
                return TYPE_FOOT;
            }
            return TYPE_NORMAL;
    }
    //有footview或headerView 就是mList.size()+1
    @Override
    public int getItemCount() {
        return mList.size()+1;
    }

    class StationHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_title)
        ImageView ivTitle;
        @BindView(R.id.tv_count)
        TextView tvCount;
        @BindView(R.id.tv_desc)
        TextView tvDesc;

        public StationHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    class HeaderViewHolder extends RecyclerView.ViewHolder{

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
    class FootViewHolder extends RecyclerView.ViewHolder{

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }

}
