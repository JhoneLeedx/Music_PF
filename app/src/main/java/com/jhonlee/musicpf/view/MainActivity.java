package com.jhonlee.musicpf.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jhonlee.musicpf.R;
import com.jhonlee.musicpf.view.mine.MineFragment;
import com.jhonlee.musicpf.view.playlist.PlayListActivity;
import com.jhonlee.musicpf.view.rank.RankActivity;
import com.jhonlee.musicpf.view.station.StationActivity;
import com.jhonlee.musicpf.view.yueku.YueKuFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.content_main)
    RelativeLayout contentMain;
    @BindView(R.id.author)
    TextView author;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    @BindView(R.id.tv_yk)
    TextView tvYk;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.fb_music)
    FloatingActionButton fbMusic;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    private YueKuFragment yueKuFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initView();
    }

    private void initView() {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        author.setText("Jhon Lee");

        yueKuFragment = new YueKuFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, yueKuFragment).commit();
    }

    @OnClick({R.id.rb_home, R.id.rb_tj, R.id.rb_gd,
            R.id.rb_dt, R.id.rb_ph, R.id.rb_msg,
            R.id.rb_setting, R.id.rb_about, R.id.iv_search,
            R.id.tv_mine, R.id.tv_yk})
    public void Click(View view) {

        switch (view.getId()) {

            case R.id.rb_home:
                if (yueKuFragment == null) {
                    yueKuFragment = new YueKuFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, yueKuFragment).commit();
                break;
            case R.id.rb_tj:
                break;
            case R.id.rb_gd:
                startActivity(new Intent(this, PlayListActivity.class));
                break;
            case R.id.rb_dt:
                startActivity(new Intent(this, StationActivity.class));
                break;
            case R.id.rb_ph:
                startActivity(new Intent(this, RankActivity.class));
                break;
            case R.id.rb_msg:
                break;
            case R.id.rb_setting:
                break;
            case R.id.rb_about:
                break;
            case R.id.iv_search:
                Toast.makeText(this, "search被点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_mine:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, mineFragment).commit();
                break;
            case R.id.tv_yk:
                if (yueKuFragment == null) {
                    yueKuFragment = new YueKuFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, yueKuFragment).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        rbHome.setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
