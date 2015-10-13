package com.androidmvp.views.activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.androidmvp.presenters.Presenter;
import com.androidmvp.presenters.PresenterAccessor;
import com.androidmvp.callbacks.Detachable;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public class RetainFragment extends Fragment implements PresenterAccessor {
    static final String LOG_TAG = RetainFragment.class.getName();
    static final String TAG = "retain_fragment";

    private Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof PresenterAccessor) {
            PresenterAccessor accessor = (PresenterAccessor) context;
            if (presenter == null) {
                presenter = accessor.getPresenter();
            }
            for (Detachable callback : presenter.getCallbacks()) {
                //noinspection unchecked
                callback.onAttach(context);
            }
        } else {
            throw new AssertionError("The '" + context + "' must implement the PresenterAccessor interface");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        for (Detachable callback : presenter.getCallbacks()) {
            callback.onDetach();
        }
    }

    @Override
    @NonNull
    public Presenter getPresenter() {
        return presenter;
    }
}
