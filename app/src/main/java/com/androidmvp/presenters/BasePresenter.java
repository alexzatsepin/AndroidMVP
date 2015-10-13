package com.androidmvp.presenters;

import com.androidmvp.callbacks.Detachable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public abstract class BasePresenter implements Presenter {
    private List<Detachable> callbacks = new ArrayList<>();

    @Override
    public List<Detachable> getCallbacks() {
        return callbacks;
    }
}
