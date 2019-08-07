package com.xy.mvprxdemo.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 邢燕 on 2019/8/7 19:57.
 * Email:lucky_xyic@sina.cn
 * ToDo:
 */
public abstract class MvpBaseActivity<P extends MvpBasePresenter> extends AppCompatActivity implements IMvpBaseView {
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    protected abstract P createPresenter();
}
