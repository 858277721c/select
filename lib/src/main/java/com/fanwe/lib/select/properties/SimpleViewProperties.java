package com.fanwe.lib.select.properties;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.fanwe.lib.select.invoker.AlphaInvoker;
import com.fanwe.lib.select.invoker.BackgroundDrawableInvoker;
import com.fanwe.lib.select.invoker.HeightInvoker;
import com.fanwe.lib.select.invoker.VisibilityInvoker;
import com.fanwe.lib.select.invoker.WidthInvoker;

class SimpleViewProperties implements ViewProperties
{
    private Float mAlpha;
    private Drawable mBackgroundDrawable;
    private Integer mVisibility;
    private Integer mWidth;
    private Integer mHeight;

    @Override
    public ViewProperties setAlpha(Float value)
    {
        mAlpha = value;
        return this;
    }

    @Override
    public ViewProperties setBackgroundDrawable(Drawable value)
    {
        mBackgroundDrawable = value;
        return this;
    }

    @Override
    public ViewProperties setVisibility(Integer value)
    {
        mVisibility = value;
        return this;
    }

    @Override
    public ViewProperties setWidth(Integer value)
    {
        mWidth = value;
        return this;
    }

    @Override
    public ViewProperties setHeight(Integer value)
    {
        mHeight = value;
        return this;
    }

    @Override
    public ViewProperties reset()
    {
        mAlpha = null;
        mBackgroundDrawable = null;
        mVisibility = null;
        mWidth = null;
        mHeight = null;
        return this;
    }

    @Override
    public void invoke(View view)
    {
        if (view != null)
        {
            new AlphaInvoker().invoke(view, mAlpha);
            new BackgroundDrawableInvoker().invoke(view, mBackgroundDrawable);
            new VisibilityInvoker().invoke(view, mVisibility);
            new WidthInvoker().invoke(view, mWidth);
            new HeightInvoker().invoke(view, mHeight);
        }
    }

    @Override
    public ViewProperties clone()
    {
        try
        {
            return (ViewProperties) super.clone();
        } catch (CloneNotSupportedException e)
        {
        }
        return null;
    }
}
