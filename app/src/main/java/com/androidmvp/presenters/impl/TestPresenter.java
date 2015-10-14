package com.androidmvp.presenters.impl;

import com.androidmvp.ui.callbacks.CompleteCallbackUI;
import com.androidmvp.model.facade.impl.CounterApplication;
import com.androidmvp.model.facade.impl.CounterDataManager;
import com.androidmvp.presenters.BasePresenter;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public class TestPresenter extends BasePresenter<CounterApplication> {

    public TestPresenter(CounterApplication app) {
        super(app);
    }

    public void doSomeLong(final CompleteCallbackUI callback) {
        CounterDataManager dataManager = getApplication().getDataManager();
        dataManager.startCounter(callback);
    }
}
