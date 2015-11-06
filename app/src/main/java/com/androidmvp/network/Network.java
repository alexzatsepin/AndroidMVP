package com.androidmvp.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.androidmvp.network.http.request.Request;
import com.androidmvp.network.http.request.listener.RequestListener;
import com.androidmvp.network.response.BaseResponse;
import com.androidmvp.network.response.Response;

import java.util.concurrent.Executor;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public class Network {
    private final static String TAG = Network.class.getSimpleName();
    @NonNull
    private final Client client;
    @NonNull
    private final Executor executor;

    public Network(@NonNull Client client, @NonNull Executor requestExecutor) {
        this.client = client;
        this.executor = requestExecutor;
    }

    public void execute(@NonNull final Request request, @Nullable final RequestListener listener) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = client.execute(request);
                    if (listener != null) {
                        listener.onComplete(response);
                    }
                } catch (ServerException e) {
                    Response error = new BaseResponse();
                    error.setBody("server error = " + e.toString());
                    if (listener != null) {
                        listener.onComplete(error);
                    }
                }
            }
        });
    }
}
