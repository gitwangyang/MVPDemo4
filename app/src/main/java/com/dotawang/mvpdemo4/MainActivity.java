package com.dotawang.mvpdemo4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dotawang.mvpdemo4.base.BaseMVPActivity;
import com.dotawang.mvpdemo4.base.MultiplePresenter;
import com.dotawang.mvpdemo4.bean.LoginBean;
import com.dotawang.mvpdemo4.bean.MainBean;
import com.dotawang.mvpdemo4.contract.LoginContract;
import com.dotawang.mvpdemo4.contract.MainContract;
import com.dotawang.mvpdemo4.presenter.LoginPresenter;
import com.dotawang.mvpdemo4.presenter.MainPresenter;

import org.w3c.dom.Text;

public class MainActivity extends BaseMVPActivity<MultiplePresenter> implements LoginContract.View,MainContract.View{

    private TextView tv1,tv2;

    private LoginPresenter mLoginPresenter;
    private MainPresenter mMainPresenter;
    @Override
    protected MultiplePresenter createPresenter() {
        MultiplePresenter multiplePresenter = new MultiplePresenter(this);

        mLoginPresenter = new LoginPresenter();
        mMainPresenter = new MainPresenter();

        multiplePresenter.addPresenter(mLoginPresenter);
        multiplePresenter.addPresenter(mMainPresenter);
        return multiplePresenter;
    }

    @Override
    protected void init() {
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.getLoginData(0);
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPresenter.getMainData(0);
            }
        });
    }

    @Override
    public void mainSuccess(MainBean bean) {
        tv1.setText("main success");
    }

    @Override
    public void mainFailure(String errorMsg) {
        tv1.setText("main failure");
    }

    @Override
    public void loginSuccess(LoginBean bean) {
        tv1.setText("login success");
    }

    @Override
    public void loginFailure(String errorMsg) {
        tv1.setText("login failure");
    }
}
