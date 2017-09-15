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

import java.lang.ref.WeakReference;

/**
 * Created by zhengjun on 2017/9/15.
 */
abstract class ViewPropertyHandler<T>
{
    private WeakReference<View> mView;

    private T mValueNormal;
    private T mValueSelected;

    public ViewPropertyHandler(View view)
    {
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
            if (view != null)
            {
                mView = new WeakReference<>(view);
            } else
            {
                mView = null;
            }
        }
    }

    public void setValueNormal(T valueNormal)
    {
        this.mValueNormal = valueNormal;
    }

    public void setValueSelected(T valueSelected)
    {
        this.mValueSelected = valueSelected;
    }

    public void setSelected(boolean selected)
    {
        final View view = getView();
        if (view != null)
        {
            T value = selected ? mValueSelected : mValueNormal;
            onViewSelectedChanged(selected, value, view);
        }
    }

    protected abstract void onViewSelectedChanged(boolean selected, T value, View view);

    public boolean isEmpty()
    {
        return mValueNormal == null && mValueSelected == null;
    }
}
