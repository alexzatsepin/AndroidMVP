package com.androidmvp.model.facade.impl;

import com.androidmvp.ui.callbacks.CompleteCallbackUI;
import com.androidmvp.ui.callbacks.results.impl.CounterCallbackResult;
import com.androidmvp.model.commands.CommandExecutor;
import com.androidmvp.model.commands.impl.CounterCommand;
import com.androidmvp.model.commands.listeners.CounterListener;
import com.androidmvp.model.facade.BaseDataManager;

import java.util.concurrent.Executors;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public class CounterDataManager extends BaseDataManager {

    public CounterDataManager() {
        super(new CommandExecutor(Executors.newSingleThreadExecutor()));
    }

    public void startCounter(final CompleteCallbackUI callbackUI){
        addUiCallback(callbackUI);
        getCommandExecutor().executeAsync(new CounterCommand(new CounterListener() {
            @Override
            public void update(int counter) {
                CounterCallbackResult result = new CounterCallbackResult();
                result.setCounter(counter);
                //noinspection unchecked
                callbackUI.complete(result);
            }
        }));
    }

}
