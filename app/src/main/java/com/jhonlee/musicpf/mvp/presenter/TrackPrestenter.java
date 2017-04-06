package com.jhonlee.musicpf.mvp.presenter;

import com.google.gson.Gson;
import com.jhonlee.musicpf.mvp.contract.SongContract;
import com.jhonlee.musicpf.mvp.contract.TrackContract;
import com.jhonlee.musicpf.network.NetworkApi;
import com.jhonlee.musicpf.network.api.IMusicRequest;
import com.jhonlee.musicpf.pojo.Song;
import com.jhonlee.musicpf.pojo.Token;
import com.jhonlee.musicpf.pojo.TrackToken;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JhoneLee on 2017/3/22.
 */

public class TrackPrestenter implements TrackContract.Presenter {

    private TrackContract.View view;

    @Override
    public void loadAboutTrack(int id,String ids) {
        view.showProgress();
        Observable<TrackToken> observable = NetworkApi.getNetworkApi().create(IMusicRequest.class).getSongDetial(id,ids);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TrackToken>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.dismisProgress();
                        view.showError(e.getMessage());
                    }
                    @Override
                    public void onNext(TrackToken token) {
                        view.dismisProgress();
                        if (token.getCode() ==200){

                            view.loadAboutTrack(token.getSongs().get(0));
                        }
                    }
                });
    }
    @Override
    public void attachView(TrackContract.View view) {
        this.view = view;
    }
}
