package com.example.leidong.fresher;

import android.app.Application;

/**
 * Created by Lei Dong on 2018/9/24.
 */
public class FresherApplication extends Application {
    private static FresherApplication instance;

    public void onCreate() {
        super.onCreate();
        instance = (FresherApplication) getApplicationContext();
    }

    public static FresherApplication getInstance() {
        if(instance == null) {
            synchronized (FresherApplication.class) {
                if(instance == null) {
                    instance = new FresherApplication();
                }
            }
        }
        return instance;
    }
}
