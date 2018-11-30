package com.dotawang.mvpdemo4.base;

import com.dotawang.mvpdemo4.model.IModel;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description
 */
public class BaseModel implements IModel {

    //TODO
//    protected IRepositoryManager mRepositoryManager = BaseApplication.baseApplication.getAppComponent().repositoryManager();//用于管理网络请求层,以及数据缓存层

    @Override
    public void onDestory() {
        //
    }
}
