package com.jhonlee.musicpf.network.api;


import com.jhonlee.musicpf.pojo.LyricToken;
import com.jhonlee.musicpf.pojo.Token;
import com.jhonlee.musicpf.pojo.TrackToken;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public interface IMusicRequest {

    //s：搜索的内容  offset：偏移量（分页用）  limit：获取的数量
    // type：搜索的类型 歌曲 1 专辑 10 歌手 100 歌单 1000 用户 1002 mv 1004 歌词 1006 主播电台 1009
    @POST("search/get/")
    Observable<Token> getPlayLists(@Query("s") String search, @Query("type") int type, @Query("limit") int limit);
    @POST("playlist/detail")
    Observable<Token> getPlayListDetials(@Query("id") int id);

    @POST("song/detail")
    Observable<TrackToken> getSongDetial(@Query("id") int id, @Query("ids") String ids);

    //lv=-1&kv=-1&tv=-1
    @POST("song/lyric")
    Observable<LyricToken> getSongLyric(@Query("id") int id, @Query("lv") int lv, @Query("kv") int kv, @Query("tv") int tv);
}
