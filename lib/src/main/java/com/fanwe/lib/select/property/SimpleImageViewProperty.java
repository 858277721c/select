package com.fanwe.lib.select.property;

import com.fanwe.lib.select.handler.BasePropertyHandler;

class SimpleImageViewProperty<T> extends SimpleViewProperty<T> implements ImageViewProperty<T>
{
    public SimpleImageViewProperty()
    {
    }

    public SimpleImageViewProperty(BasePropertyHandler<T> handler, ViewProperties properties)
    {
        super(handler, properties);
    }

    @Override
    public final ImageViewProperty<Integer> imageResId()
    {
        return (ImageViewProperty<Integer>) properties().get(ViewProperties.Type.ImageResId, Integer.class);
    }

    @Override
    public ImageViewProperty<T> normal(T value)
    {
        super.normal(value);
        return this;
    }

    @Override
    public ImageViewProperty<T> selected(T value)
    {
        super.selected(value);
        return this;
    }
}
