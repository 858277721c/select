package com.fanwe.library.select.view;

import android.view.View;

/**
 * Created by Administrator on 2017/8/22.
 */

public interface ISDSelectView
{
    /**
     * 是否选中
     *
     * @return
     */
    boolean isSelected();

    /**
     * 设置是否选中
     *
     * @param selected true-选中，false-未选中
     */
    void setSelected(boolean selected);

    /**
     * 设置选中变化回调
     *
     * @param onSelectedChangeCallback
     */
    void setOnSelectedChangeCallback(OnSelectedChangeCallback onSelectedChangeCallback);

    /**
     * 根据view的状态刷新view
     *
     * @param notifyCallback
     */
    void updateViewState(boolean notifyCallback);

    interface OnSelectedChangeCallback
    {
        void onSelectedChanged(boolean selected, View view);
    }
}
