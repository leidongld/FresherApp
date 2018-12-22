package com.example.leidong.fresher.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Lei Dong on 2018/12/22.
 */
public class FontUtils {
    /**
     * 更换字体
     */
    public static Typeface changeFont(Context context, String fontPath) {
        try {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontPath);
            return typeface;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
