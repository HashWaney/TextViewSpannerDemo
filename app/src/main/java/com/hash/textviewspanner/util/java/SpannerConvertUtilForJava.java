package com.hash.textviewspanner.util.java;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;

import com.hash.textviewspanner.util.spanner.BuySpanRender;

import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HashWaney on 2018/4/14.
 */

public class SpannerConvertUtilForJava {

    /**
     * 正则表达式匹配
     */
    public static final String PATTERN = "(?=(#))[.\\s\\S]*?(?<=(" + "%" + "))";


    /**
     * 将字符串转换成图片,
     *
     * @param context
     * @param textTag
     * @return
     */
    private static SpannableString convertStringToSpanableString(Context context,
                                                                 String textTag,
                                                                 HashMap<String, AwesomeTextHandlerForJava.ViewSpanRenderer> renders) {
        SpannableString spannableString = new SpannableString(textTag);
        Set<String> rexps = renders.keySet();
        for (String rexpKey : rexps) {
            if (!TextUtils.isEmpty(rexpKey)) {
                Pattern pattern = Pattern.compile(rexpKey, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(textTag);
                while (matcher.find()) {
                    int end = matcher.end();
                    int start = matcher.start();
                    String text = matcher.group(0);
                    AwesomeTextHandlerForJava.ViewSpanRenderer renderer = renders.get(rexpKey);
                    Object what = renderer.getWhat(context, text, null);
                    renderer.setSpan(spannableString, what, start, end, null);
                }
            }
        }
        return spannableString;
    }
    /**
     * 获取已购的标签
     *
     * @param context
     * @param title
     * @return
     */
    public static SpannableString getBuySpanableString(Context context, String title) {
        String groupTitle = "# 已购 %" + "  " + title ;
        HashMap<String, AwesomeTextHandlerForJava.ViewSpanRenderer> hashMap = new HashMap<>();
        hashMap.put(PATTERN, new BuySpanRender());
        return convertStringToSpanableString(context, groupTitle, hashMap);
    }

}
