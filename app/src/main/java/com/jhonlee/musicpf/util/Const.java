package com.jhonlee.musicpf.util;

/**
 * Created by JhoneLee on 2017/3/13.
 */

public class Const {


    //初始化flag
    public static final int STATE_NON = 0;
    //播放的flag
    public static final int STATE_PLAY = 1;
    //暂停的flag
    public static final int STATE_PAUSE = 2;
    //停止放的flag
    public static final int STATE_STOP = 3;
    //播放上一首的flag
    public static final int STATE_PREVIOUS = 4;
    //播放下一首的flag
    public static final int STATE_NEXT = 5;
    //seekbar 时间改变
    public static final int STATE_SEEK = 6;


    public static final String URL = "http://music.163.com/api/";

}
