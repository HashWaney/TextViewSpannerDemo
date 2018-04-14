package com.hash.textviewspanner.util.spanner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.Spannable;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.hash.textviewspanner.R;
import com.hash.textviewspanner.util.java.AwesomeTextHandlerForJava;
import com.hash.textviewspanner.util.java.BitmapUtilsForJava;
import com.hash.textviewspanner.util.java.PixelUtilForJava;

/**
 * Created by HashWaney on 2018/4/14.
 */

public class BuySpanRender implements AwesomeTextHandlerForJava.ViewSpanRenderer{

    public View getView(Context context, String text) {
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.layout_textview_drawable_left, null);
        textView.setBackgroundResource(R.drawable.bg_free);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setText(text.substring(1, text.length() - 1));
        textView.setTextSize(PixelUtilForJava.dip2px(context, 11));
        return textView;
    }

    @Override
    public ImageSpan getWhat(Context context, String text, Object params) {
        View view = getView(context, text);
        BitmapDrawable bitmpaDrawable = (BitmapDrawable) BitmapUtilsForJava.convertViewToDrawable(view);
        bitmpaDrawable.setBounds(0, 0, bitmpaDrawable.getIntrinsicWidth(), bitmpaDrawable.getIntrinsicHeight());
        return new ImageSpan(bitmpaDrawable);
    }

    @Override
    public void setSpan(Spannable spannableString, Object what, int start, int end, Object params) {
        if (spannableString != null && what != null) {
            spannableString.setSpan(what, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }
}
