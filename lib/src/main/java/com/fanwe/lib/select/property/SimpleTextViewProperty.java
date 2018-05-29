package com.fanwe.lib.select.property;

import com.fanwe.lib.select.handler.BasePropertyHandler;

class SimpleTextViewProperty<V> extends SimpleViewProperty<V> implements TextViewProperty<V>
{
    public SimpleTextViewProperty()
    {
    }

    public SimpleTextViewProperty(BasePropertyHandler<V> handler, ViewProperties properties)
    {
        super(handler, properties);
    }

    @Override
    public final TextViewProperty<Integer> textSize()
    {
        return (TextViewProperty<Integer>) properties().get(ViewProperties.Type.TextSize, Integer.class);
    }

    @Override
    public final TextViewProperty<Integer> textColor()
    {
        return (TextViewProperty<Integer>) properties().get(ViewProperties.Type.TextColor, Integer.class);
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
