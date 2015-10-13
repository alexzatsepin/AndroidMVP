package com.androidmvp.presenters;

import android.support.annotation.NonNull;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public interface PresenterAccessor {
    @NonNull
    Presenter getPresenter();
}
