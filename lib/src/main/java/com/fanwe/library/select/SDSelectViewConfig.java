/*
 * Copyright (C) 2017 zhengjun, fanwe (http://www.fanwe.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fanwe.library.select;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * SDSelectView的参数配置
 */
public class SDSelectViewConfig implements Cloneable
{
    public static final int EMPTY_VALUE = -Integer.MAX_VALUE;

    private Context mContext;

    //----------textColor----------
    private int textColorNormal = EMPTY_VALUE;
    private int textColorSelected = EMPTY_VALUE;
    private int textColorResIdNormal;
    private int textColorResIdSelected;

    //----------textSize----------
    private int textSizeNormal = EMPTY_VALUE;
    private int textSizeSelected = EMPTY_VALUE;

    //----------image resId----------
    private int imageResIdNormal = EMPTY_VALUE;
    private int imageResIdSelected = EMPTY_VALUE;

    //----------background----------
    private Drawable backgroundNormal;
    private Drawable backgroundSelected;

    private int backgroundResIdNormal;
    private int backgroundResIdSelected;

    private int backgroundColorNormal;
    private int backgroundColorSelected;
    private int backgroundColorResIdNormal;
    private int backgroundColorResIdSelected;

    //----------alpha----------
    private float alphaNormal = EMPTY_VALUE;
    private float alphaSelected = EMPTY_VALUE;

    //----------width----------
    private int widthNormal = EMPTY_VALUE;
    private int widthSelected = EMPTY_VALUE;

    //----------height----------
    private int heightNormal = EMPTY_VALUE;
    private int heightSelected = EMPTY_VALUE;

    //----------visibility----------
    private int visibilityNormal = EMPTY_VALUE;
    private int visibilitySelected = EMPTY_VALUE;

    SDSelectViewConfig(View view)
    {
        mContext = view.getContext().getApplicationContext();
        setView(view);
    }

    // ----------------------setter getter

    public int getTextColorNormal()
    {
        return textColorNormal;
    }

    public SDSelectViewConfig setTextColorNormal(int textColorNormal)
    {
        this.textColorNormal = textColorNormal;
        return this;
    }

    public int getTextColorSelected()
    {
        return textColorSelected;
    }

    public SDSelectViewConfig setTextColorSelected(int textColorSelected)
    {
        this.textColorSelected = textColorSelected;
        return this;
    }

    public int getTextColorResIdNormal()
    {
        return textColorResIdNormal;
    }

    //
    public SDSelectViewConfig setTextColorResIdNormal(int textColorResIdNormal)
    {
        this.textColorResIdNormal = textColorResIdNormal;
        this.textColorNormal = mContext.getResources().getColor(textColorResIdNormal);
        return this;
    }

    public int getTextColorResIdSelected()
    {
        return textColorResIdSelected;
    }

    //
    public SDSelectViewConfig setTextColorResIdSelected(int textColorResIdSelected)
    {
        this.textColorResIdSelected = textColorResIdSelected;
        this.textColorSelected = mContext.getResources().getColor(textColorResIdSelected);
        return this;
    }

    public int getTextSizeNormal()
    {
        return textSizeNormal;
    }

    public SDSelectViewConfig setTextSizeNormal(int textSizeNormal)
    {
        this.textSizeNormal = textSizeNormal;
        return this;
    }

    public int getTextSizeSelected()
    {
        return textSizeSelected;
    }

    public SDSelectViewConfig setTextSizeSelected(int textSizeSelected)
    {
        this.textSizeSelected = textSizeSelected;
        return this;
    }

    public int getImageResIdNormal()
    {
        return imageResIdNormal;
    }

    public SDSelectViewConfig setImageResIdNormal(int imageResIdNormal)
    {
        this.imageResIdNormal = imageResIdNormal;
        return this;
    }

    public int getImageResIdSelected()
    {
        return imageResIdSelected;
    }

    public SDSelectViewConfig setImageResIdSelected(int imageResIdSelected)
    {
        this.imageResIdSelected = imageResIdSelected;
        return this;
    }

    public Drawable getBackgroundNormal()
    {
        return backgroundNormal;
    }

    public SDSelectViewConfig setBackgroundNormal(Drawable backgroundNormal)
    {
        this.backgroundNormal = backgroundNormal;
        return this;
    }

    public Drawable getBackgroundSelected()
    {
        return backgroundSelected;
    }

