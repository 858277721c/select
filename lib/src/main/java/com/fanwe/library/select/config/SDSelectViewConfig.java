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
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * View的参数配置
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

    public static SDSelectTextViewConfig configText(TextView view)
    {
        SDSelectTextViewConfig config = new SDSelectTextViewConfig(view);
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

    public SDSelectViewConfig setBackgroundNormal(Drawable value)
    {
        getBackgroundHandler().setValueNormal(value);
        if (!addOrRemoveHandler(getBackgroundHandler()))
        {
            mBackgroundHandler = null;
        }
        return this;
    }

    public SDSelectViewConfig setBackgroundSelected(Drawable value)
    {
        getBackgroundHandler().setValueSelected(value);
        if (!addOrRemoveHandler(getBackgroundHandler()))
        {
            mBackgroundHandler = null;
        }
        return this;
    }

    public SDSelectViewConfig setBackgroundResIdNormal(Integer value)
    {
        setBackgroundNormal(value == null ? null : getContext().getResources().getDrawable(value));
        return this;
    }

    public SDSelectViewConfig setBackgroundResIdSelected(Integer value)
    {
        setBackgroundSelected(value == null ? null : getContext().getResources().getDrawable(value));
        return this;
    }

    public SDSelectViewConfig setBackgroundColorNormal(Integer value)
    {
        setBackgroundNormal(value == null ? null : new ColorDrawable(value));
        return this;
    }

    public SDSelectViewConfig setBackgroundColorSelected(Integer value)
    {
        setBackgroundSelected(value == null ? null : new ColorDrawable(value));
        return this;
    }

    public SDSelectViewConfig setBackgroundColorResIdNormal(Integer value)
    {
        setBackgroundColorNormal(value == null ? null : getContext().getResources().getColor(value));
        return this;
    }

    public SDSelectViewConfig setBackgroundColorResIdSelected(Integer value)
    {
        setBackgroundColorSelected(value == null ? null : getContext().getResources().getColor(value));
        return this;
    }

    public SDSelectViewConfig setAlphaNormal(Float value)
    {
        getAlphaHandler().setValueNormal(value);
        if (!addOrRemoveHandler(getAlphaHandler()))
        {
            mAlphaHandler = null;
        }
        return this;
    }

    public SDSelectViewConfig setAlphaSelected(Float value)
    {
        getAlphaHandler().setValueSelected(value);
        if (!addOrRemoveHandler(getAlphaHandler()))
        {
            mAlphaHandler = null;
        }
        return this;
    }

    public SDSelectViewConfig setWidthNormal(Integer value)
    {
        getWidthHandler().setValueNormal(value);
        if (!addOrRemoveHandler(getWidthHandler()))
        {
            mWidthHandler = null;
        }
        return this;
    }

    public SDSelectViewConfig setWidthSelected(Integer value)
    {
        getWidthHandler().setValueSelected(value);
        if (!addOrRemoveHandler(getWidthHandler()))
        {
            mWidthHandler = null;
        }
        return this;
    }

    public SDSelectViewConfig setHeightNormal(Integer value)
    {
        getHeightHandler().setValueNormal(value);
        if (!addOrRemoveHandler(getHeightHandler()))
        {
            mHeightHandler = null;
        }
        return this;
    }

    public SDSelectViewConfig setHeightSelected(Integer value)
    {
        getHeightHandler().setValueSelected(value);
        if (!addOrRemoveHandler(getHeightHandler()))
        {
            mHeightHandler = null;
        }
        return this;
    }

    public SDSelectViewConfig setVisibilityNormal(Integer value)
    {
        getVisibilityHandler().setValueNormal(value);
        if (!addOrRemoveHandler(getVisibilityHandler()))
        {
            mVisibilityHandler = null;
        }
        return this;
    }

    public SDSelectViewConfig setVisibilitySelected(Integer value)
    {
        getVisibilityHandler().setValueSelected(value);
        if (!addOrRemoveHandler(getVisibilityHandler()))
        {
            mVisibilityHandler = null;
        }
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

    /**
     * 把handler添加到列表或者从列表移除
     *
     * @param handler
     * @return true-添加,false-移除
     */
    protected final boolean addOrRemoveHandler(ViewPropertyHandler handler)
    {
        if (handler.isEmpty())
        {
            if (mListHandler != null)
            {
                mListHandler.remove(handler);
                if (mListHandler.isEmpty())
                {
                    mListHandler = null;
                }
            }
            return false;
        } else
        {
            if (mListHandler == null)
            {
                mListHandler = new ArrayList<>();
            }
            if (!mListHandler.contains(handler))
            {
                mListHandler.add(handler);
            }
            return true;
        }
    }
}
