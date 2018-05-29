package com.fanwe.lib.select.property;

import android.view.View;

public interface ViewProperties
{
    void put(Type type, ViewProperty property);

    <T> ViewProperty<T> get(Type type);

    void remove(Type type);

    /**
     * 设置View是否选中
     *
     * @param selected
     */
    void setSelected(boolean selected, View view);

    enum Type
    {
        Alpha,
        BackgroundDrawable,
        Visibility,
        Width,
        Height,
        TextColor,
        TextSize,
        ImageResId
    }
}
