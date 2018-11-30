package com.dotawang.mvpdemo4.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dotawang.mvpdemo4.presenter.IPresenter;
import com.dotawang.mvpdemo4.view.IView;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description MVP模式的Activity基类
 */
public abstract class BaseMVPActivity<T extends IPresenter> extends AppCompatActivity implements IView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        init();
    }

    private void initPresenter() {
        mPresenter = createPresenter();
        //绑定生命周期
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 创建一个Presenter
     */
    protected abstract T createPresenter();

    /**
     * 初始化
     */
    protected abstract void init();

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }


}
