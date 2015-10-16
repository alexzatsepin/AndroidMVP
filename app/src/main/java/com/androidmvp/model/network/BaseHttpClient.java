package com.androidmvp.model.network;

import android.nfc.Tag;
import android.support.annotation.NonNull;

import com.androidmvp.model.network.request.Request;
import com.androidmvp.model.network.response.Response;

import java.io.IOException;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public abstract class BaseHttpClient implements HttpClient {

    @Override
    public Response execute(@NonNull Request request) throws ServerException{
        return doExecute(request);
    }

    protected abstract Response doExecute(Request request) throws ServerException;

    protected abstract String getUserAgent();


}
