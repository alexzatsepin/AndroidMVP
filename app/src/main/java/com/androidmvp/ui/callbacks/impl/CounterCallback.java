package com.androidmvp.ui.callbacks.impl;

import com.androidmvp.ui.callbacks.BaseActivityUICallback;
import com.androidmvp.ui.callbacks.results.impl.CounterCallbackResult;
import com.androidmvp.ui.activities.impl.TestActivity;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public class CounterCallback extends BaseActivityUICallback<TestActivity, CounterCallbackResult> {


    public CounterCallback(TestActivity activity) {
        super(activity);
    }

    @Override
    protected void onComplete(TestActivity activity, CounterCallbackResult result) {
        activity.updateCounter(result);
    }
}