    public SDSelectViewConfig setBackgroundSelected(Drawable backgroundSelected)
    {
        this.backgroundSelected = backgroundSelected;
        return this;
    }

    public int getBackgroundResIdNormal()
    {
        return backgroundResIdNormal;
    }

    //
    public SDSelectViewConfig setBackgroundResIdNormal(int backgroundResIdNormal)
    {
        this.backgroundResIdNormal = backgroundResIdNormal;
        this.backgroundNormal = mContext.getResources().getDrawable(backgroundResIdNormal);
        return this;
    }

    public int getBackgroundResIdSelected()
    {
        return backgroundResIdSelected;
    }

    //
    public SDSelectViewConfig setBackgroundResIdSelected(int backgroundResIdSelected)
    {
        this.backgroundResIdSelected = backgroundResIdSelected;
        this.backgroundSelected = mContext.getResources().getDrawable(backgroundResIdSelected);
        return this;
    }

    public int getBackgroundColorNormal()
    {
        return backgroundColorNormal;
    }

    //
    public SDSelectViewConfig setBackgroundColorNormal(int backgroundColorNormal)
    {
        this.backgroundColorNormal = backgroundColorNormal;
        this.backgroundNormal = new ColorDrawable(backgroundColorNormal);
        return this;
    }

    public int getBackgroundColorResIdNormal()
    {
        return backgroundColorResIdNormal;
    }

    //
    public SDSelectViewConfig setBackgroundColorResIdNormal(int backgroundColorResIdNormal)
    {
        this.backgroundColorResIdNormal = backgroundColorResIdNormal;
        this.backgroundNormal = new ColorDrawable(mContext.getResources().getColor(backgroundColorResIdNormal));
        return this;
    }

    public int getBackgroundColorSelected()
    {
        return backgroundColorSelected;
    }

    //
    public SDSelectViewConfig setBackgroundColorSelected(int backgroundColorSelected)
    {
        this.backgroundColorSelected = backgroundColorSelected;
        this.backgroundSelected = new ColorDrawable(backgroundColorSelected);
        return this;
    }

    public int getBackgroundColorResIdSelected()
    {
        return backgroundColorResIdSelected;
    }

    public SDSelectViewConfig setBackgroundColorResIdSelected(int backgroundColorResIdSelected)
    {
        this.backgroundColorResIdSelected = backgroundColorResIdSelected;
        this.backgroundSelected = new ColorDrawable(mContext.getResources().getColor(backgroundColorResIdSelected));
        return this;
    }

    public float getAlphaNormal()
    {
        return alphaNormal;
    }

    public SDSelectViewConfig setAlphaNormal(float alphaNormal)
    {
        this.alphaNormal = alphaNormal;
        return this;
    }

    public float getAlphaSelected()
    {
        return alphaSelected;
    }

    public SDSelectViewConfig setAlphaSelected(float alphaSelected)
    {
        this.alphaSelected = alphaSelected;
        return this;
    }

    public int getWidthNormal()
    {
        return widthNormal;
    }

    public SDSelectViewConfig setWidthNormal(int widthNormal)
    {
        this.widthNormal = widthNormal;
        return this;
    }

    public int getWidthSelected()
    {
        return widthSelected;
    }

    public SDSelectViewConfig setWidthSelected(int widthSelected)
    {
        this.widthSelected = widthSelected;
        return this;
    }

    public int getHeightNormal()
    {
        return heightNormal;
    }

    public SDSelectViewConfig setHeightNormal(int heightNormal)
    {
        this.heightNormal = heightNormal;
        return this;
    }

    public int getHeightSelected()
    {
        return heightSelected;
    }

    public SDSelectViewConfig setHeightSelected(int heightSelected)
    {
        this.heightSelected = heightSelected;
        return this;
    }

    public int getVisibilityNormal()
    {
        return visibilityNormal;
    }

    public SDSelectViewConfig setVisibilityNormal(int visibilityNormal)
    {
        this.visibilityNormal = visibilityNormal;
        return this;
    }

    public int getVisibilitySelected()
    {
        return visibilitySelected;
    }

    public SDSelectViewConfig setVisibilitySelected(int visibilitySelected)
    {
        this.visibilitySelected = visibilitySelected;
        return this;
    }

    @Override
    public SDSelectViewConfig clone()
    {
        try
        {
            return (SDSelectViewConfig) super.clone();
        } catch (Exception e)
        {
            return null;
        }
    }

