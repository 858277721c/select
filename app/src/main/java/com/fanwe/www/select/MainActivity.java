package com.fanwe.www.select;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fanwe.lib.select.ViewSelectConfig;
import com.fanwe.lib.select.properties.TextViewProperties;
import com.fanwe.lib.select.properties.ViewProperties;

public class MainActivity extends AppCompatActivity
{
    private CustomTab mCustomTab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomTab = findViewById(R.id.view_tab);

        mCustomTab.config(mCustomTab.tv_title).configTextView(new ViewSelectConfig.PropertiesIniter<TextViewProperties>()
        {
            @Override
            public void init(TextViewProperties normal, TextViewProperties selected)
            {
                normal.setTextColor(Color.parseColor("#616161"))
                        .setTextSize(40)
                        .setAlpha(0.2f);

                selected.setTextColor(Color.parseColor("#f57c00"))
                        .setTextSize(60)
                        .setAlpha(1.0f);
            }
        });
        mCustomTab.config(mCustomTab.view_underline).configView(new ViewSelectConfig.PropertiesIniter<ViewProperties>()
        {
            @Override
            public void init(ViewProperties normal, ViewProperties selected)
            {
                normal.setVisibility(View.INVISIBLE);

                selected.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f57c00")))
                        .setVisibility(View.VISIBLE);
            }
        });
        mCustomTab.config(mCustomTab).configView(new ViewSelectConfig.PropertiesIniter<ViewProperties>()
        {
            @Override
            public void init(ViewProperties normal, ViewProperties selected)
            {
                normal.setWidth(150).setHeight(300);

                selected.setWidth(300);
            }
        });

        mCustomTab.setSelected(false);
    }

    public void onClickBtnChangeState(View view)
    {
        mCustomTab.setSelected(!mCustomTab.isSelected());//切换View的选中状态
    }
}
