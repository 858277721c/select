package com.fanwe.library.select.view;

import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Administrator on 2017/8/26.
 */
public class SDSelectViewHandler extends SDSelectViewConfig
{
    private static Map<View, SDSelectViewHandler> sMapViewHandler = new WeakHashMap<>();
    private WeakReference<View> mView;
    /**
     * View的Selected状态发生变化的时候是否自动刷新View的展示状态，默认false
     */
    private boolean mIsAutoUpdate = false;
    private Boolean mIsSelected = false;

    SDSelectViewHandler(View view)
    {
        super(view.getContext());
        setView(view);
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

    private void setView(View view)
    {
        final View oldView = getView();
        if (oldView != view)
        {
            if (oldView != null)
            {
                oldView.getViewTreeObserver().removeOnPreDrawListener(mOnPreDrawListener);
            }

            if (view != null)
            {
                mView = new WeakReference<>(view);
                view.getViewTreeObserver().addOnPreDrawListener(mOnPreDrawListener);
            } else
            {
                mView = null;
            }
        }
    }

    /**
     * 设置View的Selected状态发生变化的时候是否自动刷新View的展示状态，默认false
     *
     * @param autoUpdate
     */
    public SDSelectViewHandler setAutoUpdate(boolean autoUpdate)
    {
        mIsAutoUpdate = autoUpdate;
        return this;
    }

    private ViewTreeObserver.OnPreDrawListener mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener()
    {
        @Override
        public boolean onPreDraw()
        {
            if (mIsAutoUpdate)
            {
                updateIfNeed();
            }
            return true;
        }
    };

    private void updateIfNeed()
    {
        final View view = getView();
        if (view == null)
        {
            return;
        }
        final boolean viewSelected = view.isSelected();
        if (mIsSelected == null || viewSelected != mIsSelected)
        {
            mIsSelected = viewSelected;

            updateViewState(viewSelected, view);
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
        mIsSelected = null;
        view.setSelected(selected);

        if (!mIsAutoUpdate)
        {
            updateIfNeed();
        }
    }

    /**
     * 设置View是否选中
     *
     * @param selected
     */
    public static void setSelected(View view, boolean selected)
    {
        if (view == null)
        {
            return;
        }

        final SDSelectViewHandler handler = sMapViewHandler.get(view);
        if (handler != null)
        {
            handler.setSelected(selected);
        } else
        {
            view.setSelected(selected);
        }
    }

    /**
     * 把View加入状态更新列表，并返回该View对应的处理对象
     *
     * @param view
     * @return
     */
    public static SDSelectViewHandler config(View view)
    {
        if (view == null)
        {
            return null;
        }
        SDSelectViewHandler handler = sMapViewHandler.get(view);
        if (handler == null)
        {
            handler = new SDSelectViewHandler(view);
            sMapViewHandler.put(view, handler);
        }
        return handler;
    }

    /**
     * 把View从状态更新列表移除
     *
     * @param view
     */
    public static void remove(View view)
    {
        if (view == null)
        {
            return;
        }
        final SDSelectViewHandler handler = sMapViewHandler.get(view);
        if (handler != null)
        {
            handler.setView(null);
        }
        sMapViewHandler.remove(view);
    }

    //----------update method start----------

    private static void updateViewState(boolean selected, View view)
    {
        if (view == null)
        {
            return;
        }
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
    private static void updateImageView_imageResource(ImageView view, boolean selected)
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
     * 更新TextView的字体颜色
     *
     * @param view
     * @param selected
     */
    private static void updateTextView_textColor(TextView view, boolean selected)
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
     * 更新TextView的字体大小
     *
     * @param view
     * @param selected
     */
    private static void updateTextView_textSize(TextView view, boolean selected)
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
     * 更新View的透明度
     *
     * @param view
     * @param selected
     */
    private static void updateView_alpha(View view, boolean selected)
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
     * 更新View的背景
     *
     * @param view
     * @param selected
     */
    private static void updateView_background(View view, boolean selected)
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
     * 更新View的大小
     *
     * @param view
     * @param selected
     */
    private static void updateView_size(View view, boolean selected)
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
     * 更新View的可见状态
     *
     * @param view
     * @param selected
     */
    private static void updateView_visibility(View view, boolean selected)
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

    //----------Override start----------
    @Override
    public SDSelectViewHandler setAlphaNormal(float alphaNormal)
    {
        super.setAlphaNormal(alphaNormal);
        return this;
    }

    @Override
    public SDSelectViewHandler setAlphaSelected(float alphaSelected)
    {
        super.setAlphaSelected(alphaSelected);
        return this;
    }

    @Override
    public SDSelectViewHandler setBackgroundColorNormal(int backgroundColorNormal)
    {
        super.setBackgroundColorNormal(backgroundColorNormal);
        return this;
    }

    @Override
    public SDSelectViewHandler setBackgroundColorResIdNormal(int backgroundColorResIdNormal)
    {
        super.setBackgroundColorResIdNormal(backgroundColorResIdNormal);
        return this;
    }

    @Override
    public SDSelectViewHandler setBackgroundColorResIdSelected(int backgroundColorResIdSelected)
    {
        super.setBackgroundColorResIdSelected(backgroundColorResIdSelected);
        return this;
    }

    @Override
    public SDSelectViewHandler setBackgroundColorSelected(int backgroundColorSelected)
    {
        super.setBackgroundColorSelected(backgroundColorSelected);
        return this;
    }

    @Override
    public SDSelectViewHandler setBackgroundNormal(Drawable backgroundNormal)
    {
        super.setBackgroundNormal(backgroundNormal);
        return this;
    }

    @Override
    public SDSelectViewHandler setBackgroundResIdNormal(int backgroundResIdNormal)
    {
        super.setBackgroundResIdNormal(backgroundResIdNormal);
        return this;
    }

    @Override
    public SDSelectViewHandler setBackgroundResIdSelected(int backgroundResIdSelected)
    {
        super.setBackgroundResIdSelected(backgroundResIdSelected);
        return this;
    }

    @Override
    public SDSelectViewHandler setBackgroundSelected(Drawable backgroundSelected)
    {
        super.setBackgroundSelected(backgroundSelected);
        return this;
    }

    @Override
    public SDSelectViewHandler setHeightNormal(int heightNormal)
    {
        super.setHeightNormal(heightNormal);
        return this;
    }

    @Override
    public SDSelectViewHandler setHeightSelected(int heightSelected)
    {
        super.setHeightSelected(heightSelected);
        return this;
    }

    @Override
    public SDSelectViewHandler setImageResIdNormal(int imageResIdNormal)
    {
        super.setImageResIdNormal(imageResIdNormal);
        return this;
    }

    @Override
    public SDSelectViewHandler setImageResIdSelected(int imageResIdSelected)
    {
        super.setImageResIdSelected(imageResIdSelected);
        return this;
    }

    @Override
    public SDSelectViewHandler setTextColorNormal(int textColorNormal)
    {
        super.setTextColorNormal(textColorNormal);
        return this;
    }

    @Override
    public SDSelectViewHandler setTextColorResIdNormal(int textColorResIdNormal)
    {
        super.setTextColorResIdNormal(textColorResIdNormal);
        return this;
    }

    @Override
    public SDSelectViewHandler setTextColorResIdSelected(int textColorResIdSelected)
    {
        super.setTextColorResIdSelected(textColorResIdSelected);
        return this;
    }

    @Override
    public SDSelectViewHandler setTextColorSelected(int textColorSelected)
    {
        super.setTextColorSelected(textColorSelected);
        return this;
    }

    @Override
    public SDSelectViewHandler setTextSizeNormal(int textSizeNormal)
    {
        super.setTextSizeNormal(textSizeNormal);
        return this;
    }

    @Override
    public SDSelectViewHandler setTextSizeSelected(int textSizeSelected)
    {
        super.setTextSizeSelected(textSizeSelected);
        return this;
    }

    @Override
    public SDSelectViewHandler setVisibilityNormal(int visibilityNormal)
    {
        super.setVisibilityNormal(visibilityNormal);
        return this;
    }

    @Override
    public SDSelectViewHandler setVisibilitySelected(int visibilitySelected)
    {
        super.setVisibilitySelected(visibilitySelected);
        return this;
    }

    @Override
    public SDSelectViewHandler setWidthNormal(int widthNormal)
    {
        super.setWidthNormal(widthNormal);
        return this;
    }

    @Override
    public SDSelectViewHandler setWidthSelected(int widthSelected)
    {
        super.setWidthSelected(widthSelected);
        return this;
    }
    //----------Override end----------

}
