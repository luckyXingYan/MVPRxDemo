package com.xy.mvprxdemo.base.mvp;

import java.lang.ref.WeakReference;

/**
 * Created by 邢燕 on 2019/8/7 19:53.
 * Email:lucky_xyic@sina.cn
 * ToDo:
 */
public abstract class MvpBasePresenter<V extends IMvpBaseView> {
    private WeakReference<V> viewRef;

    /**
     * 界面创建，presenter 与界面取得联系
     *
     * @param view
     */
    public void attachView(V view) {
        createModel();
        viewRef = new WeakReference<>(view);
    }

    /**
     * 获得界面的引用
     *
     * @return
     */
    protected V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    /**
     * 判断界面是否销毁，接口返回设置数据必须调用此方法判断界面是否还存在
     *
     * @return
     */
    protected boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    /**
     * 界面销毁,presenter 与界面断开联系
     */
    protected void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    /**
     * 获取对应的 model
     */
    public abstract void createModel();
}
