package com.fanwe.library.select;

import android.view.View;

/**
 * Created by Administrator on 2017/8/27.
 */

public interface ISDSelectViewContainer
{
    /**
     * 把View添加到容器中，并返回该View对应的Config
     *
     * @param view
     * @return
     */
    SDSelectViewConfig config(View view);

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
