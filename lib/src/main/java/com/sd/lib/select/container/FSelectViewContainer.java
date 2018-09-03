package com.sd.lib.select.container;

import android.view.View;

import com.sd.lib.select.FSelectConfig;
import com.sd.lib.select.SelectConfig;

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
