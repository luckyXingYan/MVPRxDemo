package com.xy.mvprxdemo.base.mvp;

import java.lang.ref.WeakReference;

/**
 * Created by 邢燕 on 2019/8/7 19:53.
 * Email:lucky_xyic@sina.cn
 * ToDo:
 */
public abstract class MvpBasePresenter<V extends IMvpBaseView>{
    private WeakReference<V> viewRef;
    public void attachView(V view){
        createModel();
        viewRef = new WeakReference<>(view);
    }

    public abstract void createModel();
}
