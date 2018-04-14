package com.hash.textviewspanner.util.java;

import android.content.Context;

public class PixelUtilForJava {
    /**
     * dp转px.
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    public static int dip2px(Context context, float value) {
        int dpi = context.getResources().getDisplayMetrics().densityDpi;
        return (int) (value * (dpi / 160));
    }

    /**
     * px转dp.
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    public static int px2dip(Context context, float value) {
        int dpi = context.getResources().getDisplayMetrics().densityDpi;
        return (int) ((value * 160) / dpi);
    }
}
