package com.androidmvp.presenters.impl;

import com.androidmvp.ui.callbacks.CompleteCallbackUI;
import com.androidmvp.model.impl.CounterBusinessLogic;
import com.androidmvp.presenters.BasePresenter;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public class TestPresenter extends BasePresenter<CounterBusinessLogic> {

    public TestPresenter(CounterBusinessLogic logic) {
        super(logic);
    }

    public void doSomeLong(final CompleteCallbackUI callback) {
        getBusinessLogic().startCounter(callback);
    }

    public void loadAndroidPage(final CompleteCallbackUI callbackUI) {
        getBusinessLogic().loadAndroidDeveloper(callbackUI);
    }
}
