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
package com.fanwe.lib.select.container;

import android.view.View;

import com.fanwe.lib.select.FSelectConfig;
import com.fanwe.lib.select.SelectConfig;

import java.util.Map;
import java.util.WeakHashMap;

public class FSelectViewContainer implements SelectViewContainer
{
    private final Map<View, SelectConfig> mMapViewConfig = new WeakHashMap<>();
    private boolean mInvokeViewSelected = false;

    @Override
    public void setInvokeViewSelected(boolean invokeViewSelected)
    {
        mInvokeViewSelected = invokeViewSelected;
    }

    @Override
    public SelectConfig config(View view)
    {
        if (view == null)
            return null;

        SelectConfig config = mMapViewConfig.get(view);
        if (config == null)
        {
            config = new FSelectConfig();
            mMapViewConfig.put(view, config);
        }
        return config;
    }

    @Override
    public void removeConfig(View view)
    {
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
            return;

        for (Map.Entry<View, SelectConfig> item : mMapViewConfig.entrySet())
        {
            final View view = item.getKey();
            final SelectConfig config = item.getValue();

            config.setSelected(selected, view);
            if (mInvokeViewSelected)
                view.setSelected(selected);
        }
    }
}
