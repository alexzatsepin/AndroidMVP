package com.androidmvp.model.facade;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.androidmvp.model.network.HttpClient;
import com.androidmvp.model.network.ServerException;
import com.androidmvp.model.network.request.Request;
import com.androidmvp.model.network.request.listener.RequestListener;
import com.androidmvp.model.network.response.BaseResponse;
import com.androidmvp.model.network.response.Response;
import com.androidmvp.util.LogUtils;

import java.io.IOException;
import java.util.concurrent.Executor;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public class NetworkManager {
    private final static String TAG = NetworkManager.class.getSimpleName();
    @NonNull
    private final HttpClient client;
    @NonNull
    private final Executor executor;

    public NetworkManager(@NonNull HttpClient client, @NonNull Executor executor) {
        this.client = client;
        this.executor = executor;
    }

    void execute(@NonNull final Request request, @Nullable final RequestListener listener) {
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
