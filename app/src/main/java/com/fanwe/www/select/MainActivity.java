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
                .setTextColorNormal(Color.parseColor("#616161"))
                .setTextColorSelected(Color.parseColor("#f57c00"))
                .setTextSizeNormal(40)
                .setTextSizeSelected(60)
                .setAlphaNormal(0.2f)
                .setAlphaSelected(1.0f)
                .setSelected(false); //设置默认未选中

        mCustomTab.config(mCustomTab.view_underline) // 获得对应的config
                .setBackgroundColorSelected(Color.parseColor("#f57c00"))
                .setVisibilityNormal(View.INVISIBLE)
                .setVisibilitySelected(View.VISIBLE)
                .setSelected(false); //设置默认未选中

        mCustomTab.config(mCustomTab) // 获得对应的config
                .setWidthNormal(150)
                .setWidthSelected(300)
                .setHeightNormal(300)
                .setSelected(false); //设置默认未选中
    }

    public void onClickBtnChangeState(View view)
    {
        mCustomTab.setSelected(!mCustomTab.isSelected());//切换View的选中状态
    }
}
