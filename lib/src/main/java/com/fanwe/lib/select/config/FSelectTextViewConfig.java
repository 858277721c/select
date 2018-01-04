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
package com.fanwe.lib.select.config;

import android.view.View;

/**
 * Created by zhengjun on 2017/9/15.
 */
public class FSelectTextViewConfig extends FSelectViewConfig
{
    private TextViewTextColorHandler mTextColorHandler;
    private TextViewTextSizeHandler mTextSizeHandler;

    FSelectTextViewConfig(View view)
    {
        super(view);
    }

    public FSelectTextViewConfig setTextColorResIdNormal(Integer value)
    {
        return setTextColorNormal(value == null ? null : getContext().getResources().getColor(value));
    }

    public FSelectTextViewConfig setTextColorResIdSelected(Integer value)
    {
        return setTextColorSelected(value == null ? null : getContext().getResources().getColor(value));
    }

    //---------- properties start ----------

    public FSelectTextViewConfig setTextColorNormal(Integer value)
    {
        getTextColorHandler().setValueNormal(value);
        return this;
    }

    public FSelectTextViewConfig setTextColorSelected(Integer value)
    {
        getTextColorHandler().setValueSelected(value);
        return this;
    }

    public FSelectTextViewConfig setTextSizeNormal(Integer value)
    {
        getTextSizeHandler().setValueNormal(value);
        return this;
    }

    public FSelectTextViewConfig setTextSizeSelected(Integer value)
    {
        getTextSizeHandler().setValueSelected(value);
        return this;
    }

    //---------- properties end ----------

    @Override
    protected void onReleaseHandler(ViewPropertyHandler handler)
    {
        super.onReleaseHandler(handler);
        if (mTextColorHandler == handler)
        {
            mTextColorHandler = null;
        } else if (mTextSizeHandler == handler)
        {
            mTextSizeHandler = null;
        }
    }

    private TextViewTextColorHandler getTextColorHandler()
    {
        if (mTextColorHandler == null)
        {
            mTextColorHandler = new TextViewTextColorHandler(getView(), this);
        }
        return mTextColorHandler;
    }

    private TextViewTextSizeHandler getTextSizeHandler()
    {
        if (mTextSizeHandler == null)
        {
            mTextSizeHandler = new TextViewTextSizeHandler(getView(), this);
        }
        return mTextSizeHandler;
    }
}
