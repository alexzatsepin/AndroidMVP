package com.androidmvp.model;

import android.support.annotation.NonNull;

import com.androidmvp.model.commands.Command;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public interface CommandExecutor {
    void execute(@NonNull Command command);
}
