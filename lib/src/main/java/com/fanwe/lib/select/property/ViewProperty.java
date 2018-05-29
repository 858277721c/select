package com.fanwe.lib.select.property;

import android.graphics.drawable.Drawable;
import android.view.View;

public interface ViewProperty<T>
{
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
    ViewProperty<T> normal(T value);

    /**
     * 设置选中状态的值
     *
     * @param value
     */
    ViewProperty<T> selected(T value);

    /**
     * 设置是否选中
     *
     * @param selected
     */
    void setSelected(boolean selected, View view);
}
