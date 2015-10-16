package com.androidmvp.model.network;

import android.support.annotation.NonNull;

import com.androidmvp.model.network.request.Request;
import com.androidmvp.model.network.response.Response;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public interface HttpClient {
    Response execute(@NonNull Request request) throws ServerException;
    void setReadTimeout(int timeout);
    void setConnectionTimeout(int timeout);
}
