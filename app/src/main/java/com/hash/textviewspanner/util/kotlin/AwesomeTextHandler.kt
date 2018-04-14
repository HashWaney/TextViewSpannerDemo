package com.hash.textviewspanner.util.kotlin

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.widget.TextView

import java.util.HashMap
import java.util.regex.Pattern

/**
 * create by hashWaney on 2018/4/14
 */
class AwesomeTextHandler {

    private var view: TextView? = null

    private var context: Context? = null

    private val renderers: MutableMap<String, ViewSpanRenderer>?

    interface ViewSpanRenderer {
        fun getWhat(context: Context?, text: String, params: Any?): Any

        fun setSpan(spannableString: Spannable, what: Any, start: Int, end: Int, params: Any?)
    }


    init {
        renderers = HashMap()
    }

    fun addViewSpanRenderer(pattern: String, viewSpanRenderer: ViewSpanRenderer): AwesomeTextHandler {
        renderers!!.put(pattern, viewSpanRenderer)
        return this
    }

    fun setView(view: TextView) {
        this.view = view
        this.context = view.context
        applyRenderers()
    }

    private fun applyRenderers() {
        try {
            if (renderers != null) {
                val spannableString = SpannableString(view!!.text)
                val rexps = renderers.keys
                for (rexpKey in rexps) {
                    if ("" != rexpKey) {
                        val pattern = Pattern.compile(rexpKey, Pattern.CASE_INSENSITIVE)
                        val matcher = pattern.matcher(view!!.text)
                        while (matcher.find()) {
                            val end = matcher.end()
                            val start = matcher.start()
                            val text = matcher.group(0)
                            val renderer = renderers[rexpKey]
                            val what = renderer!!.getWhat(context, text, view!!)
                            renderer.setSpan(spannableString, what, start, end, null)
                        }
                    }
                }
                view!!.text = spannableString
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
