package com.androidmvp.model.impl;

import android.support.annotation.NonNull;

import com.androidmvp.model.CommandExecutor;
import com.androidmvp.model.commands.Command;

import java.util.concurrent.Executor;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public class AsyncCommandExecutor implements CommandExecutor {

    @NonNull
    private final Executor executor;

    public AsyncCommandExecutor(@NonNull Executor executor) {
        this.executor = executor;
    }

    @Override
    public void execute(@NonNull final Command command) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                command.execute();
            }
        });
    }
}
