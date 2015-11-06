package com.androidmvp.network.http.request.impl;

import com.androidmvp.network.http.request.Request;

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
