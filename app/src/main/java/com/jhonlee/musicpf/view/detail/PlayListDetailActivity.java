package com.jhonlee.musicpf.view.detail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jhonlee.musicpf.R;
import com.jhonlee.musicpf.listener.MusicListener;
import com.jhonlee.musicpf.mvp.contract.SongContract;
import com.jhonlee.musicpf.mvp.presenter.SongPrestenter;
import com.jhonlee.musicpf.pojo.Song;
import com.jhonlee.musicpf.pojo.SongDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/23.
 */

public class PlayListDetailActivity extends AppCompatActivity implements SongContract.View,MusicListener{

    @BindView(R.id.iv_music_detail)
    ImageView ivMusicDetail;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.progress)
    ProgressBar progress;

    private SongContract.Presenter presenter;
    private List<Song.TracksBean> lists;
    private DetailAdapter adapter;

    private int mId;
    private String mImgUrl;
    private String mName;

    private ArrayList<Integer> integerList = new ArrayList<>();
    private ArrayList<SongDetail> songDetails = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_detail);
        ButterKnife.bind(this);
        mName = getIntent().getStringExtra("name");
        toolbar.setTitle(mName);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initData();
    }

    private void initData(){
        mId = getIntent().getIntExtra("id",0);
        mImgUrl = getIntent().getStringExtra("imgUrl");

        Glide.with(this).load(mImgUrl).into(ivMusicDetail);
        presenter = new SongPrestenter();
        presenter.attachView(this);
        presenter.loadSongs(mId);

        lists = new ArrayList<>();
        adapter = new DetailAdapter(this,lists,this);
        recycler.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        DividerItemDecoration d = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recycler.addItemDecoration(d);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loadSongs(List<Song.TracksBean> list) {
        lists.clear();
        lists.addAll(list);
        adapter.notifyDataSetChanged();
        integerList.clear();
        for (Song.TracksBean bean : list){
            SongDetail songDetail = new SongDetail(Parcel.obtain());
            songDetail.setAuthor(bean.getArtists().get(0).getName());
            songDetail.setmId(bean.getId());
            songDetail.setmName(bean.getName());
            songDetail.setTime(bean.getDuration());

            integerList.add(bean.getId());
            songDetails.add(songDetail);
        }
    }

    @Override
    public void dismisProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSong(int id) {
        Intent intent = new Intent(this,MusicActivity.class);
        intent.putExtra("id",id);
        if (integerList.size()>0){
            intent.putIntegerArrayListExtra("integerList",integerList);
        }
        if (songDetails.size()>0){
            intent.putParcelableArrayListExtra("songList",  songDetails);
        }
        startActivity(intent);
    }
}
