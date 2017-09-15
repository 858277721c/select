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
package com.fanwe.library.select.container;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fanwe.library.select.config.SDSelectImageViewConfig;
import com.fanwe.library.select.config.SDSelectTextViewConfig;
import com.fanwe.library.select.config.SDSelectViewConfig;

import java.util.Map;
import java.util.WeakHashMap;

public class SDSelectViewContainer implements ISDSelectViewContainer
{
    private WeakHashMap<View, SDSelectViewConfig> mMapViewConfig = new WeakHashMap<>();

    private boolean mInvokeViewSelected = false;

    @Override
    public void setInvokeViewSelected(boolean invokeViewSelected)
    {
        mInvokeViewSelected = invokeViewSelected;
    }

    @Override
    public SDSelectViewConfig config(View view)
    {
        if (view == null)
        {
            return null;
        }
        SDSelectViewConfig config = mMapViewConfig.get(view);
        if (config == null)
        {
            config = SDSelectViewConfig.config(view);
            mMapViewConfig.put(view, config);
        }
        return config;
    }

    @Override
    public SDSelectImageViewConfig configImage(ImageView view)
    {
        if (view == null)
        {
            return null;
        }
        SDSelectImageViewConfig config = (SDSelectImageViewConfig) mMapViewConfig.get(view);
        if (config == null)
        {
            config = SDSelectViewConfig.configImage(view);
            mMapViewConfig.put(view, config);
        }
        return config;
    }

    @Override
    public SDSelectTextViewConfig configText(TextView view)
    {
        if (view == null)
        {
            return null;
        }
        SDSelectTextViewConfig config = (SDSelectTextViewConfig) mMapViewConfig.get(view);
        if (config == null)
        {
            config = SDSelectViewConfig.configText(view);
            mMapViewConfig.put(view, config);
        }
        return config;
    }

    @Override
    public void removeConfig(View view)
    {
        if (view == null)
        {
            return;
        }
        mMapViewConfig.remove(view);
    }

    @Override
    public void clearConfig()
    {
        mMapViewConfig.clear();
    }

    @Override
    public void setSelected(boolean selected)
    {
        if (mMapViewConfig.isEmpty())
        {
            return;
        }

        for (Map.Entry<View, SDSelectViewConfig> item : mMapViewConfig.entrySet())
        {
            item.getValue().setSelected(selected, mInvokeViewSelected);
        }
    }
}
