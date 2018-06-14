package com.fanwe.lib.select.config;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;
import java.util.WeakHashMap;

public final class FSelectConfig
{
    private static final Map<View, SelectConfig> MAP_CONFIG = new WeakHashMap<>();

    public static ViewSelectConfig configView(View view)
    {
        if (view == null)
            return null;

        final SelectConfig config = MAP_CONFIG.get(view);
        if (config != null && config instanceof ViewSelectConfig)
            return (ViewSelectConfig) config;

        final SimpleViewConfig newConfig = new SimpleViewConfig(view);
        MAP_CONFIG.put(view, newConfig);
        return newConfig;
    }

    public static TextViewSelectConfig configTextView(TextView view)
    {
        if (view == null)
            return null;

        final SelectConfig config = MAP_CONFIG.get(view);
        if (config != null && config instanceof TextViewSelectConfig)
            return (TextViewSelectConfig) config;

        final SimpleTextViewConfig newConfig = new SimpleTextViewConfig(view);
        MAP_CONFIG.put(view, newConfig);
        return newConfig;
    }

    public static ImageViewSelectConfig configImageView(ImageView view)
    {
        if (view == null)
            return null;

        final SelectConfig config = MAP_CONFIG.get(view);
        if (config != null && config instanceof ImageViewSelectConfig)
            return (ImageViewSelectConfig) config;

        final SimpleImageViewConfig newConfig = new SimpleImageViewConfig(view);
        MAP_CONFIG.put(view, newConfig);
        return newConfig;
    }

    public static void removeConfig(View view)
    {
        MAP_CONFIG.remove(view);
    }
}