    //==================== select logic start ====================

    private WeakReference<View> mView;
    private boolean mInvokeViewSelected = true;

    /**
     * 调用setSelected的时候是否也触发View的setSelected方法，默认true
     *
     * @param invokeViewSelected
     * @return
     */
    public SDSelectViewConfig setInvokeViewSelected(boolean invokeViewSelected)
    {
        mInvokeViewSelected = invokeViewSelected;
        return this;
    }

    private View getView()
    {
        if (mView != null)
        {
            return mView.get();
        } else
        {
            return null;
        }
    }

    public void setView(View view)
    {
        final View oldView = getView();
        if (oldView != view)
        {
            if (view != null)
            {
                mView = new WeakReference<>(view);
            } else
            {
                mView = null;
            }
        }
    }

    /**
     * 设置View是否选中
     *
     * @param selected
     */
    public void setSelected(boolean selected)
    {
        final View view = getView();
        if (view == null)
        {
            return;
        }

        updateViewState(view, selected);

        if (mInvokeViewSelected)
        {
            view.setSelected(selected);
        }
    }

    //----------update method start----------

    private void updateViewState(View view, boolean selected)
    {
        if (view instanceof TextView)
        {
            TextView tv = (TextView) view;

            updateTextView_textColor(tv, selected);
            updateTextView_textSize(tv, selected);
        } else if (view instanceof ImageView)
        {
            ImageView iv = (ImageView) view;

            updateImageView_imageResource(iv, selected);
        }

        updateView_alpha(view, selected);
        updateView_background(view, selected);
        updateView_size(view, selected);
        updateView_visibility(view, selected);
    }

    /**
     * 更新ImageView的图片
     *
     * @param view
     * @param selected
     */
    private void updateImageView_imageResource(ImageView view, boolean selected)
    {
        int value = 0;
        if (selected)
        {
            value = getImageResIdSelected();
        } else
        {
            value = getImageResIdNormal();
        }

        if (value != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setImageResource(value);
        }
    }

    /**
     * 更新TextView的字体颜色
     *
     * @param view
     * @param selected
     */
    private void updateTextView_textColor(TextView view, boolean selected)
    {
        int value = 0;
        if (selected)
        {
            value = getTextColorSelected();
        } else
        {
            value = getTextColorNormal();
        }

        if (value != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setTextColor(value);
        }
    }

    /**
     * 更新TextView的字体大小
     *
     * @param view
     * @param selected
     */
    private void updateTextView_textSize(TextView view, boolean selected)
    {
        int value = 0;
        if (selected)
        {
            value = getTextSizeSelected();
        } else
        {
            value = getTextSizeNormal();
        }

        if (value != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setTextSize(TypedValue.COMPLEX_UNIT_PX, value);
        }
    }

    /**
     * 更新View的透明度
     *
     * @param view
     * @param selected
     */
    private void updateView_alpha(View view, boolean selected)
    {
        float value = 0;
        if (selected)
        {
            value = getAlphaSelected();
        } else
        {
            value = getAlphaNormal();
        }

        if (value != SDSelectViewConfig.EMPTY_VALUE)
        {
            view.setAlpha(value);
        }
    }

    /**
     * 更新View的背景
     *
     * @param view
     * @param selected
     */
    private void updateView_background(View view, boolean selected)
    {
        Drawable value = null;
        if (selected)
        {
            value = getBackgroundSelected();
        } else
        {
            value = getBackgroundNormal();
        }

        if (value != null)
        {
            setBackgroundDrawable(view, value);
        }
    }

    /**
     * 更新View的大小
     *
     * @param view
     * @param selected
     */
    private void updateView_size(View view, boolean selected)
    {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params == null)
        {
            return;
        }

        int width = 0;
        if (selected)
        {
            width = getWidthSelected();
        } else
        {
            width = getWidthNormal();
        }

        int height = 0;
        if (selected)
        {
            height = getHeightSelected();
        } else
        {
            height = getHeightNormal();
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
     * 更新View的可见状态
     *
     * @param view
     * @param selected
     */
    private void updateView_visibility(View view, boolean selected)
    {
        int value = 0;
        if (selected)
        {
            value = getVisibilitySelected();
        } else
        {
            value = getVisibilityNormal();
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

    //==================== select logic end ====================
}
