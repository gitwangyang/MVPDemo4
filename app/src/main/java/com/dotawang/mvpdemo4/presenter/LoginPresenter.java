package com.dotawang.mvpdemo4.presenter;

import android.util.Log;

import com.dotawang.mvpdemo4.base.BasePresenter;
import com.dotawang.mvpdemo4.bean.LoginBean;
import com.dotawang.mvpdemo4.contract.LoginContract;
import com.dotawang.mvpdemo4.interfaces.Callback;
import com.dotawang.mvpdemo4.model.ILoginModel;
import com.dotawang.mvpdemo4.model.LoginModel;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description 处理model解析的数据，然后通知view更新UI
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter{

    private final ILoginModel mILoginModel;

    public LoginPresenter() {
        mILoginModel = new LoginModel();
    }

    @Override
    public void getLoginData(int curPage) {
        mILoginModel.getModelData(curPage, new Callback<LoginBean,String>() {
            @Override
            public void onSuccess(LoginBean loginResultBean) {
                Log.i("dota","login success 数据处理"+loginResultBean.toString());
                if (isViewAttached()){
                    mView.loginSuccess(loginResultBean);
                }
            }

            @Override
            public void onFail(String errorMsg) {
                Log.i("dota","login failure数据处理"+errorMsg);
                if (isViewAttached()){
                    mView.loginFailure(errorMsg);
                }
            }
        });
    }

}
