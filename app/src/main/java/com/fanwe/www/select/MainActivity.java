package com.fanwe.www.select;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    private CustomTabView view_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_tab = (CustomTabView) findViewById(R.id.view_tab);


        view_tab.getViewConfig(view_tab.tv_title)
                .setTextColorNormal(Color.parseColor("#616161")) //未选中字体颜色
                .setTextColorSelected(Color.parseColor("#f57c00")) //选中字体颜色
                .setTextSizeNormal(30) //未选中字体大小
                .setTextSizeSelected(60) //选中字体大小
                .setAlphaNormal(0.5f) //未选中透明度
                .setAlphaSelected(1.0f); //选中透明度

        view_tab.getViewConfig(view_tab.view_underline)
                .setBackgroundColorNormal(Color.parseColor("#616161")) //未选中背景颜色
                .setBackgroundColorSelected(Color.parseColor("#f57c00")) //选中背景颜色
                .setHeightNormal(10)  //未选中高度
                .setHeightSelected(30); //选中高度

        view_tab.setSelected(false); //设置初始化状态为未选中
    }

    public void onClickBtnChangeState(View view)
    {
        view_tab.setSelected(!view_tab.isSelected());
    }
}
