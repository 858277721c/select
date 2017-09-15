/*
 * Copyright (C) 2017 zhengjun, fanwe (http://www.fanwe.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fanwe.library.select.config;

import android.view.View;

/**
 * Created by zhengjun on 2017/9/15.
 */
public class SDSelectImageViewConfig extends SDSelectViewConfig
{
    private ImageViewImageResIdHandler mImageResIdHandler;

    SDSelectImageViewConfig(View view)
    {
        super(view);
    }

    //---------- properties start ----------

    public SDSelectImageViewConfig setImageResId(Integer normal, Integer selected)
    {
        getImageResIdHandler().setValueNormal(normal);
        getImageResIdHandler().setValueSelected(selected);
        if (!addOrRemoveHandler(getImageResIdHandler()))
        {
            mImageResIdHandler = null;
        }
        return this;
    }

    //---------- properties end ----------

    private ImageViewImageResIdHandler getImageResIdHandler()
    {
        if (mImageResIdHandler == null)
        {
            mImageResIdHandler = new ImageViewImageResIdHandler(getView());
        }
        return mImageResIdHandler;
    }
}
