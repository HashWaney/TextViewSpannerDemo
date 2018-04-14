package com.hash.textviewspanner.util.kotlin

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.View

/**
 * Created by HashWaney on 2018/4/14.
 */

object BitmapUtils {

    private val UPPER_LEFT_X = 0
    private val UPPER_LEFT_Y = 0
    /**
     * 将View转换为Drawable对象
     *
     * @param view
     * @return
     */
    fun convertViewToDrawable(view: View): Drawable {
        val spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        view.measure(spec, spec)
        view.layout(UPPER_LEFT_X, UPPER_LEFT_Y, view.measuredWidth, view.measuredHeight)
        val b = Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val c = Canvas(b)
        c.translate((-view.scrollX).toFloat(), (-view.scrollY).toFloat())
        view.draw(c)
        view.isDrawingCacheEnabled = true
        val cacheBmp = view.drawingCache
        val viewBmp = cacheBmp.copy(Bitmap.Config.ARGB_8888, true)
        view.destroyDrawingCache()
        return BitmapDrawable(viewBmp)
    }

}
