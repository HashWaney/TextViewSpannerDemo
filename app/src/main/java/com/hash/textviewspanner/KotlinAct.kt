package com.hash.textviewspanner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.view.View
import android.widget.TextView

import com.hash.textviewspanner.util.kotlin.SpannerConvertUtil

/**
 * Created by HashWaney on 2018/4/14.
 */

class KotlinAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        val tvSpanner = findViewById<View>(R.id.tvSpannerKotlin) as TextView
        val moneySpannableString = SpannerConvertUtil
                .getMoneySpannableString(this, "Hello I am a MoneyLabel Spanner", "8.9")
        tvSpanner.text = moneySpannableString


    }
}
