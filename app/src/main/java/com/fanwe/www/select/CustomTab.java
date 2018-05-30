package com.fanwe.www.select;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.fanwe.lib.select.view.FSelectView;

/**
 * Created by Administrator on 2017/9/6.
 */
public class CustomTab extends FSelectView
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
        setContentView(R.layout.view_custom_tab);
        tv_title = findViewById(R.id.tv_title);
        view_underline = findViewById(R.id.view_underline);
    }
}
