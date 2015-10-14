package com.androidmvp.model.commands;

import java.util.concurrent.Executor;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public class CommandExecutor {

    private final Executor executor;

    public CommandExecutor(Executor executor) {
        this.executor = executor;
    }

    public void executeAsync(final Command command) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                command.execute();
            }
        });
    }
}
