package com.xy.mvprxdemo.base.http.callback;

import android.util.Log;

import com.xy.mvprxdemo.base.bean.ResultBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/************************************************************
 *  @author     : zhouwenhao@yingu.com Hale
 *  @date       : 2018/10/25
 *  description :
 ************************************************************/
public abstract class BaseGsonObserver<T> implements Observer<ResultBean<T>> {


    @Override
    public void onNext(ResultBean<T> tResultBean) {
        dealResponseSuccess(tResultBean);
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
        Log.e("gson,接口调用失败:", t.getMessage());
        dealResponseFailed(t);
    }

    @Override
    public void onSubscribe(Disposable d) {
        disposable(d);
    }

    @Override
    public void onComplete() {
        onCompleted();
    }

    private void dealResponseSuccess(ResultBean<T> model) {
        int state = model.getCode();
        switch (state) {
            case ResultBean.STATE_SUCCESS:
                T data = model.getData();
                onSuccess(data);
                break;
            case ResultBean.STATE_FAILURE:
//                ResultBean.ErrorObject error = model.getErrorObj();
//                if (error != null) {
//                    int errorCode = error.getCode();
//                    String errorMsg = error.getMsg();
//                    if (errorCode == ErrorCode.STOP_TAKING_CODE) {
////                        EventBus.getDefault().post(new StopTakingMsgData(errorMsg));
//                    } else if (errorCode == ErrorCode.DEVICE_LOGIN_LIMIT) {
////                        EventBus.getDefault().post(new DeviceLoginLimitExpiredData(errorMsg));
//                    } else {
//                        onBizFailed(errorCode, errorMsg);
//                    }
//                } else {
                onBizFailed(-10, "服务器返回错误");
//                }
                break;
            default:
                onBizFailed(-10, "网络请求失败");
        }

    }

    private void dealResponseFailed(Throwable t) {
        if (t instanceof HttpException) {
            HttpException httpException = (HttpException) t;
            int code = httpException.code();
            Log.i("LOG_HTTP", "[BaseGsonObserver] 接口返回错误 code=" + code);

            switch (code) {
                case 401:  //Cookie过期
                    onCookieExpired();
                    break;
                case 403://停服通知
                    onStopService("");
                    break;
                case 543:
//                EventBus.getDefault().post(new DeviceLoginLimitExpiredData(""));
                    break;
                default: //网络连接异常
                    onConnectionFailed();
                    break;
            }

//            if (code >= 400 && code < 500) {
//                LogUtils.e("请求错误");
//            } else if (code >= 500) {
//                LogUtils.e("服务器错误");
//            }
        }
    }

    public abstract void onSuccess(T data);

    public abstract void onCompleted();

    public abstract void disposable(Disposable d);

    public abstract void onBizFailed(int code, String errorMsg);

    public abstract void onCookieExpired();

    public abstract void onStopService(String msg);

    public abstract void onConnectionFailed();

    //自动绑定生命周期
    public abstract void autoDispose(Observable observable);

}
