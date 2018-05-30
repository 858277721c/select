package com.fanwe.lib.select.properties;

/**
 * ImageView属性配置接口
 */
public interface ImageViewProperties extends ViewProperties
{
    /**
     * 设置图片资源id
     *
     * @param value
     * @return
     */
    ImageViewProperties setImageResId(Integer value);

    @Override
    ImageViewProperties reset();

    @Override
    ImageViewProperties clone();
}
