package com.androidmvp.model.network.request.listener;

import com.androidmvp.model.network.response.Response;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public interface RequestListener {
    void onComplete(Response response);
}
