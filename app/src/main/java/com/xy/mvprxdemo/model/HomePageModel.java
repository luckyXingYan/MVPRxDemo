package com.xy.mvprxdemo.model;

import com.xy.mvprxdemo.base.http.callback.HttpGsonObserver;
import com.xy.mvprxdemo.base.model.BaseModel;
import com.xy.mvprxdemo.bean.OrderDetailBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/8/9
 * @Desc:
 */
public class HomePageModel extends BaseModel {
    public void getOrderDetail(String start, String count, HttpGsonObserver<List<OrderDetailBean>> callback) {
        invoke(apiService.getOrderDetail(start, count), callback);
    }
}
