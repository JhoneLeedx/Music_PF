package com.jhonlee.musicpf.view.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jhonlee.musicpf.R;
import com.jhonlee.musicpf.listener.MusicListener;
import com.jhonlee.musicpf.pojo.SongDetail;
import com.jhonlee.musicpf.util.TimeUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/31.
 */

public class AllMenuAdapter extends RecyclerView.Adapter<AllMenuAdapter.MenuHolder> {


    private Context mContext;
    private List<SongDetail> mList;
    private MusicListener listener;
    public AllMenuAdapter(Context mContext, List<SongDetail> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public AllMenuAdapter(Context mContext, List<SongDetail> mList, MusicListener listener) {
        this.mContext = mContext;
        this.mList = mList;
        this.listener = listener;
    }

    @Override
    public MenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_all_music_detial, parent, false);

        return new MenuHolder(view);
    }


    @Override
    public void onBindViewHolder(MenuHolder holder, int position) {
        final SongDetail song = mList.get(position);
        holder.tvAllTime.setText(TimeUtil.formatTime(song.getTime()));
        holder.tvAuthor.setText(song.getAuthor());
        holder.tvName.setText(song.getmName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.showSong(song.getmId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    protected class MenuHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.tv_all_time)
        TextView tvAllTime;

        public MenuHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
