package com.androidmvp.presenters.impl;

import com.androidmvp.callbacks.BaseActivityUICallback;
import com.androidmvp.callbacks.results.impl.CounterCallbackResult;
import com.androidmvp.presenters.BasePresenter;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public class TestPresenter extends BasePresenter {
    private int counter;

    public void doSomeLong(final BaseActivityUICallback callback) {
        getCallbacks().add(callback);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        counter++;
                        CounterCallbackResult result = new CounterCallbackResult();
                        result.setCounter(counter);
                        callback.complete(result);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
