package com.sd.lib.select.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.sd.lib.select.SelectConfig;
import com.sd.lib.select.container.FSelectViewContainer;
import com.sd.lib.select.container.SelectViewContainer;

public class FSelectView extends FrameLayout implements SelectViewContainer
{
    public FSelectView(Context context)
    {
        super(context);
        init();
    }

    public FSelectView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public FSelectView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private final SelectViewContainer mSelectViewContainer = new FSelectViewContainer();

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
    public void setInvokeViewSelected(boolean invokeViewSelected)
    {
        mSelectViewContainer.setInvokeViewSelected(invokeViewSelected);
    }

    @Override
    public SelectConfig config(View view)
    {
        checkView(view);
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
        mSelectViewContainer.setSelected(selected);
        super.setSelected(selected);
    }

    private void checkView(View view)
    {
        if (view == null)
            return;

        boolean isChild = false;
        while (true)
        {
            if (view == null)
                break;
            if (view == this)
            {
                isChild = true;
                break;
            }

            view = (View) view.getParent();
        }

        if (!isChild)
            throw new IllegalArgumentException("view is not child of current ViewGroup");
    }
}
