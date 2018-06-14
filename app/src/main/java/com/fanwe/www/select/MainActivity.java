package com.fanwe.www.select;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fanwe.lib.select.config.FViewSelectConfig;
import com.fanwe.lib.select.config.SelectConfig;
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

        FViewSelectConfig.config(mCustomTab).init(mTabIniter);
        FViewSelectConfig.config(mCustomTab.view_underline).init(mTabUnderlineIniter);
        FViewSelectConfig.config(mCustomTab.tv_title).init(mTabTextIniter);

        mCustomTab.setSelected(false);
    }

    private final SelectConfig.PropertiesIniter<ViewProperties> mTabIniter = new SelectConfig.PropertiesIniter<ViewProperties>()
    {
        @Override
        public void init(ViewProperties normal, ViewProperties selected)
        {
            normal.setWidth(150).setHeight(300);
            selected.setWidth(300);
        }
    };

    private final SelectConfig.PropertiesIniter<ViewProperties> mTabUnderlineIniter = new SelectConfig.PropertiesIniter<ViewProperties>()
    {
        @Override
        public void init(ViewProperties normal, ViewProperties selected)
        {
            normal.setVisibility(View.INVISIBLE);
            selected.setVisibility(View.VISIBLE)
                    .setBackgroundColor(Color.parseColor("#f57c00"));
        }
    };

    private final SelectConfig.PropertiesIniter<TextViewProperties> mTabTextIniter = new SelectConfig.PropertiesIniter<TextViewProperties>()
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
    };

    public void onClickBtnChangeState(View view)
    {
        mCustomTab.setSelected(!mCustomTab.isSelected());//切换View的选中状态
    }
}
