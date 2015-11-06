package com.androidmvp.presenters;

import android.support.annotation.NonNull;

import com.androidmvp.model.BusinessLogic;
import com.androidmvp.ui.callbacks.Detachable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public abstract class BasePresenter<A extends BusinessLogic> implements Presenter {
    private List<Detachable> callbacks = new ArrayList<>();

    @NonNull
    private final A logic;

    protected BasePresenter(@NonNull A logic) {
        this.logic = logic;
    }

    @NonNull
    public A getBusinessLogic() {
        return logic;
    }

    @Override
    public List<Detachable> getCallbacks() {
        return callbacks;
    }
}
