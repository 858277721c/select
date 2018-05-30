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
package com.fanwe.lib.select;

import android.view.View;

import com.fanwe.lib.select.properties.ImageViewProperties;
import com.fanwe.lib.select.properties.TextViewProperties;
import com.fanwe.lib.select.properties.ViewProperties;

/**
 * View的状态参数配置
 */
public interface ViewSelectConfig
{
    ViewSelectConfig configView(PropertiesIniter<ViewProperties> initer);

    ViewSelectConfig configTextView(PropertiesIniter<TextViewProperties> initer);

    ViewSelectConfig configImageView(PropertiesIniter<ImageViewProperties> initer);

    ViewSelectConfig reset();

    /**
     * 设置view是否选中
     *
     * @param selected
     * @param invokeViewSelected 是否触发{@link View#setSelected(boolean)}方法
     * @param view
     */
    void setSelected(boolean selected, boolean invokeViewSelected, View view);

    interface PropertiesIniter<T extends ViewProperties>
    {
        void init(T normal, T selected);
    }
}
