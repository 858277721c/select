package com.fanwe.library.select.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Map;
import java.util.WeakHashMap;

public abstract class SDSelectView extends LinearLayout implements ISDSelectView
{
    private Map<View, SDSelectViewConfig> mMapViewConfig = new WeakHashMap<>();
    private OnSelectedChangeCallback mOnSelectedChangeCallback;

    public SDSelectView(Context context)
    {
        super(context);
        baseInit();
    }

    public SDSelectView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        baseInit();
    }

    public SDSelectView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        baseInit();
    }

    private void baseInit()
    {
        onBaseInit();
    }

    /**
     * 基类构造方法调用的初始化方法<br>
     * 如果子类在此方法内访问子类定义属性时候直接new的属性，如：private String value = "value"，则value的值将为null
     */
    protected void onBaseInit()
    {

    }

    /**
     * 设置布局
     *
     * @param resId
     */
    public void setContentView(int resId)
    {
        removeAllViews();
        mMapViewConfig.clear();
        LayoutInflater.from(getContext()).inflate(resId, this, true);
    }

    /**
     * 设置布局
     *
     * @param view
     */
    public void setContentView(View view)
    {
        removeAllViews();
        mMapViewConfig.clear();
        addView(view);
    }

    /**
     * 设置布局
     *
     * @param view
     * @param params
     */
    public void setContentView(View view, ViewGroup.LayoutParams params)
    {
        removeAllViews();
        mMapViewConfig.clear();
        addView(view, params);
    }

    @Override
    public void setOnSelectedChangeCallback(OnSelectedChangeCallback onSelectedChangeCallback)
    {
        this.mOnSelectedChangeCallback = onSelectedChangeCallback;
    }

    /**
     * 返回View对应的Config
     *
     * @param view
     * @return
     */
    public SDSelectViewConfig getViewConfig(View view)
    {
        if (view == null)
        {
            return null;
        }
        SDSelectViewConfig config = mMapViewConfig.get(view);
        if (config == null)
        {
            config = new SDSelectViewConfig(getContext());
            mMapViewConfig.put(view, config);
        }
        return config;
    }

    //----------update method start----------

    /**
     * 根据选中状态更新ImageView的图片
     *
     * @param selected
     * @param view
     */
    protected void updateImageView_imageResource(boolean selected, ImageView view)
    {
        int value = 0;
        if (selected)
        {
            value = getViewConfig(view).getImageResIdSelected();
        } else
        {
            value = getViewConfig(view).getImageResIdNormal();
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
    protected void updateTextView_textColor(boolean selected, TextView view)
    {
        int value = 0;
        if (selected)
        {
            value = getViewConfig(view).getTextColorSelected();
        } else
        {
            value = getViewConfig(view).getTextColorNormal();
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
    protected void updateTextView_textSize(boolean selected, TextView view)
    {
        int value = 0;
        if (selected)
        {
            value = getViewConfig(view).getTextSizeSelected();
        } else
        {
            value = getViewConfig(view).getTextSizeNormal();
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
    protected void updateView_alpha(boolean selected, View view)
    {
        float value = 0;
        if (selected)
        {
            value = getViewConfig(view).getAlphaSelected();
        } else
        {
            value = getViewConfig(view).getAlphaNormal();
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
    protected void updateView_background(boolean selected, View view)
    {
        Drawable value = null;
        if (selected)
        {
            value = getViewConfig(view).getBackgroundSelected();
        } else
        {
            value = getViewConfig(view).getBackgroundNormal();
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
    protected void updateView_size(boolean selected, View view)
    {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params == null)
        {
            return;
        }

        int width = 0;
        if (selected)
        {
            width = getViewConfig(view).getWidthSelected();
        } else
        {
            width = getViewConfig(view).getWidthNormal();
        }

        int height = 0;
        if (selected)
        {
            height = getViewConfig(view).getHeightSelected();
        } else
        {
            height = getViewConfig(view).getHeightNormal();
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
    protected void updateView_visibility(boolean selected, View view)
    {
        int value = 0;
        if (selected)
        {
            value = getViewConfig(view).getVisibilitySelected();
        } else
        {
            value = getViewConfig(view).getVisibilityNormal();
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

    @Override
    public final void setSelected(boolean selected)
    {
        super.setSelected(selected);

        updateViewState(true);
    }

    @Override
    public final void updateViewState(boolean notifyCallback)
    {
        final boolean isSelected = isSelected();

        onSelectedChanged(isSelected);
        if (notifyCallback)
        {
            if (mOnSelectedChangeCallback != null)
            {
                mOnSelectedChangeCallback.onSelectedChanged(isSelected, this);
            }
        }
    }

    /**
     * 选中状态变化回调
     *
     * @param selected
     */
    public abstract void onSelectedChanged(boolean selected);
}
