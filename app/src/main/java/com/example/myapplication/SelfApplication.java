package com.example.myapplication;

import android.app.Application;

/**
 * @author jeason
 * @time 21-3-6 下午5:41
 * @description 该类的作用是：
 */
public class SelfApplication extends Application {

    private static Application mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static Application getApplication() {
        return mApplication;
    }
}
