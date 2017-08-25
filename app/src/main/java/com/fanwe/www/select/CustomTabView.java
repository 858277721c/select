package com.fanwe.www.select;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fanwe.library.select.view.SDSelectViewAuto;

/**
 * Created by Administrator on 2017/8/25.
 */
public class CustomTabView extends SDSelectViewAuto
{
    public TextView tv_title;
    public View view_underline;

    public CustomTabView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_custom_tab, this, true);
        tv_title = (TextView) findViewById(R.id.tv_title);
        view_underline = findViewById(R.id.view_underline);

        addAutoView(tv_title, view_underline); //设置根据选中状态变化的view
    }
}
