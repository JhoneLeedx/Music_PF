package com.jhonlee.musicpf.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.jhonlee.musicpf.pojo.Song;
import com.jhonlee.musicpf.pojo.TrackToken;
import com.jhonlee.musicpf.util.Const;

import java.io.IOException;

/**
 * Created by JhoneLee on 2017/3/24.
 */

public class MusicService extends Service implements MediaPlayer.OnErrorListener,MediaPlayer.OnCompletionListener{


    private MediaPlayer player;
    private MusicReceiver receiver;
    private int currentTime;

    private TrackToken.SongsBean mSong;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        player = new MediaPlayer();
        receiver = new MusicReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Const.SERVICE_ACTION);
        registerReceiver(receiver,filter);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player!=null)
            player = null;
        unregisterReceiver(receiver);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {

        if(what==-1){
            Toast.makeText(MusicService.this,"音频资源异常",Toast.LENGTH_SHORT);
        }
        return false;
    }

    private class MusicReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int state = intent.getIntExtra(Const.MUSIC_STATE,0);
            switch (state){
                case Const.STATE_NEXT:
                    break;
                case Const.STATE_NON:
                    break;
                case Const.STATE_PAUSE:
                    break;
                case Const.STATE_PLAY:
                    mSong = intent.getParcelableExtra("song");
                    if (mSong!=null){
                        play(mSong.getMp3Url());
                    }
                    break;
                case Const.STATE_PREVIOUS:
                    break;
                case Const.STATE_SEEK:
                    int progress = intent.getIntExtra("progress",0);
                    if (progress!=0){
                        currentTime = progress;
                        resume();
                    }
                    break;
                case Const.STATE_DANQU:
                    break;
                case Const.STATE_SHUNXU:
                    break;
                case Const.STATE_SUIJI:
                    break;
                case Const.STATE_XUNHUAN:
                    break;
                case Const.STATE_STOP:
                    break;
            }
        }
    }

    // 音乐播放
    private void play(final String musicUrl) {

        try {
            player.reset();
            player.setDataSource(musicUrl);
            player.prepareAsync();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    Intent intent = new Intent();
                    intent.setAction(Const.MUSIC_ACTION);
                   // allTime = player.getDuration();
                    intent.putExtra(Const.MUSIC_STATE,Const.STATE_PLAY);
                    intent.putExtra("isplay",true);
                    //intent.putExtra("duration", allTime);  //通过Intent来传递歌曲的总长度
                    sendBroadcast(intent);
                    handler.sendEmptyMessage(0);
                }
            });
        } catch (IOException e) {
        }
    }
    // 音乐暂停
    private void pause() {
        if (player.isPlaying()) {
            currentTime = player.getCurrentPosition();
            player.pause();
        }
    }
    // 音乐继续播放
    private void resume() {
        player.start();
        if (currentTime > 0) {
            player.seekTo(currentTime);
        }
        handler.sendEmptyMessage(0);

    }
    // 音乐停止
    private void stop() {
        player.stop();
        try {
            player.prepare();
        } catch (IOException e) {
        }
    }

    private Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
                if (player.isPlaying()){
                    currentTime = player.getCurrentPosition();
                    Intent intent = new Intent();
                    intent.setAction(Const.MUSIC_ACTION);
                    intent.putExtra(Const.MUSIC_STATE,Const.STATE_SEEK);
                    intent.putExtra("currentTime",currentTime);
                    sendBroadcast(intent);
                    //间隔一秒给ui发消息更新seekbar
                    handler.sendEmptyMessageDelayed(0,1000);
                }
            }
        }
    };
}
