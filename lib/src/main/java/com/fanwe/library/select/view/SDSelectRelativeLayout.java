package com.fanwe.library.select.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class SDSelectRelativeLayout extends RelativeLayout
{
    public SDSelectRelativeLayout(Context context)
    {
        super(context);
        init();
    }

    public SDSelectRelativeLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public SDSelectRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private SDSelectViewHelper mSelectViewHelper = new SDSelectViewHelper();

    private void init()
    {
        mSelectViewHelper.config(this);
    }

    /**
     * 把View加入状态更新列表，并返回该View对应的Config
     *
     * @param view
     * @return
     */
    public SDSelectViewConfig config(View view)
    {
        int index = indexOfChild(view);
        if (index < 0)
        {
            throw new IllegalArgumentException("view must be child of parent:" + this);
        }
        return mSelectViewHelper.config(view);
    }

    @Override
    public void setSelected(final boolean selected)
    {
        mSelectViewHelper.setSelected(selected);
        super.setSelected(selected);
    }

    @Override
    public void onViewAdded(View child)
    {
        super.onViewAdded(child);
        mSelectViewHelper.config(child);
    }

    @Override
    public void onViewRemoved(View child)
    {
        super.onViewRemoved(child);
        mSelectViewHelper.remove(child);
    }
}
