package com.androidmvp.presenters;

import com.androidmvp.callbacks.Detachable;

import java.util.List;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public interface Presenter {
    List<Detachable> getCallbacks();
}
