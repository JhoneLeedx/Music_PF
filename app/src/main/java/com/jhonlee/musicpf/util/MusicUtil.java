package com.jhonlee.musicpf.util;

import android.os.Parcel;

import com.jhonlee.musicpf.pojo.Lyric;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JhoneLee on 2017/3/24.
 */

public class MusicUtil {

    public static List<Lyric> getLyrics(String lyric) {

        List<Lyric> lyrics = new ArrayList<>();
        String lyricy = lyric.replace("\n", "");
        if (lyricy != null) {
            String[] strings = lyricy.trim().split("\\[");
            for (int i = 0; i < strings.length; i++) {
                int index = strings[i].indexOf("]");
                if (index != -1) {
                    String str = strings[i].substring(0, index).trim();
                    if (str.startsWith("0")) {
                        Lyric lyc = new Lyric(Parcel.obtain());
                        lyc.setLyric(strings[i].substring(index + 1).trim());
                        lyc.setTime(lrcData(str));
                        lyrics.add(lyc);
                    }
                }
            }
        }
        return lyrics;

    }

    private static int lrcData(String time) {
        time = time.replace(":", "#");
        time = time.replace(".", "#");
        String[] mTime = time.split("#");
        //[03:31.42]
        int mtime = Integer.parseInt(mTime[0]);
        int stime = Integer.parseInt(mTime[1]);
        int mitime = Integer.parseInt(mTime[2]);
        int ctime = (mtime * 60 + stime) * 1000 + mitime * 10;
        return ctime;
    }
}
