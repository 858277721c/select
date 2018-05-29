package com.fanwe.lib.select.property;

public class FTextViewProperty<T> extends FViewProperty<T> implements TextViewProperty<T>
{
    @Override
    public ViewProperty<Integer> textSize()
    {
        return property(ViewPropertyHolder.Type.TextSize);
    }

    @Override
    public ViewProperty<Integer> textColor()
    {
        return property(ViewPropertyHolder.Type.TextColor);
    }
}
