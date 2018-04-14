package com.hash.textviewspanner.util

import android.content.Context
import android.text.SpannableString
import android.text.TextUtils
import com.hash.textviewspanner.util.spanner.MoenySpannerLabel

import java.util.HashMap
import java.util.regex.Pattern

/**
 * Created by HashWaney on 2018/4/14.
 */

object SpannerConvertUtil {
    // TODO: 2018/4/14  正则匹配表达式 截取 # 与 %号之间的内容；
    val PATTERN = "(?=(#))[.\\s\\S]*?(?<=(" + "%" + "))"

    /**
     * 获取金钱标签
     *
     * @param context
     * @param title
     * @return
     */
    fun getMoneySpannableString(context: Context, title: String, price: String): SpannableString {
        val hashMap = HashMap<String, AwesomeTextHandler.ViewSpanRenderer>()
        var titles = ""
        if (java.lang.Double.parseDouble(price) >= 0.1) {
            titles = "# " + String.format("¥%s", price) + " %" + "  " + title + " " + "# " + String.format("¥%s", 6) + " %" +" just for fun";
            hashMap.put(PATTERN, MoenySpannerLabel())
        } else {
            titles = title
        }
        return convertStringToSpanableString(context, titles, hashMap)
    }

    /**
     * 将字符串转换成图片,
     *
     * @param context
     * @param textTag
     * @return
     */
    private fun convertStringToSpanableString(context: Context,
                                              textTag: String,
                                              renders: HashMap<String, AwesomeTextHandler.ViewSpanRenderer>): SpannableString {
        val spannableString = SpannableString(textTag)
        val rexps = renders.keys
        for (rexpKey in rexps) {
            if (!TextUtils.isEmpty(rexpKey)) {
                val pattern = Pattern.compile(rexpKey, Pattern.CASE_INSENSITIVE)
                val matcher = pattern.matcher(textTag)
                while (matcher.find()) {
                    val end = matcher.end()
                    val start = matcher.start()
                    val text = matcher.group(0)
                    val renderer = renders[rexpKey]
                    val what = renderer?.getWhat(context, text, null)
                    if (renderer != null) {
                        renderer.setSpan(spannableString, what!!, start, end, null)
                    }
                }
            }
        }
        return spannableString
    }

}
