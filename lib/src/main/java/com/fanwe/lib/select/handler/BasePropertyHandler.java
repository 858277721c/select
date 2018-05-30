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
package com.fanwe.lib.select.handler;

import android.view.View;

/**
 * Created by zhengjun on 2017/9/15.
 */
public abstract class BasePropertyHandler<T>
{
    private T mValueNormal;
    private T mValueSelected;

    private OnValueChangeCallback mOnValueChangeCallback;

    public void setOnValueChangeCallback(OnValueChangeCallback onValueChangeCallback)
    {
        mOnValueChangeCallback = onValueChangeCallback;
    }

    /**
     * 设置未选中状态的值
     *
     * @param value
     */
    public final void setValueNormal(T value)
    {
        if (mValueNormal != value)
        {
            mValueNormal = value;

            if (mOnValueChangeCallback != null)
                mOnValueChangeCallback.onValueChanged(false, value, this);
        }
    }

    /**
     * 设置选中状态的值
     *
     * @param value
     */
    public final void setValueSelected(T value)
    {
        if (mValueSelected != value)
        {
            mValueSelected = value;

            if (mOnValueChangeCallback != null)
                mOnValueChangeCallback.onValueChanged(true, value, this);
        }
    }

    /**
     * 设置是否选中
     *
     * @param selected
     */
    public final void setSelected(boolean selected, View view)
    {
        if (view != null)
        {
            final T value = selected ? mValueSelected : mValueNormal;
            onSelectedChanged(selected, value, view);
        }
    }

    protected abstract void onSelectedChanged(boolean selected, T value, View view);

    /**
     * 值是否为空
     *
     * @return
     */
    public final boolean isEmpty()
    {
        return mValueNormal == null && mValueSelected == null;
    }

    public interface OnValueChangeCallback<T>
    {
        /**
         * 值变化回调
         *
         * @param selectedValue true-选中状态的值，false-未选中状态的值
         * @param value
         * @param handler
         */
        void onValueChanged(boolean selectedValue, T value, BasePropertyHandler<T> handler);
    }
}
