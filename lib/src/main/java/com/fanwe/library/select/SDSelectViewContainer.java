package com.fanwe.library.select;

import android.view.View;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Administrator on 2017/8/26.
 */
public class SDSelectViewContainer implements ISDSelectViewContainer
{
    private WeakHashMap<View, SDSelectViewConfig> mMapViewConfig = new WeakHashMap<>();

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
            config = new SDSelectViewConfig(view);
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
        SDSelectViewConfig config = mMapViewConfig.get(view);
        if (config != null)
        {
            config.setView(null);
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

        Iterator<Map.Entry<View, SDSelectViewConfig>> it = mMapViewConfig.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<View, SDSelectViewConfig> item = it.next();
            if (item.getKey() == null)
            {
                it.remove();
            } else
            {
                item.getValue().setSelected(selected);
            }
        }
    }
}
