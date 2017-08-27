package com.fanwe.library.select.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.fanwe.library.select.ISDSelectViewContainer;
import com.fanwe.library.select.SDSelectViewConfig;
import com.fanwe.library.select.SDSelectViewContainer;

/**
 * Created by Administrator on 2017/8/27.
 */

public class SDSelectView extends FrameLayout implements ISDSelectViewContainer
{
    public SDSelectView(Context context)
    {
        super(context);
        init();
    }

    public SDSelectView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public SDSelectView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private SDSelectViewContainer mSelectViewContainer = new SDSelectViewContainer();

    private void init()
    {

    }

    public void setContentView(int layoutId)
    {
        clearConfig();
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(layoutId, this, true);
    }

    public void setContentView(View view)
    {
        clearConfig();
        removeAllViews();
        addView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams params)
    {
        clearConfig();
        removeAllViews();
        addView(view, params);
    }

    @Override
    public SDSelectViewConfig config(View view)
    {
        return mSelectViewContainer.config(view);
    }

    @Override
    public void removeConfig(View view)
    {
        mSelectViewContainer.removeConfig(view);
    }

    @Override
    public void clearConfig()
    {
        mSelectViewContainer.clearConfig();
    }

    @Override
    public void setSelected(boolean selected)
    {
        super.setSelected(selected);
        mSelectViewContainer.setSelected(selected);
    }
}
