package com.androidmvp.model.impl;

import com.androidmvp.network.ClientFactory;
import com.androidmvp.network.Network;
import com.androidmvp.network.http.request.impl.AndroidDeveloperRequest;
import com.androidmvp.network.http.request.listener.RequestListener;
import com.androidmvp.network.response.Response;
import com.androidmvp.ui.callbacks.CompleteCallbackUI;
import com.androidmvp.ui.callbacks.results.impl.AndroidDeveloperCallbackResult;
import com.androidmvp.ui.callbacks.results.impl.CounterCallbackResult;
import com.androidmvp.model.commands.impl.CounterCommand;
import com.androidmvp.model.commands.listeners.CounterListener;
import com.androidmvp.model.BaseBusinessLogic;

import java.util.concurrent.Executors;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public class CounterBusinessLogic extends BaseBusinessLogic {

    public CounterBusinessLogic(Network network) {
        super(new Network(ClientFactory.createUrlConnectionClient(10000, 10000),
                        Executors.newSingleThreadExecutor()));
    }

    public void startCounter(final CompleteCallbackUI callbackUI) {
        addUiCallback(callbackUI);
        executeAsync(new CounterCommand(new CounterListener() {
            @Override
            public void update(int counter) {
                CounterCallbackResult result = new CounterCallbackResult();
                result.setCounter(counter);
                //noinspection unchecked
                callbackUI.complete(result);
            }
        }));
    }

    public void loadAndroidDeveloper(final CompleteCallbackUI callbackUI) {
        addUiCallback(callbackUI);
        executeNetworkRequest(new AndroidDeveloperRequest(), new RequestListener() {
            @Override
            public void onComplete(Response response) {
                AndroidDeveloperCallbackResult result = new AndroidDeveloperCallbackResult();
                result.setPage(response.getBody());
                //noinspection unchecked
                callbackUI.complete(result);
                removeUiCallback(callbackUI);
            }
        });
    }

}
