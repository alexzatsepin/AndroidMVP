package com.androidmvp.model.facade;

import com.androidmvp.ui.callbacks.CompleteCallbackUI;
import com.androidmvp.model.commands.CommandExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public class BaseDataManager implements DataManager {

    private final List<CompleteCallbackUI> uiCallbacks = new ArrayList<>();

    private final CommandExecutor commandExecutor;

    public BaseDataManager(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }

    protected void removeUiCallback(CompleteCallbackUI callbackUI) {
        synchronized (uiCallbacks) {
            uiCallbacks.remove(callbackUI);
        }
    }

    protected void addUiCallback(CompleteCallbackUI callbackUI) {
        synchronized (uiCallbacks) {
            if (!uiCallbacks.contains(callbackUI)) {
                uiCallbacks.add(callbackUI);
            }
        }
    }

    public List<CompleteCallbackUI> getUiCallbacks() {
        return uiCallbacks;
    }
}
