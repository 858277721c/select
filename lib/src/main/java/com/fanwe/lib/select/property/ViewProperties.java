package com.fanwe.lib.select.property;

import android.view.View;

public interface ViewProperties
{
    <V> ViewProperty<V> get(Type type, Class<V> clazz);

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
