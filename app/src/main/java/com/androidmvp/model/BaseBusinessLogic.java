package com.androidmvp.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.androidmvp.model.commands.Command;
import com.androidmvp.network.Network;
import com.androidmvp.network.http.request.Request;
import com.androidmvp.network.http.request.listener.RequestListener;
import com.androidmvp.ui.callbacks.CompleteCallbackUI;

import net.jcip.annotations.GuardedBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public class BaseBusinessLogic implements BusinessLogic {

    @GuardedBy("uiCallbacks")
    private final List<CompleteCallbackUI> uiCallbacks = new ArrayList<>();
    @Nullable
    private CommandExecutor asyncCommandExecutor;
    @Nullable
    private CommandExecutor syncCommandExecutor;
    @NonNull
    private final Network network;

    public BaseBusinessLogic(@NonNull Network network) {
        this.network = network;
    }

    public void setSyncCommandExecutor(@NonNull CommandExecutor syncCommandExecutor) {
        this.syncCommandExecutor = syncCommandExecutor;
    }

    public void setAsyncCommandExecutor(@NonNull CommandExecutor asyncCommandExecutor) {
        this.asyncCommandExecutor = asyncCommandExecutor;
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

    protected void executeNetworkRequest(@NonNull final Request request, @Nullable final RequestListener listener) {
        network.execute(request, listener);
    }

    protected void executeAsync(final Command command) {
        asyncCommandExecutor.execute(command);
    }

    protected void executeSync(Command command) {
        syncCommandExecutor.execute(command);
    }

}
