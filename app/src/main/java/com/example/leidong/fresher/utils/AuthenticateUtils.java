package com.example.leidong.fresher.utils;

import android.text.TextUtils;

/**
 * Created by Lei Dong on 2018/11/11.
 */
public class AuthenticateUtils {
    private static final String LOW_ALPHEBETS = "abcdefghijklmnopqrstuvwxyz";
    private static final String HIGH_ALPHEBETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()_+=-`<>?:{},./;'[]'|";

    /**
     * 判断注册时输入是否合法
     *
     * @param username
     * @param password1
     * @param password2
     * @return
     */
    public static boolean registerInputLegal(String username, String password1, String password2) {
        if (TextUtils.isEmpty(username)) {// 用户名不能为空
            return false;
        } else if (TextUtils.isEmpty(password1)) {//密码不能为空
            return false;
        } else if (TextUtils.isEmpty(password2)) {//确认密码不能为空
            return false;
        } else if (!password1.equals(password2)) {//两次输入密码必须一致
            return false;
        } else if (password1.length() < 8) {//密码不能小于8位
            return false;
        } else if (!isPasswordStrong(password1)) {//密码必须强壮
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断密码是否强壮
     *
     * @param password
     * @return
     */
    private static boolean isPasswordStrong(String password) {
        boolean haveHighAlphebet = false;
        boolean haveLowAlphebet = false;
        boolean haveNumber = false;
        boolean haveSymbol = false;

        for (int i = 0; i < password.length(); i++) {
            if (LOW_ALPHEBETS.contains(password.charAt(i) + "") && !haveLowAlphebet) {
                haveLowAlphebet = true;
            }
            if (HIGH_ALPHEBETS.contains(password.charAt(i) + "") && !haveHighAlphebet) {
                haveHighAlphebet = true;
            }
            if (NUMBERS.contains(password.charAt(i) + "") && !haveNumber) {
                haveNumber = true;
            }
            if (SYMBOLS.contains(password.charAt(i) + "") && !haveSymbol) {
                haveSymbol = true;
            }

            if (haveHighAlphebet && haveLowAlphebet && haveNumber && haveSymbol) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断登录时输入是否合法
     *
     * @param username
     * @param password1
     * @return
     */
    public static boolean loginInputLegal(String username, String password1) {
        if (TextUtils.isEmpty(username)) {// 用户名不能为空
            return false;
        } else if (TextUtils.isEmpty(password1)) {//密码不能为空
            return false;
        } else {
            return true;
        }
    }
}
