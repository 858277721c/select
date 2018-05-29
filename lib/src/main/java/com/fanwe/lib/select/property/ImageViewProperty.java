package com.fanwe.lib.select.property;

public interface ImageViewProperty<V> extends ViewProperty<V>
{
    ImageViewProperty<Integer> imageResId();

    @Override
    ImageViewProperty<V> normal(V value);

    @Override
    ImageViewProperty<V> selected(V value);
}
