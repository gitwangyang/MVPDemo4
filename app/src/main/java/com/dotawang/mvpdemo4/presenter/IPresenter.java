package com.dotawang.mvpdemo4.presenter;

import com.dotawang.mvpdemo4.view.IView;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description
 */
public interface IPresenter<T extends IView> {
    /**
     * 依附生命view
     *
     * @param view
     */
    void attachView(T view);

    /**
     * 分离View
     */
    void detachView();

    /**
     * 判断View是否已经销毁
     *
     * @return
     */
    boolean isViewAttached();
}
