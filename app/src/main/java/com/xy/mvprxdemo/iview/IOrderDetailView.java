package com.xy.mvprxdemo.iview;

import com.xy.mvprxdemo.base.mvp.IBaseView;
import com.xy.mvprxdemo.bean.OrderDetailBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/8/9
 * @Desc:
 */
public interface IOrderDetailView extends IBaseView {
    void setOrderDetailData(List<OrderDetailBean> data);
}
