package com.androidmvp.network;

import android.support.annotation.NonNull;

import com.androidmvp.network.http.request.Request;
import com.androidmvp.network.response.Response;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public interface Client {
    Response execute(@NonNull Request request) throws ServerException;
}
