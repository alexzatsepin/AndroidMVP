package com.androidmvp.model.facade;

import android.app.Application;

import com.androidmvp.model.facade.DataManager;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public abstract class BaseApplication<T extends DataManager> extends Application {

    private T dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        dataManager = createDataManager();
    }

    protected abstract T createDataManager();

    public T getDataManager() {
        return dataManager;
    }

}
