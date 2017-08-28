package com.fanwe.library.select.view;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2017/8/28.
 */

public class SDSelectDataView<T> extends SDSelectView
{
    public SDSelectDataView(Context context)
    {
        super(context);
    }

    public SDSelectDataView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public SDSelectDataView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    private T mData;

    public T getData()
    {
        return mData;
    }

    public void setData(T data)
    {
        mData = data;
    }
}
