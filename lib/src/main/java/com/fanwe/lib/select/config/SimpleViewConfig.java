package com.fanwe.lib.select.config;

import android.view.View;

import com.fanwe.lib.select.properties.FViewProperties;
import com.fanwe.lib.select.properties.ViewProperties;

class SimpleViewConfig extends BaseSelectConfig<ViewProperties> implements ViewSelectConfig
{
    public SimpleViewConfig(View view)
    {
        super(view);
    }

    @Override
    protected ViewProperties newProperties()
    {
        return FViewProperties.ofView();
    }
}
