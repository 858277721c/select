package com.fanwe.lib.select.properties;

import android.view.View;

import com.fanwe.lib.select.invoker.ImageResIdInvoker;

class SimpleImageViewProperties extends SimpleViewProperties implements ImageViewProperties
{
    private Integer mImageResId;

    @Override
    public ImageViewProperties setImageResId(Integer value)
    {
        mImageResId = value;
        return this;
    }

    @Override
    public ImageViewProperties reset()
    {
        super.reset();
        mImageResId = null;
        return this;
    }

    @Override
    public void invoke(View view)
    {
        super.invoke(view);

        if (view != null)
            new ImageResIdInvoker().invoke(view, mImageResId);
    }

    @Override
    public ImageViewProperties clone()
    {
        return (ImageViewProperties) super.clone();
    }
}
