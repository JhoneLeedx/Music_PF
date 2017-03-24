package com.jhonlee.musicpf.util;

/**
 * Created by JhoneLee on 2017/3/24.
 */

public class TimeUtil {

    /**
     * 定义一个方法用来格式化获取到的时间
     */
    public static String formatTime(int time) {

        if (time / 1000 % 60 < 10) {
            return time / 1000 / 60 + ":0" + time / 1000 % 60;
        } else {
            return time / 1000 / 60 + ":" + time / 1000 % 60;
        }
    }

}
