package com.fanwe.lib.select.property;

import com.fanwe.lib.select.handler.BasePropertyHandler;

class SimpleTextViewProperty<V> extends SimpleViewProperty<V> implements TextViewProperty<V>
{
    public SimpleTextViewProperty()
    {
    }

    public SimpleTextViewProperty(ViewProperties.Type type, BasePropertyHandler<V> handler, ViewProperties properties)
    {
        super(type, handler, properties);
    }

    @Override
    public final TextViewProperty<Integer> textSize()
    {
        final ViewProperty<Integer> property = properties().get(ViewProperties.Type.TextSize);
        return (TextViewProperty<Integer>) property;
    }

    @Override
    public final TextViewProperty<Integer> textColor()
    {
        final ViewProperty<Integer> property = properties().get(ViewProperties.Type.TextColor);
        return (TextViewProperty<Integer>) property;
    }

    @Override
    public TextViewProperty<V> normal(V value)
    {
        super.normal(value);
        return this;
    }

    @Override
    public TextViewProperty<V> selected(V value)
    {
        super.selected(value);
        return this;
    }
}
