package com.fanwe.lib.select.property;

class SimpleImageViewProperty<T> extends SimpleViewProperty<T> implements ImageViewProperty<T>
{
    @Override
    public final ViewProperty<Integer> imageResId()
    {
        return property(ViewProperties.Type.ImageResId);
    }
}
