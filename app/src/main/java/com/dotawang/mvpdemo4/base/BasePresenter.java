package com.dotawang.mvpdemo4.base;

import com.dotawang.mvpdemo4.presenter.IPresenter;
import com.dotawang.mvpdemo4.view.IView;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description 单页面单网络请求时 presenter容器
 */
public abstract class BasePresenter<T extends IView> implements IPresenter<T> {
    protected T mView;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public boolean isViewAttached() {
        return mView != null;
    }
}
