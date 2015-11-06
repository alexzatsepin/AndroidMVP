package com.androidmvp.network.http;

import android.support.annotation.NonNull;

import com.androidmvp.network.Client;
import com.androidmvp.network.ServerException;
import com.androidmvp.network.http.request.Request;
import com.androidmvp.network.response.Response;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public abstract class BaseClient implements Client {

    @Override
    public Response execute(@NonNull Request request) throws ServerException {
        return doExecute(request);
    }

    protected abstract Response doExecute(Request request) throws ServerException;

    protected abstract String getUserAgent();


}
