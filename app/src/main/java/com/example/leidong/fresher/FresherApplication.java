package com.example.leidong.fresher;

import android.app.Application;
import android.content.Context;

/**
 * Created by Lei Dong on 2018/9/24.
 */
public class FresherApplication extends Application {
    private static FresherApplication instance;
    private static Context context;

    public void onCreate() {
        super.onCreate();
        instance = this;
        context = (FresherApplication) getApplicationContext();
    }

    /**
     * @return
     */
    public static FresherApplication getInstance() {
        if (instance == null) {
            synchronized (FresherApplication.class) {
                if (instance == null) {
                    instance = new FresherApplication();
                }
            }
        }
        return instance;
    }

    /**
     * 获取当前的Context
     *
     * @return
     */
    public static Context getContext() {
        return context;
    }
}
