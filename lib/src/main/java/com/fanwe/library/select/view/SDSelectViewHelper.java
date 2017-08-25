package com.fanwe.library.select.view;

import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * View选中状态帮助类
 */
public class SDSelectViewHelper
{
    private Map<View, SDSelectViewConfig> mMapViewConfig = new WeakHashMap<>();

    /**
     * 设置是否选中
     *
     * @param selected true-选中，false-未选中
     */
    public void setSelected(boolean selected)
    {
        if (mMapViewConfig.isEmpty())
        {
            return;
        }

        Iterator<Map.Entry<View, SDSelectViewConfig>> it = mMapViewConfig.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<View, SDSelectViewConfig> item = it.next();
            View view = item.getKey();
            if (view != null)
            {
                updateViewState(selected, view);
            } else
            {
                it.remove();
            }
        }
    }

    /**
     * 把View加入状态更新列表，并返回该View对应的Config
     *
     * @param view
     * @return
     */
    public SDSelectViewConfig config(View view)
    {
        if (view == null)
        {
            return null;
        }
        SDSelectViewConfig config = mMapViewConfig.get(view);
        if (config == null)
        {
            config = new SDSelectViewConfig(view.getContext());
            mMapViewConfig.put(view, config);
        }
        return config;
    }

    /**
     * 把View从状态更新列表移除
     *
     * @param view
     */
    public void remove(View view)
    {
        if (view == null)
        {
            return;
        }
        mMapViewConfig.remove(view);
    }

    /**
     * 清空所有View，以及对应的Config
     */
    public void clear()
    {
        mMapViewConfig.clear();
    }

    //----------update method start----------

    private void updateViewState(boolean selected, View view)
    {
        if (view instanceof TextView)
        {
            TextView tv = (TextView) view;
            updateTextView_textColor(selected, tv);
            updateTextView_textSize(selected, tv);
        } else if (view instanceof ImageView)
        {
            ImageView iv = (ImageView) view;
            updateImageView_imageResource(selected, iv);
        }

        updateView_alpha(selected, view);
        updateView_background(selected, view);
        updateView_size(selected, view);
        updateView_visibility(selected, view);
    }

    /**
     * 根据选中状态更新ImageView的图片
     *
     * @param selected
     * @param view
     */
    public void updateImageView_imageResource(boolean selected, ImageView view)
    {
        int value = 0;
        if (selected)
        {
            value = config(view).getImageResIdSelected();
        } else
        {
            value = config(view).getImageResIdNormal();
        }

        if (value != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setImageResource(value);
        }
    }

    /**
     * 根据选中状态更新TextView的字体颜色
     *
     * @param selected
     * @param view
     */
    public void updateTextView_textColor(boolean selected, TextView view)
    {
        int value = 0;
        if (selected)
        {
            value = config(view).getTextColorSelected();
        } else
        {
            value = config(view).getTextColorNormal();
        }

        if (value != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setTextColor(value);
        }
    }

    /**
     * 根据选中状态更新TextView的字体大小
     *
     * @param selected
     * @param view
     */
    public void updateTextView_textSize(boolean selected, TextView view)
    {
        int value = 0;
        if (selected)
        {
            value = config(view).getTextSizeSelected();
        } else
        {
            value = config(view).getTextSizeNormal();
        }

        if (value != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setTextSize(TypedValue.COMPLEX_UNIT_PX, value);
        }
    }

    /**
     * 根据选中状态更新View的透明度
     *
     * @param selected
     * @param view
     */
    public void updateView_alpha(boolean selected, View view)
    {
        float value = 0;
        if (selected)
        {
            value = config(view).getAlphaSelected();
        } else
        {
            value = config(view).getAlphaNormal();
        }

        if (value != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setAlpha(value);
        }
    }

    /**
     * 根据选中状态更新View的背景
     *
     * @param selected
     * @param view
     */
    public void updateView_background(boolean selected, View view)
    {
        Drawable value = null;
        if (selected)
        {
            value = config(view).getBackgroundSelected();
        } else
        {
            value = config(view).getBackgroundNormal();
        }

        if (value != null)
        {
            setBackgroundDrawable(view, value);
        }
    }

    /**
     * 根据选中状态更新View的大小
     *
     * @param selected
     * @param view
     */
    public void updateView_size(boolean selected, View view)
    {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params == null)
        {
            return;
        }

        int width = 0;
        if (selected)
        {
            width = config(view).getWidthSelected();
        } else
        {
            width = config(view).getWidthNormal();
        }

        int height = 0;
        if (selected)
        {
            height = config(view).getHeightSelected();
        } else
        {
            height = config(view).getHeightNormal();
        }

        boolean needUpdate = false;

        if (width != SDSelectViewConfig.EMPTY_VALUE)
        {
            if (params.width != width)
            {
                params.width = width;
                needUpdate = true;
            }
        }

        if (height != SDSelectViewConfig.EMPTY_VALUE)
        {
            if (params.height != height)
            {
                params.height = height;
                needUpdate = true;
            }
        }

        if (needUpdate)
        {
            view.setLayoutParams(params);
        }
    }

    /**
     * 根据选中状态更新View的可见状态
     *
     * @param selected
     * @param view
     */
    public void updateView_visibility(boolean selected, View view)
    {
        int value = 0;
        if (selected)
        {
            value = config(view).getVisibilitySelected();
        } else
        {
            value = config(view).getVisibilityNormal();
        }

        if (value != SDSelectViewConfig.EMPTY_VALUE)
        {
            if (view.getVisibility() != value)
            {
                view.setVisibility(value);
            }
        }
    }

    //----------update method end----------

    private static void setBackgroundDrawable(View view, Drawable drawable)
    {
        if (view == null)
        {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundDrawable(drawable);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
