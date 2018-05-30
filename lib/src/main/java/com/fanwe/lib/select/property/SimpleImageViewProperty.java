package com.fanwe.lib.select.property;

import com.fanwe.lib.select.handler.BasePropertyHandler;

class SimpleImageViewProperty<T> extends SimpleViewProperty<T> implements ImageViewProperty<T>
{
    public SimpleImageViewProperty()
    {
    }

    public SimpleImageViewProperty(ViewProperties.Type type, BasePropertyHandler<T> handler, ViewProperties properties)
    {
        super(type, handler, properties);
    }

    @Override
    public final ImageViewProperty<Integer> imageResId()
    {
        final ViewProperty<Integer> property = properties().get(ViewProperties.Type.ImageResId);
        return (ImageViewProperty<Integer>) property;
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
