package com.dotawang.mvpdemo4.presenter;

import android.util.Log;

import com.dotawang.mvpdemo4.base.BasePresenter;
import com.dotawang.mvpdemo4.bean.MainBean;
import com.dotawang.mvpdemo4.contract.MainContract;
import com.dotawang.mvpdemo4.interfaces.Callback;
import com.dotawang.mvpdemo4.model.IMainModel;
import com.dotawang.mvpdemo4.model.MainModel;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter{

    private final IMainModel mIMainModel;

    public MainPresenter() {
        mIMainModel = new MainModel();
    }

    @Override
    public void getMainData(int curPage) {
        mIMainModel.getModelData(curPage, new Callback<MainBean,String>() {
            @Override
            public void onSuccess(MainBean mainResultBean) {
                Log.i("dota","main success 数据处理"+mainResultBean.toString());
                if (isViewAttached()){
                    mView.mainSuccess(mainResultBean);
                }
            }

            @Override
            public void onFail(String errorMsg) {
                Log.i("dota","main failure数据处理"+errorMsg);
                if (isViewAttached()){
                    mView.mainFailure(errorMsg);
                }
            }
        });
    }
}
