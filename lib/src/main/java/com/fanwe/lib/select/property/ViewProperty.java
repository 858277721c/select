package com.fanwe.lib.select.property;

import android.graphics.drawable.Drawable;
import android.view.View;

public interface ViewProperty<V>
{
    ViewProperties.Type getType();

    ViewProperty<Float> alpha();

    ViewProperty<Drawable> backgroundDrawable();

    ViewProperty<Integer> visibility();

    ViewProperty<Integer> width();

    ViewProperty<Integer> height();

    ViewProperties properties();

    /**
     * 设置未选中状态的值
     *
     * @param value
     */
    ViewProperty<V> normal(V value);

    /**
     * 设置选中状态的值
     *
     * @param value
     */
    ViewProperty<V> selected(V value);

    /**
     * 设置是否选中
     *
     * @param selected
     */
    void setSelected(boolean selected, View view);
}
