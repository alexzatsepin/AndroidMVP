package com.androidmvp.ui.callbacks.results.impl;

import com.androidmvp.ui.callbacks.results.CallbackResult;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public class CounterCallbackResult implements CallbackResult {

    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
