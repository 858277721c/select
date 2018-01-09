package com.fanwe.lib.select.view.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.fanwe.lib.select.R;
import com.fanwe.lib.select.view.FSelectView;

public class FTabMenu extends FSelectView
{
    public FTabMenu(Context context)
    {
        super(context);
        init();
    }

    public FTabMenu(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public FTabMenu(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ImageView iv_image;
    public TextView tv_text;

    protected void init()
    {
        setContentView(R.layout.lib_view_tab_menu);
        iv_image = findViewById(R.id.iv_image);
        tv_text = findViewById(R.id.tv_text);
    }
}
