package com.fanwe.lib.select.property;

import android.view.View;

import java.util.HashMap;
import java.util.Map;

final class SimpleViewPropertyHolder implements ViewPropertyHolder
{
    private Map<Type, ViewProperty> mMapProperty = new HashMap<>();

    @Override
    public final void put(Type type, ViewProperty property)
    {
        if (type == null)
            throw new NullPointerException("type is null");
        if (property == null)
            throw new NullPointerException("property is null");

        mMapProperty.put(type, property);
    }

    @Override
    public final <T> ViewProperty<T> get(Type type)
    {
        return mMapProperty.get(type);
    }

    @Override
    public final void remove(Type type)
    {
        mMapProperty.remove(type);
    }

    @Override
    public void setSelected(boolean selected, View view)
    {
        if (view == null)
            return;

        for (ViewProperty item : mMapProperty.values())
        {
            item.setSelected(selected, view);
        }
    }
}
