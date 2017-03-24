package com.jhonlee.musicpf.mvp.contract;

import com.jhonlee.musicpf.mvp.presenter.BasePresenter;
import com.jhonlee.musicpf.mvp.view.BaseView;
import com.jhonlee.musicpf.pojo.PlayList;
import com.jhonlee.musicpf.pojo.Song;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/22.
 */

public interface SongContract {

    interface View extends BaseView {

        void loadSongs(List<Song.TracksBean> list);
        void dismisProgress();
        void showProgress();
        void showError(String error);
    }
    interface Presenter extends BasePresenter<View> {

        void loadSongs(int id);
    }
}
