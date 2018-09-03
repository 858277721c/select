package com.sd.lib.select;

import android.view.View;

import com.sd.lib.select.properties.ImageViewProperties;
import com.sd.lib.select.properties.TextViewProperties;
import com.sd.lib.select.properties.ViewProperties;

/**
 * View的状态参数配置
 */
public interface SelectConfig
{
    /**
     * 配置View的属性
     *
     * @param initer
     * @return
     */
    SelectConfig configView(PropertiesIniter<ViewProperties> initer);

    /**
     * 配置TextView的属性
     *
     * @param initer
     * @return
     */
    SelectConfig configTextView(PropertiesIniter<TextViewProperties> initer);

    /**
     * 配置ImageView的属性
     *
     * @param initer
     * @return
     */
    SelectConfig configImageView(PropertiesIniter<ImageViewProperties> initer);

    /**
     * 清空配置
     *
     * @return
     */
    SelectConfig clear();

    /**
     * 设置view是否选中
     *
     * @param selected
     * @param view
     */
    void setSelected(boolean selected, View view);

    interface PropertiesIniter<T extends ViewProperties>
    {
        void init(T normal, T selected);
    }
}
