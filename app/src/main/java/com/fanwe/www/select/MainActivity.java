package com.fanwe.www.select;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.fanwe.library.select.view.SDSelectViewHandler;

public class MainActivity extends AppCompatActivity
{
    private TextView mTvTitle;
    private View mViewUnderline;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mViewUnderline = findViewById(R.id.view_underline);

        SDSelectViewHandler.config(mTvTitle) // 返回tv_title对应的配置config
                .setTextColorNormal(Color.parseColor("#616161")) // 正常字体颜色
                .setTextColorSelected(Color.parseColor("#f57c00")) // 选中字体颜色
                .setTextSizeNormal(40) // 正常字体大小
                .setTextSizeSelected(60) // 选中字体大小
                .setAlphaNormal(0.2f) // 正常透明度
                .setAlphaSelected(1.0f) // 选中透明度
                .setSelected(false); //设置默认未选中

        SDSelectViewHandler.config(mViewUnderline) // 获得view_underline对应的配置config
                .setBackgroundColorSelected(Color.parseColor("#f57c00")) // 选中背景颜色
                .setVisibilityNormal(View.INVISIBLE) // 正常可见状态
                .setVisibilitySelected(View.VISIBLE) // 选中可见状态
                .setSelected(false); //设置默认未选中
    }

    public void onClickBtnChangeState(View view)
    {
        SDSelectViewHandler.setSelected(mTvTitle, !mTvTitle.isSelected());
        SDSelectViewHandler.setSelected(mViewUnderline, !mViewUnderline.isSelected());
    }
}
