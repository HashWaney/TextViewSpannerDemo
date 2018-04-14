package com.hash.textviewspanner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.hash.textviewspanner.util.SpannerConvertUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val moneySpannableString = SpannerConvertUtil.getMoneySpannableString(this, "Hello I am a Money Label Spanner", "9.3")
        findViewById<TextView>(R.id.tvSpanner).setText(moneySpannableString);

    }
}
