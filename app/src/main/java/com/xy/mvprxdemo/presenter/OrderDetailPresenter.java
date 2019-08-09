package com.xy.mvprxdemo.presenter;

import android.content.Context;

import com.xy.mvprxdemo.base.http.callback.HttpGsonObserver;
import com.xy.mvprxdemo.base.mvp.BasePresenter;
import com.xy.mvprxdemo.bean.OrderDetailBean;
import com.xy.mvprxdemo.iview.IOrderDetailView;
import com.xy.mvprxdemo.model.HomePageModel;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/8/9
 * @Desc:
 */
public class OrderDetailPresenter extends BasePresenter<IOrderDetailView> {
    private HomePageModel model;

    public void getData(String start, String count, Context context) {
        model.getOrderDetail(start, count, new HttpGsonObserver<List<OrderDetailBean>>(context) {
            @Override
            public void onSuccess(List<OrderDetailBean> data) {
                if (isViewAttached()) {
                    getView().setOrderDetailData(data);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @Override
    public void createModel() {
        model = new HomePageModel();
    }

    @Override
    public void cancelNetWork() {
        model.cancel();
    }
}
