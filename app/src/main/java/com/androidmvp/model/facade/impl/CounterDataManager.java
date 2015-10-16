package com.androidmvp.model.facade.impl;

import com.androidmvp.model.network.ClientFactory;
import com.androidmvp.model.facade.NetworkManager;
import com.androidmvp.model.network.request.impl.AndroidDeveloperRequest;
import com.androidmvp.model.network.request.listener.RequestListener;
import com.androidmvp.model.network.response.Response;
import com.androidmvp.ui.callbacks.CompleteCallbackUI;
import com.androidmvp.ui.callbacks.results.impl.AndroidDeveloperCallbackResult;
import com.androidmvp.ui.callbacks.results.impl.CounterCallbackResult;
import com.androidmvp.model.facade.CommandExecutor;
import com.androidmvp.model.commands.impl.CounterCommand;
import com.androidmvp.model.commands.listeners.CounterListener;
import com.androidmvp.model.facade.BaseDataManager;

import java.util.concurrent.Executors;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public class CounterDataManager extends BaseDataManager {

    public CounterDataManager() {
        super(new CommandExecutor(Executors.newSingleThreadExecutor()),
                new NetworkManager(ClientFactory.createUrlConnectionClient(10000, 10000),
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
                removeUiCallback(callbackUI);
            }
        }));
    }

    public void loadAndroidDeveloper(final CompleteCallbackUI callbackUI) {
        addUiCallback(callbackUI);
        execute(new AndroidDeveloperRequest(), new RequestListener() {
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
