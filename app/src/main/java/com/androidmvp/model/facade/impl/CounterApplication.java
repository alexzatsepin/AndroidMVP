package com.androidmvp.model.facade.impl;

import com.androidmvp.model.facade.BaseApplication;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public class CounterApplication extends BaseApplication<CounterDataManager> {

    @Override
    protected CounterDataManager createDataManager() {
        return new CounterDataManager();
    }
}
