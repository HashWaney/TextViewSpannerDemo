package com.hash.textviewspanner.util.kotlin

import android.content.Context

/**
 * Created by HashWaney on 2018/4/14.
 */

object PixUtil {
    /**
     * dp转px.
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    fun dip2px(context: Context, value: Float): Int {
        val dpi = context.resources.displayMetrics.densityDpi
        return (value * (dpi / 160)).toInt()
    }

    /**
     * px转dp.
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    fun px2dip(context: Context, value: Float): Int {
        val dpi = context.resources.displayMetrics.densityDpi
        return (value * 160 / dpi).toInt()
    }

}
