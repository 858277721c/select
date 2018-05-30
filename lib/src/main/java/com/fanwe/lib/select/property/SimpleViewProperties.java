package com.fanwe.lib.select.property;

import android.view.View;

import com.fanwe.lib.select.handler.ImageViewImageResIdHandler;
import com.fanwe.lib.select.handler.TextViewTextColorHandler;
import com.fanwe.lib.select.handler.TextViewTextSizeHandler;
import com.fanwe.lib.select.handler.ViewAlphaHandler;
import com.fanwe.lib.select.handler.ViewBackgroundHandler;
import com.fanwe.lib.select.handler.ViewHeightHandler;
import com.fanwe.lib.select.handler.ViewVisibilityHandler;
import com.fanwe.lib.select.handler.ViewWidthHandler;

import java.util.HashMap;
import java.util.Map;

class SimpleViewProperties implements ViewProperties
{
    private final Map<Type, ViewProperty> mMapProperty = new HashMap<>();

    @Override
    public final <V> ViewProperty<V> get(Type type)
    {
        if (type == null)
            throw new NullPointerException("type is null");

        ViewProperty property = mMapProperty.get(type);
        if (property == null)
        {
            switch (type)
            {
                case Alpha:
                    property = new SimpleViewProperty<>(type, new ViewAlphaHandler(), this);
                    break;
                case BackgroundDrawable:
                    property = new SimpleViewProperty<>(type, new ViewBackgroundHandler(), this);
                    break;
                case Visibility:
                    property = new SimpleViewProperty<>(type, new ViewVisibilityHandler(), this);
                    break;
                case Width:
                    property = new SimpleViewProperty<>(type, new ViewWidthHandler(), this);
                    break;
                case Height:
                    property = new SimpleViewProperty<>(type, new ViewHeightHandler(), this);
                    break;
                case TextColor:
                    property = new SimpleTextViewProperty(type, new TextViewTextColorHandler(), this);
                    break;
                case TextSize:
                    property = new SimpleTextViewProperty(type, new TextViewTextSizeHandler(), this);
                    break;
                case ImageResId:
                    property = new SimpleImageViewProperty(type, new ImageViewImageResIdHandler(), this);
                    break;
                default:
                    break;
            }
            mMapProperty.put(type, property);
        }

        return property;
    }

    @Override
    public void remove(Type type)
    {
        mMapProperty.remove(type);
    }

    @Override
    public void setSelected(boolean selected, View view)
    {
        if (view == null)
            return;

        for (ViewProperty item : mMapProperty.values())
        {
            item.setSelected(selected, view);
        }
    }
}
