package com.androidmvp.model.network.request.impl;

import com.androidmvp.model.network.request.Request;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public class AndroidDeveloperRequest implements Request {
    @Override
    public String getUrl() {
        return "http://stackoverflow.com/questions/4126815/android-logging-levels";
    }

    @Override
    public METHOD getMethod() {
        return METHOD.GET;
    }

}
