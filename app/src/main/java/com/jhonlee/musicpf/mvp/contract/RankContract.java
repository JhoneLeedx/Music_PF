package com.jhonlee.musicpf.mvp.contract;

import com.jhonlee.musicpf.mvp.presenter.BasePresenter;
import com.jhonlee.musicpf.mvp.view.BaseView;
import com.jhonlee.musicpf.pojo.Rank;
import com.jhonlee.musicpf.pojo.Song;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/23.
 */

public interface RankContract {

    interface View extends BaseView {

        void loadSongs(List<Rank.SongsBean> list);
        void dismisProgress();
        void showProgress();
        void showError(String error);

    }
    interface Presenter extends BasePresenter<RankContract.View> {
        void loadRanks(String search, int type,int limit);
    }
}
