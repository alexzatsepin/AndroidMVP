package com.androidmvp.model.commands.impl;

import com.androidmvp.ui.callbacks.results.impl.CounterCallbackResult;
import com.androidmvp.model.commands.Command;
import com.androidmvp.model.commands.listeners.CounterListener;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public class CounterCommand implements Command {

    private int counter;
    private final CounterListener listener;

    public CounterCommand(CounterListener listener) {
        this.listener = listener;
    }

    @Override
    public void execute() {
        while (true) {
            try {
                Thread.sleep(1000);
                counter++;
                CounterCallbackResult result = new CounterCallbackResult();
                result.setCounter(counter);
                listener.update(counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
