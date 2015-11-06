package com.androidmvp.model;

import android.app.Application;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public abstract class BaseApplication<T extends BusinessLogic> extends Application {

    private T businessLogic;

    @Override
    public void onCreate() {
        super.onCreate();
        businessLogic = createBusinessLogic();
    }

    protected abstract T createBusinessLogic();

    public T getBusinessLogic() {
        return businessLogic;
    }

}
