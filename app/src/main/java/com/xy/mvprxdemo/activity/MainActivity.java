package com.xy.mvprxdemo.activity;

import android.os.Bundle;
import android.util.Log;

import com.xy.mvprxdemo.R;
import com.xy.mvprxdemo.base.mvp.BaseActivity;
import com.xy.mvprxdemo.bean.OrderDetailBean;
import com.xy.mvprxdemo.iview.IOrderDetailView;
import com.xy.mvprxdemo.presenter.OrderDetailPresenter;

import java.util.List;

public class MainActivity extends BaseActivity<OrderDetailPresenter> implements IOrderDetailView {


    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        presenter.getData("0", "1", this);
    }

    @Override
    protected OrderDetailPresenter createPresenter() {
        return new OrderDetailPresenter();
    }

    @Override
    public void setOrderDetailData(List<OrderDetailBean> data) {

        Log.e("-----setOrderDetailData", data.toString());

    }
}
