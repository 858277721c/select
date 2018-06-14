package com.fanwe.lib.select.config;

import android.view.View;
import android.view.ViewTreeObserver;

import com.fanwe.lib.select.properties.ViewProperties;

import java.lang.ref.WeakReference;

abstract class BaseSelectConfig<T extends ViewProperties> implements SelectConfig<T>
{
    private final WeakReference<View> mView;

    private T mPropertiesNormal;
    private T mPropertiesSelected;
    private boolean mSelected;

    private final InternalOnPreDrawListener mOnPreDrawListener = new InternalOnPreDrawListener();

    public BaseSelectConfig(View view)
    {
        if (view == null)
            throw new NullPointerException("view is null");

        mView = new WeakReference<>(view);
        setAutoMode(true);
    }

    private View getView()
    {
        return mView == null ? null : mView.get();
    }

    @Override
    public SelectConfig setAutoMode(boolean autoMode)
    {
        if (autoMode)
        {
            mOnPreDrawListener.register();
            updateStateIfNeed();
        } else
        {
            mOnPreDrawListener.unregister();
        }

        return this;
    }

    @Override
    public SelectConfig init(PropertiesIniter<T> initer)
    {
        if (mPropertiesNormal == null)
            mPropertiesNormal = newProperties();

        if (mPropertiesSelected == null)
            mPropertiesSelected = newProperties();

        initer.init(mPropertiesNormal, mPropertiesSelected);
        return this;
    }

    protected abstract T newProperties();

    @Override
    public SelectConfig clear()
    {
        mPropertiesNormal = null;
        mPropertiesSelected = null;
        return this;
    }

    @Override
    public SelectConfig setSelected(boolean selected)
    {
        updateViewState(selected, getView());
        return this;
    }

    private void updateViewState(boolean selected, View view)
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
    }

    private void updateStateIfNeed()
    {
        final View view = getView();
        if (view == null)
            return;

        final boolean selected = view.isSelected();
        if (mSelected != selected)
        {
            mSelected = selected;
            view.post(new Runnable()
            {
                @Override
                public void run()
                {
                    updateViewState(selected, view);
                }
            });
        }
    }

    private final class InternalOnPreDrawListener implements ViewTreeObserver.OnPreDrawListener
    {
        public void register()
        {
            final View view = getView();
            if (view == null)
                return;

            final ViewTreeObserver observer = view.getViewTreeObserver();
            if (!observer.isAlive())
                return;

            observer.removeOnPreDrawListener(this);
            observer.addOnPreDrawListener(this);
        }

        public void unregister()
        {
            final View view = getView();
            if (view == null)
                return;

            final ViewTreeObserver observer = view.getViewTreeObserver();
            if (!observer.isAlive())
                return;

            observer.removeOnPreDrawListener(this);
        }

        @Override
        public boolean onPreDraw()
        {
            updateStateIfNeed();
            return true;
        }
    }
}
