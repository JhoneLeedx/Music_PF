package com.jhonlee.musicpf.view;

import android.app.Application;
import android.content.Intent;

import com.jhonlee.musicpf.service.MusicService;

/**
 * Created by JhoneLee on 2017/3/27.
 */

public class MusicApplication extends Application {

    private Intent serviceIntent;

    @Override
    public void onCreate() {
        super.onCreate();
        serviceIntent = new Intent(getApplicationContext(),MusicService.class);
        startService(serviceIntent);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (serviceIntent!=null){
            stopService(serviceIntent);
            serviceIntent = null;
        }
    }
}
