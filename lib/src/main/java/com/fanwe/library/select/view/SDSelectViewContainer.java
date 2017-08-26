package com.fanwe.library.select.view;

import android.view.View;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Administrator on 2017/8/26.
 */
public class SDSelectViewContainer
{
    private Map<View, Integer> mMapView = new WeakHashMap<>();

    /**
     * 把View添加到容器中，并返回该View对应的Config
     *
     * @param view
     * @return
     */
    public SDSelectViewConfig config(View view)
    {
        SDSelectViewConfig config = SDSelectViewConfig.config(view);
        if (config != null)
        {
            add(view);
        }
        return config;
    }

    /**
     * 把View添加到容器中
     *
     * @param view
     */
    private void add(View view)
    {
        if (view == null)
        {
            return;
        }
        mMapView.put(view, 0);
    }

    /**
     * 把View从容器中移除
     *
     * @param views
     */
    public void remove(View... views)
    {
        if (views == null)
        {
            return;
        }
        for (View item : views)
        {
            mMapView.remove(item);
        }
    }

    /**
     * 设置容器中的所有View是否选中
     *
     * @param selected
     */
    public void setSelected(boolean selected)
    {
        if (mMapView.isEmpty())
        {
            return;
        }

        Iterator<Map.Entry<View, Integer>> it = mMapView.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<View, Integer> item = it.next();
            View view = item.getKey();
            if (view != null)
            {
                SDSelectViewConfig.setSelected(view, selected);
            } else
            {
                it.remove();
            }
        }
    }

    /**
     * 清空容器中的所有View
     */
    public void clear()
    {
        mMapView.clear();
    }
}
