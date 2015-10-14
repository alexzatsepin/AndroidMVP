package com.androidmvp.presenters;

import com.androidmvp.ui.callbacks.Detachable;
import com.androidmvp.model.facade.BaseApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public abstract class BasePresenter<A extends BaseApplication> implements Presenter {
    private List<Detachable> callbacks = new ArrayList<>();

    private final A application;

    protected BasePresenter(A application) {
        this.application = application;
    }

    public A getApplication() {
        return application;
    }

    @Override
    public List<Detachable> getCallbacks() {
        return callbacks;
    }
}
