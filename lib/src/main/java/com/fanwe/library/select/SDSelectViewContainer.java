package com.fanwe.library.select;

import android.view.View;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Administrator on 2017/8/26.
 */
public class SDSelectViewContainer
{
    private WeakHashMap<View, SDSelectViewConfig> mMapViewConfig = new WeakHashMap<>();

    /**
     * 把View添加到容器中，并返回该View对应的Config
     *
     * @param view
     * @return
     */
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

    /**
     * 把View从容器中移除
     *
     * @param view
     */
    public void remove(View view)
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

    /**
     * 设置容器中的所有View是否选中
     *
     * @param selected
     */
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
            SDSelectViewConfig config = item.getValue();
            if (config != null)
            {
                config.setSelected(selected);
            }
        }
    }

    /**
     * 清空容器中的所有View
     */
    public void clear()
    {
        mMapViewConfig.clear();
    }
}
