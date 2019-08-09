package com.xy.mvprxdemo.base.mvp;

/**
 * Created by 邢燕 on 2019/8/7 19:57.
 * Email:lucky_xyic@sina.cn
 * ToDo:
 */
public abstract class BasePresenter<V extends IBaseView> extends MvpBasePresenter<V> {
    public abstract void createModel();//创建对应的model

    public abstract void cancelNetWork();//取消网络请求
}
