package com.androidmvp.ui.callbacks;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.androidmvp.ui.callbacks.results.CallbackResult;


/**
 * Created by Zatsepin on 15.10.2015.
 */
public abstract class CompleteCallbackUI<Target, Result extends CallbackResult> implements Detachable<Target> {

    @Nullable
    protected Target target;
    @NonNull
    private final Handler handler;

    @MainThread
    protected CompleteCallbackUI(@Nullable Target target) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new AssertionError("CompleteCallbackUI must be initialized in UI thread");
        }
        this.target = target;
        this.handler = new Handler();
    }

    public void complete(final Result result) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (target != null) {
                    onComplete(target, result);
                }
            }
        });
    }

    protected void setTarget(@Nullable Target target) {
        this.target = target;
    }

    @Nullable
    protected Target getTarget() {
        return target;
    }

    @MainThread
    protected abstract void onComplete(Target target, Result result);
}
