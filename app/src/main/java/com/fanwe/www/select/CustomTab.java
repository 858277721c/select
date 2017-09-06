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

        config(tv_title) // 获得对应的config，也可以在外部调用
                .setTextColorNormal(Color.parseColor("#616161")) // 正常字体颜色
                .setTextColorSelected(Color.parseColor("#f57c00")) // 选中字体颜色
                .setTextSizeNormal(40) // 正常字体大小
                .setTextSizeSelected(60) // 选中字体大小
                .setAlphaNormal(0.2f) // 正常透明度
                .setAlphaSelected(1.0f) // 选中透明度
                .setSelected(false); //设置默认未选中

        config(view_underline) // 获得对应的config，也可以在外部调用
                .setBackgroundColorSelected(Color.parseColor("#f57c00")) // 选中背景颜色
                .setVisibilityNormal(View.INVISIBLE) // 正常可见状态
                .setVisibilitySelected(View.VISIBLE) // 选中可见状态
                .setSelected(false); //设置默认未选中

        config(this) // 获得对应的config，也可以在外部调用
                .setWidthNormal(150) //正常宽度
                .setWidthSelected(300) //选中宽度
                .setSelected(false); //设置默认未选中
    }
}
