package com.jhonlee.musicpf.view.rank;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jhonlee.musicpf.R;
import com.jhonlee.musicpf.listener.MusicListener;
import com.jhonlee.musicpf.pojo.Rank;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/22.
 */

public class RankRecyclerAdapter extends RecyclerView.Adapter<RankRecyclerAdapter.DetailViewHolder> {


    private Context mContext;
    private List<Rank.SongsBean> mList;
    private MusicListener listener;

    public RankRecyclerAdapter(Context mContext, List<Rank.SongsBean> mList, MusicListener listener) {
        this.mContext = mContext;
        this.mList = mList;
        this.listener = listener;
    }

    public RankRecyclerAdapter(Context mContext, List<Rank.SongsBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public RankRecyclerAdapter.DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_playlist_detail, parent, false);
        return new RankRecyclerAdapter.DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RankRecyclerAdapter.DetailViewHolder holder, int position) {
        final Rank.SongsBean track = mList.get(position);
        Glide.with(mContext).load(track.getArtists().get(0).getPicUrl()).into(holder.imgZj);
        holder.tvName.setText(track.getName());
        holder.tvAuthor.setText(track.getArtists().get(0).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.showSong(track.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class DetailViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_zj)
        ImageView imgZj;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        public DetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
