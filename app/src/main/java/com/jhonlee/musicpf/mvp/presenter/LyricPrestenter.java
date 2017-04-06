package com.jhonlee.musicpf.mvp.presenter;

import com.jhonlee.musicpf.mvp.contract.LyricContract;
import com.jhonlee.musicpf.mvp.contract.TrackContract;
import com.jhonlee.musicpf.network.NetworkApi;
import com.jhonlee.musicpf.network.api.IMusicRequest;
import com.jhonlee.musicpf.pojo.Lyric;
import com.jhonlee.musicpf.pojo.LyricToken;
import com.jhonlee.musicpf.pojo.TrackToken;
import com.jhonlee.musicpf.util.MusicUtil;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JhoneLee on 2017/3/22.
 */

public class LyricPrestenter implements LyricContract.Presenter {

    private LyricContract.View view;


    @Override
    public void attachView(LyricContract.View view) {
        this.view = view;
    }

    @Override
    public void loadLyric(int id) {
        Observable<LyricToken> observable = NetworkApi.getNetworkApi().create(IMusicRequest.class).getSongLyric(id,-1,-1,-1);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LyricToken>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {
                        view.equals(e.getMessage());
                    }
                    @Override
                    public void onNext(LyricToken token) {
                        if (token.getCode()==200){
                            String time = token.getLrc().getLyric();
                            List<Lyric> lyrics = MusicUtil.getLyrics(time);
                            view.loadLyric(lyrics);
                        }
                    }
                });
    }
}
