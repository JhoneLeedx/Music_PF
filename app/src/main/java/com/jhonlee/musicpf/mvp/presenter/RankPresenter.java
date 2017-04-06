package com.jhonlee.musicpf.mvp.presenter;

import com.google.gson.Gson;
import com.jhonlee.musicpf.mvp.contract.RankContract;
import com.jhonlee.musicpf.network.NetworkApi;
import com.jhonlee.musicpf.network.api.IMusicRequest;
import com.jhonlee.musicpf.pojo.PlayList;
import com.jhonlee.musicpf.pojo.Rank;
import com.jhonlee.musicpf.pojo.Token;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JhoneLee on 2017/3/23.
 */

public class RankPresenter implements RankContract.Presenter {

    private RankContract.View view;

    @Override
    public void loadRanks(String search, int type, int limit) {
        view.showProgress();
        Observable<Token> observable = NetworkApi.getNetworkApi().create(IMusicRequest.class).getPlayLists(search,type,limit);
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
                            Rank rank = gson.fromJson(json,Rank.class);
                            view.loadSongs(rank.getSongs());
                        }else {
                            view.showError(token.getResult().toString());
                        }
                    }
                });
    }

    @Override
    public void attachView(RankContract.View view) {
        this.view = view ;
    }




}
