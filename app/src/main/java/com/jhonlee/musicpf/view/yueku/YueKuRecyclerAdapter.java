package com.jhonlee.musicpf.view.yueku;

import android.content.Context;
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

public class YueKuRecyclerAdapter extends RecyclerView.Adapter<YueKuRecyclerAdapter.YuekuHolder> {


    private List<PlayList.PlaylistBean> mList;
    private Context mContext;
    private PlayListListener listener;

    public YueKuRecyclerAdapter(List<PlayList.PlaylistBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    public YueKuRecyclerAdapter(List<PlayList.PlaylistBean> mList, Context mContext, PlayListListener listener) {
        this.mList = mList;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public YueKuRecyclerAdapter.YuekuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_yueku_recycler, parent, false);
        return new YuekuHolder(view);

    }

    @Override
    public void onBindViewHolder(YueKuRecyclerAdapter.YuekuHolder holder, int position) {
        final PlayList.PlaylistBean bean = mList.get(position);
        Glide.with(mContext).load(bean.getCoverImgUrl()).into(holder.ivTitle);
        holder.tvCount.setText(bean.getPlayCount() + "");
        holder.tvDesc.setText(bean.getName().length()<=11?bean.getName():bean.getName().substring(0,7)+"...");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.showDetailSong(bean.getCoverImgUrl(),bean.getId(),bean.getName());
            }
        });
    }

    //变换底部占满 footview
 /*    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
       RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager g = (GridLayoutManager) manager;
            g.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return TYPE_FOOTER == getItemViewType(position) ? g.getSpanCount() : 1;
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == mList.size()) {
            return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }
    */
    //有footview 就是mList.size()+1
    @Override
    public int getItemCount() {
        return mList.size();
    }

    class YuekuHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_title)
        ImageView ivTitle;
        @BindView(R.id.tv_count)
        TextView tvCount;
        @BindView(R.id.tv_desc)
        TextView tvDesc;

        public YuekuHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
