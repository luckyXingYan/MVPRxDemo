package com.xy.mvprxdemo.base.model;

import com.xy.mvprxdemo.base.bean.ResultBean;
import com.xy.mvprxdemo.base.http.callback.HttpGsonObserver;
import com.xy.mvprxdemo.base.http.netcore.api.ApiService;
import com.xy.mvprxdemo.base.http.netcore.core.NetEngine;

import io.reactivex.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author: xingyan
 * @Date: 2019/8/9
 * @Desc:
 */
public class BaseModel {

    protected ApiService apiService;
    private HttpGsonObserver mObserver;

    public BaseModel() {
        apiService = NetEngine.getServerApi();
    }

    protected <T> void invoke(Observable<ResultBean<T>> observable, HttpGsonObserver<T> observer) {
        //绑定Activity的生命周期
//        observer.autoDispose(observable);
        mObserver = observer;
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mObserver);
    }

    public void cancel() {
        if (mObserver != null) {
            mObserver.cancel();
        }

    }
}
