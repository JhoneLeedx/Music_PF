package com.jhonlee.musicpf.mvp.presenter;

import com.google.gson.Gson;
import com.jhonlee.musicpf.mvp.contract.PlayListContract;
import com.jhonlee.musicpf.network.NetworkApi;
import com.jhonlee.musicpf.pojo.PlayList;
import com.jhonlee.musicpf.pojo.Token;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JhoneLee on 2017/3/22.
 */

public class PlayListPrestenter implements PlayListContract.Presenter {

    private PlayListContract.View view;

    @Override
    public void loadPlayLists(String search, int type,int limit) {
        Observable<Token> observable = NetworkApi.getNetworkApi().getImusic().getPlayLists(search,type,limit);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(Token token) {
                        if (token.getCode() ==200){
                            Gson gson = new Gson();
                            String json = gson.toJson(token.getResult());
                            PlayList playList = gson.fromJson(json,PlayList.class);
                            view.loadPlayLists(playList.getPlaylists());
                        }
                    }
                });
    }
    @Override
    public void attachView(PlayListContract.View view) {
        this.view = view;
    }
}
