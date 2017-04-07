package com.jhonlee.musicpf.view.station;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jhonlee.musicpf.R;
import com.jhonlee.musicpf.listener.PlayListListener;
import com.jhonlee.musicpf.mvp.contract.PlayListContract;
import com.jhonlee.musicpf.mvp.presenter.PlayListPrestenter;
import com.jhonlee.musicpf.pojo.PlayList;
import com.jhonlee.musicpf.view.detail.PlayListDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by JhoneLee on 2017/3/23.
 */

public class StationFragment extends Fragment implements PlayListContract.View, PlayListListener {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private Unbinder unbind;
    private String mType;
    private PlayListContract.Presenter presenter;
    private StationAdapter adapter;
    private List<PlayList.PlaylistBean> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statin_type, container, false);
        unbind = ButterKnife.bind(this, view);
        initDataAndView();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void initDataAndView() {
        mType = getArguments().getString("type");
        presenter = new PlayListPrestenter();
        presenter.attachView(this);
        presenter.loadPlayLists(mType, 1000, 20);
        mList = new ArrayList<>();
        adapter = new StationAdapter(mList, getContext(), this);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recycler.setLayoutManager(manager);
        recycler.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recycler.setAdapter(adapter);
        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean isSlidingToFirst = false;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                GridLayoutManager manager = (GridLayoutManager) recyclerView.getLayoutManager();
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int end = manager.findLastVisibleItemPosition();
                    if (end == manager.getChildCount()-1 && isSlidingToFirst) {
                        presenter.loadPlayLists(mType, 1000, 21);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                isSlidingToFirst = dy > 0;
            }
        });
        refresh.setColorSchemeResources(R.color.refreshStart,R.color.refreshCenter,R.color.refreshEnd);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadPlayLists(mType, 1000, 21);
            }
        });
    }

    public static StationFragment newInstance(String type) {
        StationFragment frag = new StationFragment();
        Bundle args = new Bundle();
        args.putString("type", type);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public void loadPlayLists(List<PlayList.PlaylistBean> list) {
        refresh.setRefreshing(false);
        if (list.size() > 0) {
            mList.clear();
            mList.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showDetailSong(String url, int id, String name) {
        Intent intent = new Intent(getContext(), PlayListDetailActivity.class);
        intent.putExtra("imgUrl", url);
        intent.putExtra("name", name);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbind.unbind();
    }
}
