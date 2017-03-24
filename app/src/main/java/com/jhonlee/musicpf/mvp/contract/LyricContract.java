package com.jhonlee.musicpf.mvp.contract;

import com.jhonlee.musicpf.mvp.presenter.BasePresenter;
import com.jhonlee.musicpf.mvp.view.BaseView;
import com.jhonlee.musicpf.pojo.Lyric;
import com.jhonlee.musicpf.pojo.Song;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/24.
 */

public interface LyricContract {

    interface View extends BaseView {

        void loadLyric(List<Lyric> list);
        void showError(String error);
    }
    interface Presenter extends BasePresenter<LyricContract.View> {

        void loadLyric(int id);
    }
}
