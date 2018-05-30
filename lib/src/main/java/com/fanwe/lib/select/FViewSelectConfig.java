package com.fanwe.lib.select;

import android.view.View;

import com.fanwe.lib.select.properties.FViewProperties;
import com.fanwe.lib.select.properties.ImageViewProperties;
import com.fanwe.lib.select.properties.TextViewProperties;
import com.fanwe.lib.select.properties.ViewProperties;

public class FViewSelectConfig implements ViewSelectConfig
{
    private ViewProperties mPropertiesNormal;
    private ViewProperties mPropertiesSelected;

    @Override
    public ViewSelectConfig configView(PropertiesIniter<ViewProperties> initer)
    {
        final ViewProperties normal = mPropertiesNormal != null ?
                mPropertiesNormal : FViewProperties.ofView();

        final ViewProperties selected = mPropertiesSelected != null ?
                mPropertiesSelected : FViewProperties.ofView();

        initer.init(normal, selected);
        mPropertiesNormal = normal;
        mPropertiesSelected = selected;

        return this;
    }

    @Override
    public ViewSelectConfig configTextView(PropertiesIniter<TextViewProperties> initer)
    {
        final TextViewProperties normal = mPropertiesNormal instanceof TextViewProperties ?
                (TextViewProperties) mPropertiesNormal : FViewProperties.ofTextView();

        final TextViewProperties selected = mPropertiesSelected instanceof TextViewProperties ?
                (TextViewProperties) mPropertiesSelected : FViewProperties.ofTextView();

        initer.init(normal, selected);
        mPropertiesNormal = normal;
        mPropertiesSelected = selected;

        return this;
    }

    @Override
    public ViewSelectConfig configImageView(PropertiesIniter<ImageViewProperties> initer)
    {
        final ImageViewProperties normal = mPropertiesNormal instanceof ImageViewProperties ?
                (ImageViewProperties) mPropertiesNormal : FViewProperties.ofImageView();

        final ImageViewProperties selected = mPropertiesSelected instanceof ImageViewProperties ?
                (ImageViewProperties) mPropertiesSelected : FViewProperties.ofImageView();

        initer.init(normal, selected);
        mPropertiesNormal = normal;
        mPropertiesSelected = selected;

        return this;
    }

    @Override
    public void setSelected(boolean selected, boolean invokeViewSelected, View view)
    {
        if (view == null)
            return;

        if (selected)
        {
            if (mPropertiesSelected != null)
                mPropertiesSelected.invoke(view);
        } else
        {
            if (mPropertiesNormal != null)
                mPropertiesNormal.invoke(view);
        }

        if (invokeViewSelected)
            view.setSelected(selected);
    }
}
