package com.androidmvp.callbacks;

import android.app.Activity;
import android.support.annotation.MainThread;

import com.androidmvp.callbacks.results.CallbackResult;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public abstract class BaseActivityUICallback<T extends Activity, R extends CallbackResult> implements Detachable<T> {

    private volatile T activity;

    public BaseActivityUICallback(T activity) {
        this.activity = activity;
    }

    @Override
    public void onAttach(T target) {
        activity = target;
    }

    @Override
    public void onDetach() {
        activity = null;
    }

    public void complete(final R result) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    onComplete(activity, result);
                }
            });
        }
    }

    @MainThread
    protected abstract void onComplete(T activity, R result);
}
