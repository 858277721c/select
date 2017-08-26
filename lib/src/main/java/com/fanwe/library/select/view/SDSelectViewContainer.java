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
     * 把View添加到容器中，并返回该View对应的选中状态处理对象
     *
     * @param view
     */
    public SDSelectViewHandler config(View view)
    {
        final SDSelectViewHandler handler = SDSelectViewHandler.config(view);
        if (handler != null)
        {
            mMapView.put(view, 0);
        }
        return handler;
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
        mMapView.remove(view);
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
                SDSelectViewHandler.setSelected(view, selected);
            } else
            {
                it.remove();
            }
        }
    }
}
