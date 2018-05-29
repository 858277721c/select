package com.fanwe.lib.select.property;

import android.view.View;

import com.fanwe.lib.select.handler.BasePropertyHandler;
import com.fanwe.lib.select.handler.ImageViewImageResIdHandler;
import com.fanwe.lib.select.handler.TextViewTextColorHandler;
import com.fanwe.lib.select.handler.TextViewTextSizeHandler;
import com.fanwe.lib.select.handler.ViewAlphaHandler;
import com.fanwe.lib.select.handler.ViewBackgroundHandler;
import com.fanwe.lib.select.handler.ViewVisibilityHandler;
import com.fanwe.lib.select.handler.ViewWidthHandler;

import java.util.HashMap;
import java.util.Map;

class SimpleViewProperties implements ViewProperties, BasePropertyHandler.OnValueChangeCallback
{
    private final Map<Type, ViewProperty> mMapProperty = new HashMap<>();

    @Override
    public final <V> ViewProperty<V> get(Type type, Class<V> clazz)
    {
        if (type == null)
            throw new NullPointerException("type is null");

        ViewProperty property = mMapProperty.get(type);
        if (property == null)
        {
            switch (type)
            {
                case Alpha:
                    property = new SimpleViewProperty<>(new ViewAlphaHandler(this), this);
                    break;
                case BackgroundDrawable:
                    property = new SimpleViewProperty<>(new ViewBackgroundHandler(this), this);
                    break;
                case Visibility:
                    property = new SimpleViewProperty<>(new ViewVisibilityHandler(this), this);
                    break;
                case Width:
                    property = new SimpleViewProperty<>(new ViewWidthHandler(this), this);
                    break;
                case TextColor:
                    property = new SimpleTextViewProperty(new TextViewTextColorHandler(this), this);
                    break;
                case TextSize:
                    property = new SimpleTextViewProperty(new TextViewTextSizeHandler(this), this);
                    break;
                case ImageResId:
                    property = new SimpleImageViewProperty(new ImageViewImageResIdHandler(this), this);
                    break;
                default:
                    break;
            }
            mMapProperty.put(type, property);
        }

        return property;
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

    @Override
    public void onValueChanged(boolean selectedValue, Object value, BasePropertyHandler handler)
    {

    }
}
