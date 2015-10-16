package com.androidmvp.model.facade;

import com.androidmvp.model.commands.Command;
import com.androidmvp.model.network.request.Request;
import com.androidmvp.model.network.request.listener.RequestListener;
import com.androidmvp.ui.callbacks.CompleteCallbackUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public class BaseDataManager implements DataManager {

    private final List<CompleteCallbackUI> uiCallbacks = new ArrayList<>();

    private final CommandExecutor commandExecutor;
    private final NetworkManager networkManager;

    public BaseDataManager(CommandExecutor commandExecutor, NetworkManager networkManager) {
        this.commandExecutor = commandExecutor;
        this.networkManager = networkManager;
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

    protected void execute(final Request request, final RequestListener listener) {
        networkManager.execute(request, listener);
    }

    protected void executeAsync(final Command command) {
        commandExecutor.executeAsync(command);
    }
}
