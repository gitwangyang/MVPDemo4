package com.dotawang.mvpdemo4.base;

import com.dotawang.mvpdemo4.presenter.IPresenter;
import com.dotawang.mvpdemo4.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description 单页面多网络请求时 presenter容器
 */
public class MultiplePresenter<T extends IView> extends BasePresenter<T> {
    private T mView;

    private List<IPresenter> presenters = new ArrayList<>();

    @SafeVarargs
    public final <K extends IPresenter<T>> void addPresenter(K... addPresenter) {
        for (K ap : addPresenter) {
            ap.attachView(mView);
            presenters.add(ap);
        }
    }

    public MultiplePresenter(T mView) {
        this.mView = mView;
    }

    @Override
    public void detachView() {
        for (IPresenter presenter : presenters) {
            presenter.detachView();
        }
        mView = null;
    }
}
