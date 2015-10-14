package com.androidmvp.ui.callbacks;

import android.app.Activity;

import com.androidmvp.ui.callbacks.results.CallbackResult;
import com.androidmvp.util.LogUtils;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public abstract class BaseActivityUICallback<T extends Activity, R extends CallbackResult> extends CompleteCallbackUI<T,R> {
    private static final String TAG = BaseActivityUICallback.class.getSimpleName();

    public BaseActivityUICallback(T activity) {
        super(activity);
    }

    @Override
    public void onAttach(T activity) {
        LogUtils.d(TAG, "Callback " + this + "' is attached to " + activity);
        setTarget(activity);
    }

    @Override
    public void onDetach() {
        LogUtils.d(TAG, "Callback " + this + "' is detached from " + getTarget());
        setTarget(null);
    }
}
