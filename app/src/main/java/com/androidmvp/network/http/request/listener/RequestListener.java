package com.androidmvp.network.http.request.listener;

import com.androidmvp.network.response.Response;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public interface RequestListener {
    void onComplete(Response response);
}
