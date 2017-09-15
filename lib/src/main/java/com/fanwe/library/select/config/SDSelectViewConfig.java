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
package com.fanwe.library.select.config;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * SDSelectView的参数配置
 */
public class SDSelectViewConfig
{
    private Context mContext;
    private WeakReference<View> mView;

    private List<ViewPropertyHandler> mListHandler;
    private ViewBackgroundHandler mBackgroundHandler;
    private ViewAlphaHandler mAlphaHandler;
    private ViewWidthHandler mWidthHandler;
    private ViewHeightHandler mHeightHandler;
    private ViewVisibilityHandler mVisibilityHandler;

    protected SDSelectViewConfig(View view)
    {
        setView(view);
    }

    public static SDSelectViewConfig config(View view)
    {
        SDSelectViewConfig config = new SDSelectViewConfig(view);
        return config;
    }

    public static SDSelectImageViewConfig configImage(ImageView view)
    {
        SDSelectImageViewConfig config = new SDSelectImageViewConfig(view);
        return config;
    }

    /**
     * 设置View是否选中
     *
     * @param selected
     */
    public void setSelected(boolean selected)
    {
        setSelected(selected, true);
    }

    /**
     * 设置View是否选中
     *
     * @param selected
     * @param invokeViewSelected 是否触发View的setSelected方法
     */
    public void setSelected(boolean selected, boolean invokeViewSelected)
    {
        final View view = getView();
        if (view == null)
        {
            return;
        }

        if (mListHandler != null)
        {
            for (ViewPropertyHandler item : mListHandler)
            {
                item.setSelected(selected);
            }
        }

        if (invokeViewSelected)
        {
            view.setSelected(selected);
        }
    }

    //---------- properties start ----------

    public SDSelectViewConfig setBackground(Drawable normal, Drawable selected)
    {
        getBackgroundHandler().setValueNormal(normal);
        getBackgroundHandler().setValueSelected(selected);
        addOrRemoveHandler(getBackgroundHandler());
        return this;
    }

    public SDSelectViewConfig setBackgroundResId(Integer normal, Integer selected)
    {
        setBackground(normal == null ? null : getContext().getResources().getDrawable(normal),
                selected == null ? null : getContext().getResources().getDrawable(selected));
        return this;
    }

    public SDSelectViewConfig setBackgroundColor(Integer normal, Integer selected)
    {
        setBackground(normal == null ? null : new ColorDrawable(normal),
                selected == null ? null : new ColorDrawable(selected));
        return this;
    }

    public SDSelectViewConfig setBackgroundColorResId(Integer normal, Integer selected)
    {
        setBackground(normal == null ? null : new ColorDrawable(getContext().getResources().getColor(normal)),
                selected == null ? null : new ColorDrawable(getContext().getResources().getColor(selected)));
        return this;
    }

    public SDSelectViewConfig setAlpha(Float normal, Float selected)
    {
        getAlphaHandler().setValueNormal(normal);
        getAlphaHandler().setValueSelected(selected);
        addOrRemoveHandler(getAlphaHandler());
        return this;
    }

    public SDSelectViewConfig setWidth(Integer normal, Integer selected)
    {
        getWidthHandler().setValueNormal(normal);
        getWidthHandler().setValueSelected(selected);
        addOrRemoveHandler(getWidthHandler());
        return this;
    }

    public SDSelectViewConfig setHeight(Integer normal, Integer selected)
    {
        getHeightHandler().setValueNormal(normal);
        getHeightHandler().setValueSelected(selected);
        addOrRemoveHandler(getHeightHandler());
        return this;
    }

    public SDSelectViewConfig setVisibility(Integer normal, Integer selected)
    {
        getVisibilityHandler().setValueNormal(normal);
        getVisibilityHandler().setValueSelected(selected);
        addOrRemoveHandler(getVisibilityHandler());
        return this;
    }

    //---------- properties end ----------

    protected final Context getContext()
    {
        return mContext;
    }

    public final View getView()
    {
        if (mView != null)
        {
            return mView.get();
        } else
        {
            return null;
        }
    }

    private SDSelectViewConfig setView(View view)
    {
        final View oldView = getView();
        if (oldView != view)
        {
            if (view != null)
            {
                mView = new WeakReference<>(view);

                mContext = view.getContext().getApplicationContext();
            } else
            {
                mView = null;
            }
        }
        return this;
    }

    private ViewBackgroundHandler getBackgroundHandler()
    {
        if (mBackgroundHandler == null)
        {
            mBackgroundHandler = new ViewBackgroundHandler(getView());
        }
        return mBackgroundHandler;
    }

    private ViewAlphaHandler getAlphaHandler()
    {
        if (mAlphaHandler == null)
        {
            mAlphaHandler = new ViewAlphaHandler(getView());
        }
        return mAlphaHandler;
    }

    private ViewWidthHandler getWidthHandler()
    {
        if (mWidthHandler == null)
        {
            mWidthHandler = new ViewWidthHandler(getView());
        }
        return mWidthHandler;
    }

    private ViewHeightHandler getHeightHandler()
    {
        if (mHeightHandler == null)
        {
            mHeightHandler = new ViewHeightHandler(getView());
        }
        return mHeightHandler;
    }

    private ViewVisibilityHandler getVisibilityHandler()
    {
        if (mVisibilityHandler == null)
        {
            mVisibilityHandler = new ViewVisibilityHandler(getView());
        }
        return mVisibilityHandler;
    }

    protected final void addOrRemoveHandler(ViewPropertyHandler handler)
    {
        if (mListHandler == null)
        {
            mListHandler = new ArrayList<>();
        }
        if (handler.isEmpty())
        {
            mListHandler.remove(handler);
        } else
        {
            if (!mListHandler.contains(handler))
            {
                mListHandler.add(handler);
            }
        }
    }
}
