package com.jhonlee.musicpf.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JhoneLee on 2017/3/17.
 */

public class Lyric implements Parcelable{

    private long time;
    private String lyric;

    public Lyric(Parcel in) {
        time = in.readLong();
        lyric = in.readString();
    }

    public static final Creator<Lyric> CREATOR = new Creator<Lyric>() {
        @Override
        public Lyric createFromParcel(Parcel in) {
            return new Lyric(in);
        }

        @Override
        public Lyric[] newArray(int size) {
            return new Lyric[size];
        }
    };

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(time);
        dest.writeString(lyric);
    }
}
