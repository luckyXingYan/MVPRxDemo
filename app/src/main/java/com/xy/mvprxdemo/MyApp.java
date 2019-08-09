package com.xy.mvprxdemo;

import android.app.Application;
import android.content.Context;

import com.xy.mvprxdemo.base.http.netcore.core.NetConfig;
import com.xy.mvprxdemo.base.http.netcore.core.NetEngine;

/**
 * Created by 邢燕 on 2019/8/7 19:56.
 * Email:lucky_xyic@sina.cn
 * ToDo:
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化网络框架
        NetEngine.init(NetConfig.create(this));
    }

}
