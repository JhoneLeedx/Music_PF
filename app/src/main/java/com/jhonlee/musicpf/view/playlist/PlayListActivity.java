package com.jhonlee.musicpf.view.playlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.jhonlee.musicpf.R;
import com.jhonlee.musicpf.listener.PlayListListener;
import com.jhonlee.musicpf.mvp.contract.PlayListContract;
import com.jhonlee.musicpf.mvp.presenter.PlayListPrestenter;
import com.jhonlee.musicpf.pojo.PlayList;
import com.jhonlee.musicpf.view.detail.PlayListDetailActivity;
import com.jhonlee.musicpf.view.station.StationAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JhoneLee on 2017/4/7.
 */

public class PlayListActivity extends AppCompatActivity implements PlayListContract.View,PlayListListener{


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rb_tj)
    RadioButton rbTj;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private PlayListContract.Presenter presenter;
    private StationAdapter adapter;
    private List<PlayList.PlaylistBean> mList;
    private String type = "推荐";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);
        ButterKnife.bind(this);
        tvTitle.setText("歌单");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initData();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    private void initData(){
        rbTj.setChecked(true);
        mList = new ArrayList<>();
        adapter = new StationAdapter(mList,this,this);
        presenter = new PlayListPrestenter();
        presenter.attachView(this);
        presenter.loadPlayLists(type,1000,20);
        GridLayoutManager manager = new GridLayoutManager(this,2);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        refresh.setColorSchemeResources(R.color.refreshStart,R.color.refreshCenter,R.color.refreshEnd);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadPlayLists(type,1000,20);
                refresh.setRefreshing(false);
            }
        });
    }

    @OnClick({R.id.rb_zx,R.id.rb_tj})
    public void Click(View view){
        switch (view.getId()){
            case R.id.rb_tj:
                type = "推荐";
                presenter.loadPlayLists(type,1000,20);
                break;
            case R.id.rb_zx:
                type = "最新";
                presenter.loadPlayLists(type,1000,20);
                break;
        }
    }

    @Override
    public void loadPlayLists(List<PlayList.PlaylistBean> list) {
        mList.clear();
        mList.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDetailSong(String url, int id, String name) {
        Intent intent = new Intent(this, PlayListDetailActivity.class);
        intent.putExtra("imgUrl", url);
        intent.putExtra("name", name);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
