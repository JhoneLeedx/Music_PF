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

import com.jhonlee.musicpf.pojo.TrackToken;
import com.jhonlee.musicpf.util.Const;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JhoneLee on 2017/3/24.
 */

public class MusicService extends Service implements MediaPlayer.OnErrorListener,MediaPlayer.OnCompletionListener{


    private MediaPlayer player;
    private MusicReceiver receiver;
    private int currentTime;

    private TrackToken.SongsBean mSong;
    private ArrayList<Integer> integers;
    private int currentIndex;
    private int playType = Const.STATE_SHUNXU;

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
        player.setOnCompletionListener(this);
        player.setOnErrorListener(this);

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

        if (integers!=null){
            switch (playType){
                case Const.STATE_SHUNXU:
                    getShunxu(integers);
                    break;
                case Const.STATE_DANQU:
                    break;
                case Const.STATE_XUNHUAN:
                    getXunhuan(integers);
                    break;
                case Const.STATE_SUIJI:
                    getRadomIndex(integers);
                    break;
            }
            Intent intent = new Intent(Const.MUSIC_ACTION);
            intent.putExtra(Const.MUSIC_STATE,Const.STATE_NEXT);
            int id = integers.get(currentIndex);
            intent.putExtra("id",id);
            sendBroadcast(intent);
        }
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {

        if(what==-1){
            Toast.makeText(MusicService.this,"音频资源异常",Toast.LENGTH_SHORT);
            if (integers!=null) {
                getShunxu(integers);
                Intent intent = new Intent(Const.MUSIC_ACTION);
                intent.putExtra(Const.MUSIC_STATE, Const.STATE_NEXT);
                int id = integers.get(currentIndex);
                intent.putExtra("id", id);
                sendBroadcast(intent);
            }
        }
        return false;
    }

    private class MusicReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int state = intent.getIntExtra(Const.MUSIC_STATE,0);
            if (playType == Const.STATE_SHUNXU){
                switch (state){
                    case Const.STATE_NEXT:
                        Intent intents = new Intent(Const.MUSIC_ACTION);
                        intents.putExtra(Const.MUSIC_STATE,Const.STATE_NEXT);
                        if (integers!=null){


                            getShunxu(integers);
                            int  id = integers.get(currentIndex);
                            intents.putExtra("id",id);
                            sendBroadcast(intent);
                            return;
                        }



                      /*  switch (playType){
                            case Const.STATE_SHUNXU:

                                break;
                            case Const.STATE_DANQU:
                                 id = integers.get(currentIndex);
                                intents.putExtra("id",id);
                                sendBroadcast(intent);
                                break;
                            case Const.STATE_XUNHUAN:
                                getXunhuan(integers);
                                id = integers.get(currentIndex);
                                intents.putExtra("id",id);
                                sendBroadcast(intent);
                                break;
                            case Const.STATE_SUIJI:
                                getRadomIndex(integers);
                                id = integers.get(currentIndex);
                                intents.putExtra("id",id);
                                sendBroadcast(intent);
                                break;
                        }

                    }*/
                        break;
                    case Const.STATE_NON:
                        break;
                    case Const.STATE_PAUSE:
                        pause();
                        break;
                    case Const.STATE_PLAY:
                        mSong = intent.getParcelableExtra("song");
                        if (mSong!=null){
                            play(mSong.getMp3Url());
                            if (integers!=null){
                                for (int i=0;i<integers.size();i++){
                                    if (integers.get(i) == mSong.getId()){
                                        currentIndex = i;
                                        return;
                                    }else {
                                        currentIndex = 0;
                                    }
                                }
                            }
                        }else {
                            resume();
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
                        playType = Const.STATE_DANQU;
                        sendPlayType();
                        break;
                    case Const.STATE_SHUNXU:
                        playType = Const.STATE_SHUNXU;
                        sendPlayType();
                        break;
                    case Const.STATE_SUIJI:
                        playType = Const.STATE_SUIJI;
                        sendPlayType();
                        break;
                    case Const.STATE_XUNHUAN:
                        playType = Const.STATE_XUNHUAN;
                        sendPlayType();
                        break;
                    case Const.STATE_STOP:
                        break;
                    case Const.STATE_ALLID:
                        integers = intent.getIntegerArrayListExtra("integers");
                        break;
                }
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
                    sendIsPlaying();
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
            sendIsPlaying();
        }
    }
    private void sendIsPlaying(){
        Intent intent = new Intent();
        intent.setAction(Const.MUSIC_ACTION);
        intent.putExtra(Const.MUSIC_STATE,Const.STATE_PLAY);
        intent.putExtra("isplay",player.isPlaying());
        intent.putExtra("alltime",player.getDuration());
        sendBroadcast(intent);
    }
    // 音乐继续播放
    private void resume() {
        player.start();
        if (currentTime > 0) {
            player.seekTo(currentTime);
        }
        sendIsPlaying();
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
    private void getRadomIndex(List<Integer> integers){
        if (integers.size()>0){
            int total = integers.size();
            currentIndex = (int) (Math.random()*total);
            if (currentIndex==total){
                currentIndex=0;
            }
        }

    }

    private void getXunhuan(List<Integer> integers){
        if (integers.size()>0){
            currentIndex++;
            if (currentIndex==integers.size()){
                currentIndex = 0 ;
            }
        }

    }
    private void getShunxu(List<Integer> integers){
        if (integers.size()>0){
            currentIndex++;
            if (currentIndex==integers.size()){
                currentIndex--;
             //   stop();
            }
            return;
        }
    }
    private void sendPlayType(){
        Intent intent = new Intent(Const.MUSIC_ACTION);
        intent.putExtra(Const.MUSIC_STATE,Const.STATE_PLAY_TYPE);
        intent.putExtra("playType",playType);
        sendBroadcast(intent);
    }
}
