package com.fanwe.lib.select.config;

import android.view.View;

import com.fanwe.lib.select.properties.FViewProperties;
import com.fanwe.lib.select.properties.ImageViewProperties;

class SimpleImageViewConfig extends BaseSelectConfig<ImageViewProperties> implements ImageViewSelectConfig
{
    public SimpleImageViewConfig(View view)
    {
        super(view);
    }

    @Override
    protected ImageViewProperties newProperties()
    {
        return FViewProperties.ofImageView();
    }
}
