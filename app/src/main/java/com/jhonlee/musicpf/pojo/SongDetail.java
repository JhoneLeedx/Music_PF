package com.jhonlee.musicpf.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JhoneLee on 2017/3/31.
 */

public class SongDetail implements Parcelable{

    private int mId;
    private String mName;
    private String author;
    private int time;

    public SongDetail(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        author = in.readString();
        time = in.readInt();
    }

    public static final Creator<SongDetail> CREATOR = new Creator<SongDetail>() {
        @Override
        public SongDetail createFromParcel(Parcel in) {
            return new SongDetail(in);
        }

        @Override
        public SongDetail[] newArray(int size) {
            return new SongDetail[size];
        }
    };

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mName);
        dest.writeString(author);
        dest.writeInt(time);
    }
}
