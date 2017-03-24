package com.jhonlee.musicpf.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by JhoneLee on 2017/3/24.
 */

public class MusicService extends Service {


    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    private class MusicReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }
    private class SeekBarReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }
}
