package com.fanwe.library.select;

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
    private OnSelectedStateChangeCallback mOnSelectedStateChangeCallback;
    private OnSelectedPercentChangeCallback mOnSelectedPercentChangeCallback;

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
     * 设置状态回调
     *
     * @param onSelectedStateChangeCallback
     */
    public void setOnSelectedStateChangeCallback(OnSelectedStateChangeCallback onSelectedStateChangeCallback)
    {
        this.mOnSelectedStateChangeCallback = onSelectedStateChangeCallback;
    }

    public void setOnSelectedPercentChangeCallback(OnSelectedPercentChangeCallback onSelectedPercentChangeCallback)
    {
        mOnSelectedPercentChangeCallback = onSelectedPercentChangeCallback;
    }

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

    // util method
    protected SDSelectView normalImageView_image(ImageView view)
    {
        int resId = getViewConfig(view).getImageNormalResId();
        if (resId != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setImageResource(resId);
        }
        return this;
    }

    protected SDSelectView selectImageView_image(ImageView view)
    {
        int resId = getViewConfig(view).getImageSelectedResId();
        if (resId != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setImageResource(resId);
        }
        return this;
    }

    protected SDSelectView normalTextView_textColor(TextView view)
    {
        int color = getViewConfig(view).getTextColorNormal();
        if (color != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setTextColor(color);
        }
        return this;
    }

    protected SDSelectView selectTextView_textColor(TextView view)
    {
        int color = getViewConfig(view).getTextColorSelected();
        if (color != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setTextColor(color);
        }
        return this;
    }

    protected SDSelectView normalTextView_textSize(TextView view)
    {
        int size = getViewConfig(view).getTextSizeNormal();
        if (size != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        }
        return this;
    }

    protected SDSelectView selectTextView_textSize(TextView view)
    {
        int size = getViewConfig(view).getTextSizeSelected();
        if (size != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        }
        return this;
    }

    protected SDSelectView normalView_alpha(View view)
    {
        float alpha = getViewConfig(view).getAlphaNormal();
        if (alpha != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setAlpha(alpha);
        }
        return this;
    }

    protected SDSelectView selectView_alpha(View view)
    {
        float alpha = getViewConfig(view).getAlphaSelected();
        if (alpha != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setAlpha(alpha);
        }
        return this;
    }

    protected SDSelectView normalView_background(View view)
    {
        Drawable drawable = getViewConfig(view).getBackgroundNormal();
        if (drawable != null)
        {
            setBackgroundDrawable(view, drawable);
        }
        return this;
    }

    protected SDSelectView selectView_background(View view)
    {
        Drawable drawable = getViewConfig(view).getBackgroundSelected();
        if (drawable != null)
        {
            setBackgroundDrawable(view, drawable);
        }
        return this;
    }

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
    public final void setSelected(boolean selected)
    {
        super.setSelected(selected);

        updateViewState(true);
    }

    @Override
    public final void setSelectedPercent(boolean selected, float percent, Direction direction)
    {
        onSelectedPercentChanged(selected, percent, direction);
        if (mOnSelectedPercentChangeCallback != null)
        {
            mOnSelectedPercentChangeCallback.onSelectedPercentChanged(selected, percent, direction, this);
        }
    }

    @Override
    public final void updateViewState(boolean notifyCallback)
    {
        final boolean isSelected = isSelected();

        onSelectedStateChanged(isSelected);
        if (notifyCallback)
        {
            if (mOnSelectedStateChangeCallback != null)
            {
                mOnSelectedStateChangeCallback.onSelectedStateChanged(isSelected, this);
            }
        }
    }

    protected abstract void onSelectedStateChanged(boolean selected);

    protected void onSelectedPercentChanged(boolean selected, float percent, Direction direction)
    {

    }
}
