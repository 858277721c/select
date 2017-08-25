package com.fanwe.library.select.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

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


    public SDSelectViewConfig(Context context)
    {
        mContext = context.getApplicationContext();
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
}
