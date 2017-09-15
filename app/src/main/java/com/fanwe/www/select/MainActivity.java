package com.fanwe.www.select;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    private CustomTab mCustomTab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomTab = (CustomTab) findViewById(R.id.view_tab);

        mCustomTab.configText(mCustomTab.tv_title) // 获得对应的config
                .setTextColor(Color.parseColor("#616161"), Color.parseColor("#f57c00")) //正常和选中颜色
                .setTextSize(40, 60) //正常和选中字体大小
                .setAlpha(0.2f, 1.0f) //正常和选中透明度
                .setSelected(false); //设置默认未选中

        mCustomTab.config(mCustomTab.view_underline) // 获得对应的config
                .setBackgroundColor(null, Color.parseColor("#f57c00")) //正常和选中背景
                .setVisibility(View.INVISIBLE, View.VISIBLE) //正常和选中可见状态
                .setSelected(false); //设置默认未选中

        mCustomTab.config(mCustomTab) // 获得对应的config
                .setWidth(150, 300) //正常和选中宽度
                .setHeight(300, null) //正常和选中高度，null表示不处理该状态
                .setSelected(false); //设置默认未选中
    }

    public void onClickBtnChangeState(View view)
    {
        mCustomTab.setSelected(!mCustomTab.isSelected());//切换View的选中状态
    }
}
