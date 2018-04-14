package com.hash.textviewspanner.util.java;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HashWaney on 2017/6/7.
 */
public class AwesomeTextHandlerForJava {

    public interface ViewSpanRenderer {
        Object getWhat(final Context context, final String text, Object params);

        void setSpan(Spannable spannableString, Object what, int start, int end, Object params);
    }


    private TextView view;

    private Context context;

    private Map<String, ViewSpanRenderer> renderers;

    public AwesomeTextHandlerForJava() {
        renderers = new HashMap<>();
    }

    public AwesomeTextHandlerForJava addViewSpanRenderer(String pattern, ViewSpanRenderer viewSpanRenderer) {
        renderers.put(pattern, viewSpanRenderer);
        return this;
    }

    public void setView(TextView view) {
        this.view = view;
        this.context = view.getContext();
        applyRenderers();
    }

    private void applyRenderers() {
        try {
            if (renderers != null) {
                SpannableString spannableString = new SpannableString(view.getText());
                Set<String> rexps = renderers.keySet();
                for (String rexpKey : rexps) {
                    if (!"".equals(rexpKey)) {
                        Pattern pattern = Pattern.compile(rexpKey, Pattern.CASE_INSENSITIVE);
                        Matcher matcher = pattern.matcher(view.getText());
                        while (matcher.find()) {
                            int end = matcher.end();
                            int start = matcher.start();
                            String text = matcher.group(0);
                            ViewSpanRenderer renderer = renderers.get(rexpKey);
                            Object what = renderer.getWhat(context, text, view);
                            renderer.setSpan(spannableString, what, start, end, null);
                        }
                    }
                }
                view.setText(spannableString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
