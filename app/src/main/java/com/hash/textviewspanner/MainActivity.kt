package com.hash.textviewspanner

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        val intent = Intent()
        if (v!!.id == R.id.javaJump) {
            intent.setClass(this, JavaMainAct::class.java)
            startActivity(intent)
        } else if (v!!.id == R.id.ktJump) {
            intent.setClass(this, KotlinAct::class.java)
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val moneySpannableString = SpannerConvertUtilForJava.getMoneySpannableString(this, "Hello I am a Money Label Spanner", "9.3")
//        findViewById<TextView>(R.id.tvSpanner).setText(moneySpannableString);
        findViewById<Button>(R.id.ktJump).setOnClickListener(this)
        findViewById<Button>(R.id.javaJump).setOnClickListener(this)
    }

}
