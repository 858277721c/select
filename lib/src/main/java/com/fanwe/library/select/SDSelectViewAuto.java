package com.fanwe.library.select;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;
import java.util.WeakHashMap;

public abstract class SDSelectViewAuto extends SDSelectView
{
    private Map<View, Integer> mMapViews = new WeakHashMap<>();

    public SDSelectViewAuto(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public SDSelectViewAuto(Context context)
    {
        super(context);
    }

    protected void addAutoView(View... views)
    {
        if (views == null)
        {
            return;
        }
        for (View item : views)
        {
            mMapViews.put(item, 0);
        }
    }

    protected void removeAutoView(View... views)
    {
        if (views == null)
        {
            return;
        }
        for (View item : views)
        {
            mMapViews.remove(item);
        }
    }

    @Override
    public void setContentView(int resId)
    {
        mMapViews.clear();
        super.setContentView(resId);
    }

    @Override
    public void setContentView(View view)
    {
        mMapViews.clear();
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view, android.view.ViewGroup.LayoutParams params)
    {
        mMapViews.clear();
        super.setContentView(view, params);
    }

    @Override
    public void onNormal()
    {
        if (!mMapViews.isEmpty())
        {
            for (Map.Entry<View, Integer> item : mMapViews.entrySet())
            {
                normalAutoView(item.getKey());
            }
        }
    }

    @Override
    public void onSelected()
    {
        if (!mMapViews.isEmpty())
        {
            for (Map.Entry<View, Integer> item : mMapViews.entrySet())
            {
                selectAutoView(item.getKey());
            }
        }
    }

    protected void normalAutoView(View view)
    {
        normalView_background(view);
        normalView_alpha(view);
        if (view instanceof TextView)
        {
            TextView tv = (TextView) view;
            normalTextView_textColor(tv);
            normalTextView_textSize(tv);
        } else if (view instanceof ImageView)
        {
            ImageView iv = (ImageView) view;
            normalImageView_image(iv);
        }
    }

    protected void selectAutoView(View view)
    {
        selectView_background(view);
        selectView_alpha(view);
        if (view instanceof TextView)
        {
            TextView tv = (TextView) view;
            selectTextView_textColor(tv);
            selectTextView_textSize(tv);
        } else if (view instanceof ImageView)
        {
            ImageView iv = (ImageView) view;
            selectImageView_image(iv);
        }
    }
}
