package com.jhonlee.musicpf.view.detail;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.jhonlee.musicpf.R;
import com.jhonlee.musicpf.mvp.contract.LyricContract;
import com.jhonlee.musicpf.mvp.contract.TrackContract;
import com.jhonlee.musicpf.mvp.presenter.LyricPrestenter;
import com.jhonlee.musicpf.mvp.presenter.TrackPrestenter;
import com.jhonlee.musicpf.pojo.Lyric;
import com.jhonlee.musicpf.pojo.TrackToken;
import com.jhonlee.musicpf.util.FastBlurUtil;
import com.jhonlee.musicpf.util.TimeUtil;
import com.jhonlee.musicpf.view.yueku.YKLBAdapter;
import com.jhonlee.musicpf.wedget.LrcView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by JhoneLee on 2017/3/23.
 */

public class MusicActivity extends AppCompatActivity implements TrackContract.View, LyricContract.View {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.music_pager)
    ViewPager musicPager;
    @BindView(R.id.tv_current_time)
    TextView tvCurrentTime;
    @BindView(R.id.seekbar)
    SeekBar seekbar;
    @BindView(R.id.tv_all_time)
    TextView tvAllTime;
    @BindView(R.id.rl_music)
    RelativeLayout rlMusic;


    @BindView(R.id.iv_bf_zt)
    ImageView ivBfZt;
    @BindView(R.id.iv_play_pause)
    ImageView ivPlayPause;

    private int mId;
    private int ztIndex = 0;
    private boolean isplaying;
    private TrackToken.SongsBean mSong;
    private List<Lyric> mList;
    private List<View> views;
    private LrcView lrcView;

    private TrackContract.Presenter presenter;
    private LyricContract.Presenter lyricpresenter;
    private YKLBAdapter yklbAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    private void initData() {

        mId = getIntent().getIntExtra("id", 0);
        presenter = new TrackPrestenter();
        presenter.attachView(this);
        String ids = new StringBuilder().append("[").append(mId).append("]").toString();
        presenter.loadAboutTrack(mId, ids);

        lyricpresenter = new LyricPrestenter();
        lyricpresenter.attachView(this);
        lyricpresenter.loadLyric(mId);

        views = new ArrayList<>();

        yklbAdapter = new YKLBAdapter(views);
        musicPager.setAdapter(yklbAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.iv_bf_zt, R.id.iv_previous,
            R.id.iv_play_pause, R.id.iv_next, R.id.iv_all})
    public void Click(View view) {
        switch (view.getId()) {
            case R.id.iv_bf_zt:
                getZtindex();
                break;
            case R.id.iv_previous:
                break;
            case R.id.iv_play_pause:
                handler.sendEmptyMessage(0);
                break;
            case R.id.iv_next:
                break;
            case R.id.iv_all:
                break;
        }
    }

    private void getZtindex() {
        switch (ztIndex) {
            case 0:
                ivBfZt.setImageResource(R.drawable.shunxu);
                break;
            case 1:
                ivBfZt.setImageResource(R.drawable.xunhuan);
                break;
            case 2:
                ivBfZt.setImageResource(R.drawable.danqu);
                break;
            case 3:
                ivBfZt.setImageResource(R.drawable.suiji);
                break;
        }

    }

    @Override
    public void loadAboutTrack(TrackToken.SongsBean song) {
        Message msg = new Message();
        msg.obj = song;
        songHandler.sendMessage(msg);
    }

    @Override
    public void dismisProgress() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void loadLyric(List<Lyric> list) {
        Message msg = new Message();
        msg.obj = list;
        lrcHandler.sendMessage(msg);
    }

    @Override
    public void showError(String error) {

    }

    private Handler songHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mSong = (TrackToken.SongsBean) msg.obj;
            if (mSong != null) {
                tvAuthor.setText(mSong.getArtists().get(0).getName());
                tvTitle.setText(mSong.getName());
                tvAllTime.setText(TimeUtil.formatTime(mSong.getDuration()));
                Glide.with(MusicActivity.this).load(mSong.getAlbum().getPicUrl())
                        .asBitmap().into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        musicPager.setBackground(new BitmapDrawable(FastBlurUtil.toBlur(resource, 10)));

                    }
                });
            }
        }
    };

    private Handler lrcHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mList = (List<Lyric>) msg.obj;
        }
    };
    private Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                views.clear();

                if (mSong!=null&&mList != null&&mList.size()>0) {
                    ImageView imageView = new ImageView(MusicActivity.this);
                    Glide.with(MusicActivity.this)
                            .load(mSong.getAlbum().getPicUrl())
                            .animate(AnimationUtils.loadAnimation(MusicActivity.this, R.anim.img_anim))
                            .bitmapTransform(new CropCircleTransformation(MusicActivity.this))
                            .into(imageView);
                    views.add(imageView);
                    LrcView lrcView = new LrcView(MusicActivity.this, mList);
                    views.add(lrcView);
                    yklbAdapter.notifyDataSetChanged();
                }else if (mSong!=null&&(mList==null||mList.size()==0)){
                    ImageView imageView = new ImageView(MusicActivity.this);
                    Glide.with(MusicActivity.this)
                            .load(mSong.getAlbum().getPicUrl())
                            .animate(AnimationUtils.loadAnimation(MusicActivity.this, R.anim.img_anim))
                            .bitmapTransform(new CropCircleTransformation(MusicActivity.this))
                            .into(imageView);
                    views.add(imageView);
                    TextView textView = new TextView(MusicActivity.this);
                    textView.setWidth(ViewPager.LayoutParams.MATCH_PARENT);
                    textView.setHeight(ViewPager.LayoutParams.MATCH_PARENT);
                    textView.setText("目前暂无歌词....");
                    textView.setTextColor(Color.WHITE);
                    textView.setTextSize(32f);
                    textView.setGravity(Gravity.CENTER);
                    views.add(textView);
                    yklbAdapter.notifyDataSetChanged();
                }
            }
        }
    };
}
