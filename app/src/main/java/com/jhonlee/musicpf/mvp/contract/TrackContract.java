package com.jhonlee.musicpf.mvp.contract;

import com.jhonlee.musicpf.mvp.presenter.BasePresenter;
import com.jhonlee.musicpf.mvp.view.BaseView;
import com.jhonlee.musicpf.pojo.Song;
import com.jhonlee.musicpf.pojo.TrackToken;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/24.
 */

public interface TrackContract {

    interface View extends BaseView {

        void loadAboutTrack(TrackToken.SongsBean song);
        void dismisProgress();
        void showProgress();
        void showError(String error);
    }
    interface Presenter extends BasePresenter<TrackContract.View> {

        void loadAboutTrack(int id,String ids);
    }
}
