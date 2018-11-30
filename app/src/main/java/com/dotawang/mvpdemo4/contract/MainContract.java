package com.dotawang.mvpdemo4.contract;

import com.dotawang.mvpdemo4.base.BasePresenter;
import com.dotawang.mvpdemo4.bean.MainBean;
import com.dotawang.mvpdemo4.model.IModel;
import com.dotawang.mvpdemo4.view.IView;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description
 */
public interface MainContract {

    interface View extends IView{
        void mainSuccess(MainBean bean);

        void mainFailure(String errorMsg);
    }

    interface Presenter {
        void getMainData(int curPage);
    }
}
