package com.jhonlee.musicpf.view;

import android.app.Application;
import android.content.Intent;

import com.jhonlee.musicpf.service.MusicService;

/**
 * Created by JhoneLee on 2017/3/27.
 */

public class MusicApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(getApplicationContext(),MusicService.class);
        startService(intent);
    }
}
