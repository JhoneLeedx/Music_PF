package com.jhonlee.musicpf.mvp.presenter;

import com.jhonlee.musicpf.mvp.view.BaseView;

/**
 * Created by JhoneLee on 2017/3/22.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

}