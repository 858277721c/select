package com.fanwe.lib.select.properties;

public class FViewProperties
{
    FViewProperties()
    {
    }

    public static ViewProperties ofView()
    {
        return new SimpleViewProperties();
    }

    public static TextViewProperties ofTextView()
    {
        return new SimpleTextViewProperties();
    }

    public static ImageViewProperties ofImageView()
    {
        return new SimpleImageViewProperties();
    }
}
