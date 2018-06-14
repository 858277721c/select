package com.fanwe.www.select;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/6.
 */
public class CustomTab extends FrameLayout
{
    public CustomTab(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public TextView tv_title;
    public View view_underline;

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.view_custom_tab, this, true);
        tv_title = findViewById(R.id.tv_title);
        view_underline = findViewById(R.id.view_underline);
    }
}
