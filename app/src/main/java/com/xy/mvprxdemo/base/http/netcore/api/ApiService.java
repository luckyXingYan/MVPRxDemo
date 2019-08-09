package com.xy.mvprxdemo.base.http.netcore.api;

import com.xy.mvprxdemo.base.bean.ResultBean;
import com.xy.mvprxdemo.bean.OrderDetailBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * <br>包名：com.netcore
 * <br>项目名称：JR
 * <br>描述：服务器api
 * <br>创建人：BaoZhi
 * <br>创建时间：2016/8/16 0016 16:10
 */
public interface ApiService {

    // 获取首页红包状态
    //#https://douban.uieee.com/v2/movie/top250?start=0&count=10即可。
//    @FormUrlEncoded
//    @POST(ApiRoute.PRODUCT.GET_HOMEPAGE_REDPACKETS_STATUS)
//    Call<ResultBean<List<HomeDataBean>>> getHomePageData(@Field(ApiKeys.START) String start, @Field(ApiKeys.COUNT) String count);

    @FormUrlEncoded
    @POST(ApiRoute.ORDER.GET_ORDER_DETAIL)
    Observable<ResultBean<List<OrderDetailBean>>> getOrderDetail(@Field(ApiKeys.START) String start, @Field(ApiKeys.COUNT) String count);
}