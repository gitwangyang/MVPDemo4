package com.dotawang.mvpdemo4.contract;

import com.dotawang.mvpdemo4.bean.LoginBean;
import com.dotawang.mvpdemo4.interfaces.Callback;
import com.dotawang.mvpdemo4.model.IModel;
import com.dotawang.mvpdemo4.view.IView;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description
 */
public interface LoginContract {

    interface View extends IView{
        void loginSuccess(LoginBean bean);

        void loginFailure(String errorMsg);
    }

    interface Presenter{
        void getLoginData(int curPage);
    }
}
