package com.jhonlee.musicpf.mvp.presenter;

import com.google.gson.Gson;
import com.jhonlee.musicpf.mvp.contract.PlayListContract;
import com.jhonlee.musicpf.mvp.contract.SongContract;
import com.jhonlee.musicpf.network.NetworkApi;
import com.jhonlee.musicpf.network.api.IMusicRequest;
import com.jhonlee.musicpf.pojo.PlayList;
import com.jhonlee.musicpf.pojo.Song;
import com.jhonlee.musicpf.pojo.Token;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JhoneLee on 2017/3/22.
 */

public class SongPrestenter implements SongContract.Presenter {

    private SongContract.View view;

    @Override
    public void loadSongs(int id) {
        view.showProgress();
        Observable<Token> observable = NetworkApi.getNetworkApi().create(IMusicRequest.class).getPlayListDetials(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.dismisProgress();
                        view.showError(e.getMessage());
                    }
                    @Override
                    public void onNext(Token token) {
                        view.dismisProgress();
                        if (token.getCode() ==200){
                            Gson gson = new Gson();
                            String json = gson.toJson(token.getResult());
                            Song song = gson.fromJson(json,Song.class);
                            view.loadSongs(song.getTracks());
                        }else {
                            view.showError(token.getResult().toString());
                        }
                    }
                });
    }
    @Override
    public void attachView(SongContract.View view) {
        this.view = view;
    }
}
