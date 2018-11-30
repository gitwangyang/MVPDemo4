package com.dotawang.mvpdemo4.view;

import android.view.View;
import android.widget.TextView;

import com.dotawang.mvpdemo4.R;
import com.dotawang.mvpdemo4.base.BaseMVPActivity;
import com.dotawang.mvpdemo4.bean.LoginBean;
import com.dotawang.mvpdemo4.contract.LoginContract;
import com.dotawang.mvpdemo4.presenter.LoginPresenter;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description  登录界面
 */
public class LoginActivity extends BaseMVPActivity<LoginPresenter> implements LoginContract.View {

    private TextView tv;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void init() {
        setContentView(R.layout.activity_login);
        tv = findViewById(R.id.tv);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getLoginData(0);
            }
        });
    }


    @Override
    public void loginSuccess(LoginBean bean) {
        tv.setText("请求成功并Activity中显示内容");
    }

    @Override
    public void loginFailure(String errorMsg) {
        tv.setText("请求失败并Activity中显示内容");
    }
}
