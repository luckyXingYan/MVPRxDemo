package com.xy.mvprxdemo.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xy.mvprxdemo.base.util.AppManager;
import com.xy.mvprxdemo.base.util.ToastUtil;

/**
 * Created by 邢燕 on 2019/8/7 19:57.
 * Email:lucky_xyic@sina.cn
 * ToDo:
 */
public abstract class BaseActivity<P extends BasePresenter> extends MvpBaseActivity<P> implements IBaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        setContentView(layoutId());
        initView(savedInstanceState);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().removeActivity(this);
        if (presenter != null) {
            presenter.cancelNetWork();
        }
    }

    @Override
    public void showToastMsg(String msg) {
        ToastUtil.showToastShort(this, msg);
    }

    protected abstract int layoutId();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initData();
}
