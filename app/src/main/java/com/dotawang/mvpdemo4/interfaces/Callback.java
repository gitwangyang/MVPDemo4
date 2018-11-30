package com.dotawang.mvpdemo4.interfaces;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description 所有model中的回调
 */
public interface Callback<K, V> {
    void onSuccess(K data);

    void onFail(V data);
}
