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

/**
 * Created by zhengjun on 2017/9/15.
 */
class SimpleViewProperty<T> implements ViewProperty<T>
{
    private BasePropertyHandler<T> mPropertyHandler;
    private ViewProperties mProperties;

    public SimpleViewProperty()
    {
    }

    public SimpleViewProperty(BasePropertyHandler<T> handler, ViewProperties properties)
    {
        if (handler == null || properties == null)
            throw new NullPointerException("param must not be null");

        mPropertyHandler = handler;
        mProperties = properties;
    }

    @Override
    public final ViewProperty<Float> alpha()
    {
        return properties().get(ViewProperties.Type.Alpha, Float.class);
    }

    @Override
    public final ViewProperty<Drawable> backgroundDrawable()
    {
        return properties().get(ViewProperties.Type.BackgroundDrawable, Drawable.class);
    }

    @Override
    public final ViewProperty<Integer> visibility()
    {
        return properties().get(ViewProperties.Type.Visibility, Integer.class);
    }

    @Override
    public final ViewProperty<Integer> width()
    {
        return properties().get(ViewProperties.Type.Width, Integer.class);
    }

    @Override
    public final ViewProperty<Integer> height()
    {
        return properties().get(ViewProperties.Type.Height, Integer.class);
    }

    @Override
    public final ViewProperties properties()
    {
        if (mProperties == null)
            mProperties = new SimpleViewProperties();
        return mProperties;
    }

    @Override
    public ViewProperty<T> normal(T value)
    {
        mPropertyHandler.setValueNormal(value);
        return this;
    }

    @Override
    public ViewProperty<T> selected(T value)
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