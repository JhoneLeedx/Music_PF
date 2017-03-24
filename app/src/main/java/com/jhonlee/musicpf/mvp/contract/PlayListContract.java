package com.jhonlee.musicpf.mvp.contract;

import com.jhonlee.musicpf.mvp.view.BaseView;
import com.jhonlee.musicpf.mvp.presenter.BasePresenter;
import com.jhonlee.musicpf.pojo.PlayList;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/22.
 */

public interface PlayListContract {

    interface View extends BaseView {

        void loadPlayLists(List<PlayList.PlaylistBean> list);
    }
    interface Presenter extends BasePresenter<View> {

        void loadPlayLists(String search, int type,int limit);

    }
}
