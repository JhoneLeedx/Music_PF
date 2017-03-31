package com.jhonlee.musicpf.view.detail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.jhonlee.musicpf.R;
import com.jhonlee.musicpf.listener.MusicListener;
import com.jhonlee.musicpf.mvp.contract.LyricContract;
import com.jhonlee.musicpf.mvp.contract.TrackContract;
import com.jhonlee.musicpf.mvp.presenter.LyricPrestenter;
import com.jhonlee.musicpf.mvp.presenter.TrackPrestenter;
import com.jhonlee.musicpf.pojo.Lyric;
import com.jhonlee.musicpf.pojo.Song;
import com.jhonlee.musicpf.pojo.SongDetail;
import com.jhonlee.musicpf.pojo.TrackToken;
import com.jhonlee.musicpf.util.Const;
import com.jhonlee.musicpf.util.FastBlurUtil;
import com.jhonlee.musicpf.util.SharedPerencesUtil;
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

public class MusicActivity extends AppCompatActivity implements TrackContract.View, LyricContract.View,SeekBar.OnSeekBarChangeListener{

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
    @BindView(R.id.iv_all)
    ImageView ivAll;
    private int mId;
    private int playType;
    private boolean isplaying;
    private TrackToken.SongsBean mSong;

    private List<View> views;
    private LrcView lrcView;
    private ImageView alumView;
    private ArrayList<Integer> integers ;
    private ArrayList<SongDetail> songList;
    private TrackContract.Presenter presenter;
    private LyricContract.Presenter lyricpresenter;
    private YKLBAdapter yklbAdapter;
    private AllMenuAdapter menuAdapter;
    private MusicReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        receiver = new MusicReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Const.MUSIC_ACTION);
        registerReceiver(receiver,filter);

        playType = SharedPerencesUtil.getPlayTpye(this);
        getPlayType();

        seekbar.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver!=null)
        {
            unregisterReceiver(receiver);
        }
    }

    private void initData() {

        integers =getIntent().getIntegerArrayListExtra("integerList");
        songList =getIntent().getParcelableArrayListExtra("songList");



        Intent intent = new Intent();
        intent.setAction(Const.SERVICE_ACTION);
        intent.putExtra(Const.MUSIC_STATE,Const.STATE_ALLID);
        intent.putExtra("integers",integers);
        sendBroadcast(intent);


        mId = getIntent().getIntExtra("id", 0);
        presenter = new TrackPrestenter();
        presenter.attachView(this);

        lyricpresenter = new LyricPrestenter();
        lyricpresenter.attachView(this);
        views = new ArrayList<>();
        alumView = new ImageView(MusicActivity.this);
        views.add(alumView);

        lrcView = new LrcView(MusicActivity.this);
        views.add(lrcView);

        yklbAdapter = new YKLBAdapter(views);
        musicPager.setAdapter(yklbAdapter);
        loadSongAndLrc(mId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }else if (item.getItemId()==R.id.item_detail){
            Toast.makeText(this, "查看详情", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.iv_bf_zt, R.id.iv_previous,
            R.id.iv_play_pause, R.id.iv_next, R.id.iv_all})
    public void Click(View view) {
          Intent intent = new Intent();
          intent.setAction(Const.SERVICE_ACTION);
        switch (view.getId()) {

            case R.id.iv_bf_zt:
                getNextPlayType();
                intent.putExtra(Const.MUSIC_STATE,playType);
                sendBroadcast(intent);
                break;
            case R.id.iv_previous:
                intent.putExtra(Const.MUSIC_STATE, Const.STATE_PREVIOUS);
                sendBroadcast(intent);
                break;
            case R.id.iv_play_pause:
                if (isplaying){
                    intent.putExtra(Const.MUSIC_STATE, Const.STATE_PAUSE);
                }else {
                    intent.putExtra(Const.MUSIC_STATE, Const.STATE_PLAY);
                }
                sendBroadcast(intent);
               // handler.sendEmptyMessage(0);
                break;
            case R.id.iv_next:

                intent.putExtra(Const.MUSIC_STATE, Const.STATE_NEXT);
                sendBroadcast(intent);
                break;
            case R.id.iv_all:
                //Toast.makeText(this, "iv_all", Toast.LENGTH_SHORT).show();
                createPopup();
                break;
        }
    }

    private void createPopup(){

        final PopupWindow popupWindow = new PopupWindow(this);
        View view = LayoutInflater.from(this).inflate(R.layout.popup_music_view,null);
        MusicListener listener = new MusicListener() {
            @Override
            public void showSong(int id) {
                loadSongAndLrc(id);
                popupWindow.dismiss();
            }
        };
        popupWindow.setContentView(view);
        popupWindow.setWidth(getWindowManager().getDefaultDisplay().getWidth()/2);
        popupWindow.setHeight(getWindowManager().getDefaultDisplay().getHeight()/2);
        menuAdapter = new AllMenuAdapter(view.getContext(),songList,listener);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.all_music);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(menuAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseContext(),DividerItemDecoration.VERTICAL));



        // 使其聚集
        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAtLocation(ivAll,Gravity.END|Gravity.BOTTOM,0,100);
    }
    private void getPlayType() {

        switch (playType) {
            case Const.STATE_SHUNXU:
                ivBfZt.setImageResource(R.drawable.shunxu);
                break;
            case Const.STATE_XUNHUAN:
                ivBfZt.setImageResource(R.drawable.xunhuan);
                break;
            case Const.STATE_DANQU:
                ivBfZt.setImageResource(R.drawable.danqu);
                break;
            case Const.STATE_SUIJI:
                ivBfZt.setImageResource(R.drawable.suiji);
                break;
        }

    }
    private void getNextPlayType(){
        switch (playType) {
            case Const.STATE_SHUNXU:
                playType =Const.STATE_XUNHUAN;
                break;
            case Const.STATE_XUNHUAN:
                playType =Const.STATE_DANQU;
                break;
            case Const.STATE_DANQU:
                playType =Const.STATE_SUIJI;
                break;
            case Const.STATE_SUIJI:
                playType =Const.STATE_SHUNXU;
                break;
        }
    }
    @Override
    public void loadAboutTrack(TrackToken.SongsBean song) {

        Intent intent = new Intent();
        intent.setAction(Const.SERVICE_ACTION);
        intent.putExtra(Const.MUSIC_STATE,Const.STATE_PLAY);
        intent.putExtra("song",song);
        sendBroadcast(intent);

        mSong = song;
        Message msg = new Message();
        msg.obj = song;
        songHandler.sendEmptyMessage(0);

    }

    @Override
    public void dismisProgress() {

    }
    @Override
    public void showProgress() {

    }

    @Override
    public void loadLyric(List<Lyric> list) {
        if (list.size()>0){
            lrcView.setmList(list);
            lrcView.invalidate();
        }
    }

    @Override
    public void showError(String error) {

    }
    private void loadSongAndLrc(int id){

        String ids = new StringBuilder().append("[").append(id).append("]").toString();
        presenter.loadAboutTrack(id, ids);
        lyricpresenter.loadLyric(id);
    }
    private Handler songHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){

                if (mSong != null) {
                    tvAuthor.setText(mSong.getArtists().get(0).getName());
                    tvTitle.setText(mSong.getName());
                   // seekbar.setMax(mSong.getDuration());
                    tvAllTime.setText(TimeUtil.formatTime(mSong.getDuration()));
                    Glide.with(MusicActivity.this).load(mSong.getAlbum().getPicUrl())
                            .asBitmap().into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            musicPager.setBackground(new BitmapDrawable(FastBlurUtil.toBlur(resource, 10)));
                        }
                    });
                    Glide.with(MusicActivity.this)
                            .load(mSong.getAlbum().getPicUrl())
                            .animate(AnimationUtils.loadAnimation(MusicActivity.this, R.anim.img_anim))
                            .bitmapTransform(new CropCircleTransformation(MusicActivity.this))
                            .into(alumView);
                }
            }
        }
    };

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {

                if (isplaying){
                    Glide.with(MusicActivity.this).load(R.drawable.pause_64).into(ivPlayPause);
                }else {
                    Glide.with(MusicActivity.this).load(R.drawable.play_64).into(ivPlayPause);
                }
            }else if (msg.what ==1){
                getPlayType();
            }else if (msg.what ==3){
                seekbar.setProgress(0);
                lrcView.refreshLcy();
            }
        }
    };

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser){
            if (lrcView.getmList()!=null){
                lrcView.refreshLcy();
                lrcView.updateTime(progress);
            }
            Intent intent = new Intent();
            intent.setAction(Const.SERVICE_ACTION);
            intent.putExtra(Const.MUSIC_STATE,Const.STATE_SEEK);
            intent.putExtra("progress",progress);
            sendBroadcast(intent);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (lrcView.getmList()!=null){
            lrcView.refreshLcy();
        }
    }

    private class MusicReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int state = intent.getIntExtra(Const.MUSIC_STATE,0);
            switch (state){
                case Const.STATE_NEXT:
                    if (lrcView.getmList()!=null){
                        lrcView.refreshLcy();
                        lrcView.clearList();
                    }
                    mId = intent.getIntExtra("id",0);
                    loadSongAndLrc(mId);
                    break;
                case Const.STATE_PLAY:
                    isplaying = intent.getBooleanExtra("isplay",false);
                    seekbar.setMax(intent.getIntExtra("alltime",0));
                    handler.sendEmptyMessage(0);
                    break;
                case Const.STATE_SEEK:
                   int currentTime =  intent.getIntExtra("currentTime",0);
                    seekbar.setProgress(currentTime);
                    tvCurrentTime.setText(TimeUtil.formatTime(currentTime));
                    if (lrcView.getmList()!=null){
                        if (currentTime==seekbar.getMax()){
                            lrcView.refreshLcy();
                        }else {
                            lrcView.updateTime(currentTime);
                        }
                    }
                    break;
                case Const.STATE_PLAY_TYPE:
                    playType = intent.getIntExtra("playType",0);
                    handler.sendEmptyMessage(1);
                    break;
            }

        }
    }
}
