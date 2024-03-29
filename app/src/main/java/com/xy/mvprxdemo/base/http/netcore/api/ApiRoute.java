package com.xy.mvprxdemo.base.http.netcore.api;

/**
 * <br>包名：com.netcore.api
 * <br>项目名称：NetCore
 * <br>描述：服务器api访问路径定义
 * <br>创建人：BaoZhi
 * <br>创建时间：2016/8/19 0019 11:25
 */
public class ApiRoute {

    public final class INDEX {
        private static final String ROOT = "";
        public static final String JOIN_SMS_CODE = ROOT + "/v2/join/getsmscode";
    }

    public final class USER {
        private static final String ROOT = "/u";
        public static final String EXCHANGE_USER_COUPON = ROOT + "/exchangeUserCoupon";
    }

    public final class ORDER {
        //#https://douban.uieee.com/v2/movie/top250?start=0&count=10即可。
        private static final String ROOT = "/v2/movie";
        public static final String GET_ORDER_DETAIL = ROOT + "/top250";
    }

}