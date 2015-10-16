package com.androidmvp.ui.callbacks.impl;

import android.support.annotation.NonNull;

import com.androidmvp.ui.activities.impl.TestActivity;
import com.androidmvp.ui.callbacks.BaseActivityUICallback;
import com.androidmvp.ui.callbacks.results.impl.AndroidDeveloperCallbackResult;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public class AndroidDeveloperCallback extends BaseActivityUICallback<TestActivity, AndroidDeveloperCallbackResult> {

    public AndroidDeveloperCallback(TestActivity activity) {
        super(activity);
    }

    @Override
    protected void onComplete(@NonNull TestActivity testActivity, AndroidDeveloperCallbackResult result) {
        testActivity.showAndroidPage(result.getPage());
    }

}
