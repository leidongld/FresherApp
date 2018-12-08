package com.example.leidong.fresher.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.leidong.fresher.FresherApplication;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lei Dong on 2018/12/8.
 */
public class SPToolkit {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private SPToolkit() {
        if (null == sharedPreferences) {
            sharedPreferences = FresherApplication.getInstance().getSharedPreferences("fresher", Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
    }

    /**
     * 获取SPTookit
     *
     * @return
     */
    public static SPToolkit init() {
        return new SPToolkit();
    }

    /**
     * 存储String类型数据
     *
     * @param key
     * @param value
     */
    public static void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 获取String类型数据
     *
     * @param key
     * @return
     */
    public static String gainString(String key) {
        return sharedPreferences.getString(key, "");
    }

    /**
     * 存储int类型数据
     *
     * @param key
     * @param value
     */
    public static void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * 获取int类型数据
     *
     * @param key
     * @return
     */
    public static int gainInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    /**
     * 存储long类型数据
     *
     * @param key
     * @param value
     */
    public static void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * 获取long类型数据
     *
     * @param key
     * @return
     */
    public static long gainLong(String key) {
        return sharedPreferences.getLong(key, 0L);
    }

    /**
     * 存储boolean类型数据
     *
     * @param key
     * @param value
     */
    public static void putBool(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * 获取boolean类型数据
     *
     * @param key
     * @return
     */
    public static boolean gainBool(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    /**
     * 存储float类型数据
     *
     * @param key
     * @param value
     */
    public static void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    /**
     * 获取float类型数据
     *
     * @param key
     * @return
     */
    public static float gainFloat(String key) {
        return sharedPreferences.getFloat(key, 0F);
    }

    /**
     * 存储Set<String>类型数据
     *
     * @param key
     * @param value
     */
    public static void putStringSet(String key, HashSet<String> value) {
        editor.putStringSet(key, value);
        editor.commit();
    }

    /**
     * 获取Set<String>类型数据
     *
     * @param key
     * @return
     */
    public static Set<String> gainStringSet(String key) {
        return sharedPreferences.getStringSet(key, new HashSet<String>());
    }
}
