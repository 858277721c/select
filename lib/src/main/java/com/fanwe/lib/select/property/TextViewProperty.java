package com.fanwe.lib.select.property;

public interface TextViewProperty<V> extends ViewProperty<V>
{
    TextViewProperty<Integer> textSize();

    TextViewProperty<Integer> textColor();

    @Override
    TextViewProperty<V> normal(V value);

    @Override
    TextViewProperty<V> selected(V value);
}
