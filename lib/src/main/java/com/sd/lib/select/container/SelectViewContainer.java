package com.sd.lib.select.container;

import android.view.View;

import com.sd.lib.select.SelectConfig;

public interface SelectViewContainer
{
    /**
     * 调用setSelected的时候是否也触发View的setSelected方法，默认false
     *
     * @param invokeViewSelected
     */
    void setInvokeViewSelected(boolean invokeViewSelected);

    /**
     * 把View添加到容器中，并返回该View对应的Config
     *
     * @param view
     * @return
     */
    SelectConfig config(View view);

    /**
     * 把View和对应的Config移除
     *
     * @param view
     */
    void removeConfig(View view);

    /**
     * 清空容器中的所有View和对应的Config
     */
    void clearConfig();

    /**
     * 设置容器中的所有View是否选中
     *
     * @param selected
     */
    void setSelected(boolean selected);
}
