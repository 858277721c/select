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
        view_tab.getViewConfig(view_tab.tv_title) //获得tv_title对应的配置config
                .setTextColorNormal(Color.parseColor("#616161")) //正常字体颜色
                .setTextColorSelected(Color.parseColor("#f57c00")) //选中字体颜色

                .setTextSizeNormal(40) //正常字体大小
                .setTextSizeSelected(60) //选中字体大小

                .setAlphaNormal(0.2f) //正常透明度
                .setAlphaSelected(1.0f); //选中透明度

        view_tab.getViewConfig(view_tab.view_underline) //获得view_underline对应的配置config
                .setBackgroundColorSelected(Color.parseColor("#f57c00")) //选中背景颜色

                .setVisibilityNormal(View.INVISIBLE) //正常可见状态
                .setVisibilitySelected(View.VISIBLE); //选中可见状态

        view_tab.setSelected(false); //设置为未选中
    }

    public void onClickBtnChangeState(View view)
    {
        view_tab.setSelected(!view_tab.isSelected());
    }
}
