package com.fanwe.lib.select.property;

class SimpleTextViewProperty<T> extends SimpleViewProperty<T> implements TextViewProperty<T>
{
    @Override
    public final ViewProperty<Integer> textSize()
    {
        return property(ViewProperties.Type.TextSize);
    }

    @Override
    public final ViewProperty<Integer> textColor()
    {
        return property(ViewProperties.Type.TextColor);
    }
}
