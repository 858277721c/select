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

import android.view.View;

/**
 * Created by zhengjun on 2017/9/15.
 */
public class SDSelectTextViewConfig extends SDSelectViewConfig
{
    private TextViewTextColorHandler mTextColorHandler;
    private TextViewTextSizeHandler mTextSizeHandler;

    SDSelectTextViewConfig(View view)
    {
        super(view);
    }

    //---------- properties start ----------

    public SDSelectTextViewConfig setTextColorNormal(Integer value)
    {
        getTextColorHandler().setValueNormal(value);
        addOrRemoveHandler(getTextColorHandler());
        return this;
    }

    public SDSelectTextViewConfig setTextColorSelected(Integer value)
    {
        getTextColorHandler().setValueSelected(value);
        addOrRemoveHandler(getTextColorHandler());
        return this;
    }

    public SDSelectTextViewConfig setTextColorResIdNormal(Integer value)
    {
        return setTextColorNormal(value == null ? null : getContext().getResources().getColor(value));
    }

    public SDSelectTextViewConfig setTextColorResIdSelected(Integer value)
    {
        return setTextColorSelected(value == null ? null : getContext().getResources().getColor(value));
    }

    public SDSelectTextViewConfig setTextSizeNormal(Integer value)
    {
        getTextSizeHandler().setValueNormal(value);
        addOrRemoveHandler(getTextSizeHandler());
        return this;
    }

    public SDSelectTextViewConfig setTextSizeSelected(Integer value)
    {
        getTextSizeHandler().setValueSelected(value);
        addOrRemoveHandler(getTextSizeHandler());
        return this;
    }

    //---------- properties end ----------


    @Override
    protected boolean onReleaseHandler(ViewPropertyHandler handler)
    {
        if (super.onReleaseHandler(handler))
        {
            return true;
        } else
        {
            if (handler == mTextColorHandler)
            {
                mTextColorHandler = null;
                return true;
            } else if (handler == mTextSizeHandler)
            {
                mTextSizeHandler = null;
                return true;
            }
            return false;
        }
    }

    private TextViewTextColorHandler getTextColorHandler()
    {
        if (mTextColorHandler == null)
        {
            mTextColorHandler = new TextViewTextColorHandler(getView());
        }
        return mTextColorHandler;
    }

    private TextViewTextSizeHandler getTextSizeHandler()
    {
        if (mTextSizeHandler == null)
        {
            mTextSizeHandler = new TextViewTextSizeHandler(getView());
        }
        return mTextSizeHandler;
    }
}
