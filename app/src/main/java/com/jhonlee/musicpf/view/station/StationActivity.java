package com.jhonlee.musicpf.view.station;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jhonlee.musicpf.R;
import com.jhonlee.musicpf.view.rank.RankPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JhoneLee on 2017/4/7.
 */

public class StationActivity extends AppCompatActivity{


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private String[] titles = new String[]{"主题", "情感", "热门", "场景", "曲风"};
    private RankPageAdapter pageAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);
        ButterKnife.bind(this);
        tvTitle.setText("电台");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    @OnClick(R.id.iv_search)
    public void search(View view){

    }

    private void init(){
        pageAdapter = new RankPageAdapter(getSupportFragmentManager(),titles,getFragments());
        viewpager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewpager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private List<Fragment> getFragments(){
        List<Fragment> list = new ArrayList<>();
        list.add(StationFragment.newInstance("主题电台"));
        list.add(StationFragment.newInstance("情感电台"));
        list.add(StationFragment.newInstance("热门电台"));
        list.add(StationFragment.newInstance("场景电台"));
        list.add(StationFragment.newInstance("曲风电台"));
        return list;
    }
}
