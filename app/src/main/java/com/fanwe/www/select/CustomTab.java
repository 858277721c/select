package com.fanwe.www.select;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.fanwe.library.select.view.SDSelectView;

/**
 * Created by Administrator on 2017/9/6.
 */
public class CustomTab extends SDSelectView
{
    public CustomTab(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    private TextView tv_title;
    private View view_underline;

    private void init()
    {
        setContentView(R.layout.view_custom_tab);
        tv_title = (TextView) findViewById(R.id.tv_title);
        view_underline = findViewById(R.id.view_underline);

        configText(tv_title) // 获得对应的config，也可以在外部调用
                .setTextColor(Color.parseColor("#616161"), Color.parseColor("#f57c00"))
                .setTextSize(40, 60)
                .setAlpha(0.2f, 1.0f)
                .setSelected(false); //设置默认未选中

        config(view_underline) // 获得对应的config，也可以在外部调用
                .setBackgroundColor(null, Color.parseColor("#f57c00"))
                .setVisibility(View.INVISIBLE, View.VISIBLE)
                .setSelected(false); //设置默认未选中

        config(this) // 获得对应的config，也可以在外部调用
                .setWidth(150, 300)
                .setSelected(false); //设置默认未选中

        config(this).setHeight(100, 100)
                .setHeight(null, null);

        config(this).setAlpha(1f, 1f);
    }
}
