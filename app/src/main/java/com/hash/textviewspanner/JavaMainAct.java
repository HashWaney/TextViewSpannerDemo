package com.hash.textviewspanner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.widget.TextView;

import com.hash.textviewspanner.util.java.SpannerConvertUtilForJava;

/**
 * Created by HashWaney on 2018/4/14.
 */

public class JavaMainAct extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        TextView tvSpanner = (TextView) findViewById(R.id.tvSpanner);
        SpannableString buySpanableString = SpannerConvertUtilForJava.getBuySpanableString(this, "I have already buy this video");
        tvSpanner.setText(buySpanableString);

    }
}
