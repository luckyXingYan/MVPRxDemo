package com.xy.mvprxdemo.base.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

/************************************************************
 *  @author     : zhouwenhao@yingu.com Hale
 *  @date       : 2018/9/4
 *  description : 
 ************************************************************/
public class CommonUtils {

    private static Application sApplication;

    public static void init(@NonNull final Application app) {
        if (sApplication == null) {
            sApplication = app;
        }
    }


    public static Application getApp() {
        if (sApplication != null) return sApplication;
        try {
            @SuppressLint("PrivateApi")
            Class<?> activityThread = Class.forName("android.app.ActivityThread");
            Object at = activityThread.getMethod("currentActivityThread").invoke(null);
            Object app = activityThread.getMethod("getApplication").invoke(at);
            if (app == null) {
                throw new NullPointerException("u should init first");
            }
            init((Application) app);
            return sApplication;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new NullPointerException("u should init first");
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static boolean isEmpty(CharSequence... strs) {
        if (strs == null || strs.length == 0) return true;
        int count = 0;
        for (CharSequence s : strs) {
            if (isEmpty(s)) count++;
        }
        return count != 0;
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null;
    }
}
