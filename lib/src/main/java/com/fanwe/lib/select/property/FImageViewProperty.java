package com.fanwe.lib.select.property;

public class FImageViewProperty<T> extends FViewProperty<T> implements ImageViewProperty<T>
{
    @Override
    public ViewProperty<Integer> imageResId()
    {
        return property(ViewPropertyHolder.Type.ImageResId);
    }
}
