package com.androidmvp.callbacks;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public interface Detachable<T> {
    void onAttach(T target);
    void onDetach();
}
