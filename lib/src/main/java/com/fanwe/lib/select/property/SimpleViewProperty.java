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
package com.fanwe.lib.select.property;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.fanwe.lib.select.handler.BasePropertyHandler;
import com.fanwe.lib.select.handler.ImageViewImageResIdHandler;
import com.fanwe.lib.select.handler.TextViewTextColorHandler;
import com.fanwe.lib.select.handler.TextViewTextSizeHandler;
import com.fanwe.lib.select.handler.ViewAlphaHandler;
import com.fanwe.lib.select.handler.ViewBackgroundHandler;
import com.fanwe.lib.select.handler.ViewVisibilityHandler;
import com.fanwe.lib.select.handler.ViewWidthHandler;

/**
 * Created by zhengjun on 2017/9/15.
 */
class SimpleViewProperty<T> implements ViewProperty<T>
{
    private BasePropertyHandler<T> mPropertyHandler;
    private ViewProperties mProperties;
    private ViewProperties.Type mType;

    public SimpleViewProperty()
    {
    }

    private SimpleViewProperty(ViewProperties.Type type, BasePropertyHandler<T> handler, ViewProperties properties)
    {
        if (type == null || handler == null || properties == null)
            throw new NullPointerException("param must not be null");

        mType = type;
        mPropertyHandler = handler;
        mProperties = properties;
    }

    @Override
    public final ViewProperty<Float> alpha()
    {
        return property(ViewProperties.Type.Alpha);
    }

    @Override
    public final ViewProperty<Drawable> backgroundDrawable()
    {
        return property(ViewProperties.Type.BackgroundDrawable);
    }

    @Override
    public final ViewProperty<Integer> visibility()
    {
        return property(ViewProperties.Type.Visibility);
    }

    @Override
    public final ViewProperty<Integer> width()
    {
        return property(ViewProperties.Type.Width);
    }

    @Override
    public final ViewProperty<Integer> height()
    {
        return property(ViewProperties.Type.Height);
    }

    final <T> ViewProperty<T> property(ViewProperties.Type type)
    {
        final ViewProperties properties = properties();
        ViewProperty<T> property = properties.get(type);
        if (property == null)
        {
            BasePropertyHandler handler = null;
            switch (type)
            {
                case Alpha:
                    handler = new ViewAlphaHandler(mOnValueChangeCallback);
                    break;
                case BackgroundDrawable:
                    handler = new ViewBackgroundHandler(mOnValueChangeCallback);
                    break;
                case Visibility:
                    handler = new ViewVisibilityHandler(mOnValueChangeCallback);
                    break;
                case Width:
                    handler = new ViewWidthHandler(mOnValueChangeCallback);
                    break;
                case TextColor:
                    handler = new TextViewTextColorHandler(mOnValueChangeCallback);
                    break;
                case TextSize:
                    handler = new TextViewTextSizeHandler(mOnValueChangeCallback);
                    break;
                case ImageResId:
                    handler = new ImageViewImageResIdHandler(mOnValueChangeCallback);
                    break;
                default:
                    break;
            }

            property = new SimpleViewProperty<>(type, handler, properties);
            properties.put(type, property);
        }
        return property;
    }

    @Override
    public final ViewProperties properties()
    {
        if (mProperties == null)
            mProperties = new SimpleViewProperties();
        return mProperties;
    }

    private final BasePropertyHandler.OnValueChangeCallback<T> mOnValueChangeCallback = new BasePropertyHandler.OnValueChangeCallback<T>()
    {
        @Override
        public void onValueChanged(boolean selectedValue, T value, BasePropertyHandler<T> handler)
        {
            if (handler.isEmpty())
                properties().remove(mType);
        }
    };

    @Override
    public final ViewProperty<T> normal(T value)
    {
        mPropertyHandler.setValueNormal(value);
        return this;
    }

    @Override
    public final ViewProperty<T> selected(T value)
    {
        mPropertyHandler.setValueSelected(value);
        return this;
    }

    @Override
    public void setSelected(boolean selected, View view)
    {
        mPropertyHandler.setSelected(selected, view);
    }
}