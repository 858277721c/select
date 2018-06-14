package com.fanwe.lib.select.config;

import android.view.View;

import com.fanwe.lib.select.properties.FViewProperties;
import com.fanwe.lib.select.properties.TextViewProperties;

class SimpleTextViewConfig extends BaseSelectConfig<TextViewProperties> implements TextViewSelectConfig
{
    public SimpleTextViewConfig(View view)
    {
        super(view);
    }

    @Override
    protected TextViewProperties newProperties()
    {
        return FViewProperties.ofTextView();
    }
}
