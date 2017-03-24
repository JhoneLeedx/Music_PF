package com.jhonlee.musicpf.view.detail;

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
import com.jhonlee.musicpf.pojo.Song;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/23.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {


    private Context mContext;
    private List<Song.TracksBean> mList;
    private MusicListener listener;

    public DetailAdapter(Context mContext, List<Song.TracksBean> mList, MusicListener listener) {
        this.mContext = mContext;
        this.mList = mList;
        this.listener = listener;
    }

    public DetailAdapter(Context mContext, List<Song.TracksBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_playlist_detail, parent, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, int position) {
        final Song.TracksBean track = mList.get(position);
        Glide.with(mContext).load(track.getAlbum().getPicUrl()).into(holder.imgZj);
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
