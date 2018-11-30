package com.dotawang.mvpdemo4.model;

import com.dotawang.mvpdemo4.interfaces.Callback;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description
 */
public interface IMainModel extends IModel {
    void getModelData(int curPage, final Callback callback);
}
