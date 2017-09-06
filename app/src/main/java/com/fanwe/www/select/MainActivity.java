package com.fanwe.www.select;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnChangeState(View view)
    {
        View view_tab = findViewById(R.id.view_tab);
        view_tab.setSelected(!view_tab.isSelected());//切换View的选中状态
    }
}
