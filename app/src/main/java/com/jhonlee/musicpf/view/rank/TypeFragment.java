package com.jhonlee.musicpf.view.rank;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jhonlee.musicpf.R;
import com.jhonlee.musicpf.listener.MusicListener;
import com.jhonlee.musicpf.mvp.contract.RankContract;
import com.jhonlee.musicpf.mvp.presenter.RankPresenter;
import com.jhonlee.musicpf.pojo.Rank;
import com.jhonlee.musicpf.pojo.Song;
import com.jhonlee.musicpf.pojo.SongDetail;
import com.jhonlee.musicpf.view.detail.MusicActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/23.
 */

public class TypeFragment extends Fragment implements RankContract.View,MusicListener{

    @BindView(R.id.recycler_rank)
    RecyclerView recyclerRank;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.progress)
    ProgressBar progress;


    private String mType;
    private RankContract.Presenter presenter;
    private RankRecyclerAdapter adapter;
    private List<Rank.SongsBean> mList;

    private ArrayList<SongDetail> songDetails = new ArrayList<>();
    private ArrayList<Integer> integerList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rank_type, container, false);
        ButterKnife.bind(this, view);
        initDataAndView();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void initDataAndView(){
        mType = getArguments().getString("type");
        presenter = new RankPresenter();
        presenter.attachView(this);
        presenter.loadRanks(mType,1,20);
        mList = new ArrayList<>();
        adapter = new RankRecyclerAdapter(getContext(),mList,this);
        recyclerRank.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerRank.setLayoutManager(manager);
        recyclerRank.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        refresh.setColorSchemeResources(R.color.colorStart,R.color.colorCenter,R.color.colorEnd);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadRanks(mType,1,20);
                refresh.setRefreshing(false);
            }
        });
    }

    public static TypeFragment newInstance(String type) {
        TypeFragment frag = new TypeFragment();
        Bundle args = new Bundle();
        args.putString("type", type);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void loadSongs(List<Rank.SongsBean> list) {
        mList.clear();
        mList.addAll(list);
        adapter.notifyDataSetChanged();

        integerList.clear();
        for (Rank.SongsBean bean : list){
            integerList.add(bean.getId());

            SongDetail songDetail = new SongDetail(Parcel.obtain());
            songDetail.setAuthor(bean.getArtists().get(0).getName());
            songDetail.setmId(bean.getId());
            songDetail.setmName(bean.getName());
            songDetail.setTime(bean.getDuration());
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
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSong(int id) {
        Intent intent = new Intent(getContext(),MusicActivity.class);
        intent.putExtra("id",id);
        if (integerList.size()>0){
            intent.putIntegerArrayListExtra("integerList",integerList);
        }
        if (songDetails.size()>0){
            intent.putParcelableArrayListExtra("songList", songDetails);
        }
        startActivity(intent);
    }

}
