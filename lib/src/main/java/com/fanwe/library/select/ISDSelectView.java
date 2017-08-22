package com.fanwe.library.select;

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
     * 设置是否选中
     *
     * @param selected  true-选中，false-未选中
     * @param percent   选中或者未选中的百分比
     * @param direction 选中或者未选中的方向
     */
    void setSelectedPercent(boolean selected, float percent, Direction direction);

    /**
     * 根据view的状态刷新view
     *
     * @param notifyCallback
     */
    void updateViewState(boolean notifyCallback);

    interface OnSelectStateChangeCallback
    {
        void onSelectStateChanged(boolean selected, View view);
    }

    interface OnSelectPercentChangeCallback
    {
        void onSelectPercentChanged(boolean selected, float percent, Direction direction, View view);
    }

    enum Direction
    {
        LeftToRight,
        RightToLeft,
        TopToBottom,
        BottomToTop,
    }
}
