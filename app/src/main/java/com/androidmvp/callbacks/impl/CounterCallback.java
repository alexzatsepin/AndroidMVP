package com.androidmvp.callbacks.impl;

import com.androidmvp.callbacks.BaseActivityUICallback;
import com.androidmvp.callbacks.results.impl.CounterCallbackResult;
import com.androidmvp.views.activities.TestActivity;

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
