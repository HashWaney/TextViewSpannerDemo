package com.hash.textviewspanner.util.spanner

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.nfc.Tag
import android.text.Spannable
import android.text.style.ImageSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast

import com.hash.textviewspanner.R
import com.hash.textviewspanner.util.AwesomeTextHandler
import com.hash.textviewspanner.util.BitmapUtils
import com.hash.textviewspanner.util.PixUtil

/**
 * Created by HashWaney on 2018/4/14.
 */

class MoenySpannerLabel : AwesomeTextHandler.ViewSpanRenderer{


    fun getView(context: Context?, text: String): View {
        val textView = LayoutInflater.from(context).inflate(R.layout.layout_textview_drawable_left, null) as TextView
        textView.setBackgroundResource(R.drawable.bg_pay)
        textView.setTextColor(Color.parseColor("#FFFFFF"))
        textView.text = text.substring(1, text.length - 1)
        textView.textSize = PixUtil.dip2px(context!!, 11f).toFloat()
        return textView
    }

    override fun getWhat(context: Context?, text: String, params: Any?): Any {
        val view = getView(context, text)
        val bitmpaDrawable = BitmapUtils.convertViewToDrawable(view) as BitmapDrawable
        bitmpaDrawable.setBounds(0, 0, bitmpaDrawable.intrinsicWidth, bitmpaDrawable.intrinsicHeight)
        return ImageSpan(bitmpaDrawable)
    }

    override fun setSpan(spannableString: Spannable, what: Any, start: Int, end: Int, params: Any?) {
        if (spannableString != null && what != null) {
            spannableString.setSpan(what, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }


}
