package com.xy.mvprxdemo.base.mvp;

import io.reactivex.Observable;

/**
 * Created by 邢燕 on 2019/8/7 19:58.
 * Email:lucky_xyic@sina.cn
 * ToDo:
 */
public interface IBaseView extends IMvpBaseView {
    void showToastMsg(String msg);

    /**
     * Observable绑定生命周期
     * @param observable
     * @return
     */
//    void autoDispose(Observable observable);
}
