package com.fanwe.lib.select.property;

public final class FViewProperties extends SimpleViewProperties
{
    private FViewProperties()
    {
    }

    public static ViewProperty ofView()
    {
        return new SimpleViewProperty();
    }

    public static TextViewProperty ofTextView()
    {
        return new SimpleTextViewProperty();
    }

    public static ImageViewProperty ofImageView()
    {
        return new SimpleImageViewProperty();
    }
}
