package com.fanwe.lib.select.handler;

import android.view.View;

public interface PropertyHandler<T>
{
    /**
     * 设置值变化回调
     *
     * @param onValueChangeCallback
     */
    void setOnValueChangeCallback(OnValueChangeCallback onValueChangeCallback);

    /**
     * 设置未选中状态的值
     *
     * @param value
     */
    void setValueNormal(T value);

    /**
     * 设置选中状态的值
     *
     * @param value
     */
    void setValueSelected(T value);

    /**
     * 值是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 设置是否选中
     *
     * @param selected
     */
    void setSelected(boolean selected, View view);

    interface OnValueChangeCallback<T>
    {
        /**
         * 值变化回调
         *
         * @param selectedValue true-选中状态的值，false-未选中状态的值
         * @param value
         * @param handler
         */
        void onValueChanged(boolean selectedValue, T value, PropertyHandler<T> handler);
    }
}
