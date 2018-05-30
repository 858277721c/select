package com.fanwe.lib.select.invoker;

import android.view.View;

public interface PropertyInvoker<T>
{
    void invoke(View view, T value);
}
