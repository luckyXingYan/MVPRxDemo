package com.xy.mvprxdemo.bean;

/**
 * @Author: xingyan
 * @Date: 2019/8/9
 * @Desc:
 */
public class OrderDetailBean {
    public String title;
    public String collect_count;
    public String original_title;

    @Override
    public String toString() {
        return "HomeDataBean{" +
                "title=" + title +
                ", collect_count=" + collect_count +
                ", original_title=" + original_title +
                '}';
    }
}
