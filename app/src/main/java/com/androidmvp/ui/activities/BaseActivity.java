package com.androidmvp.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.androidmvp.presenters.Presenter;
import com.androidmvp.presenters.PresenterAccessor;
import com.androidmvp.ui.callbacks.CallbackManager;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public abstract class BaseActivity<P extends Presenter> extends Activity implements PresenterAccessor {

    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CallbackManager reFragment = (CallbackManager)getFragmentManager().findFragmentByTag(CallbackManager.TAG);
        if (reFragment == null) {
            reFragment = new CallbackManager();
            getFragmentManager().beginTransaction()
                    .add(reFragment, CallbackManager.TAG)
                    .commit();

        }

        presenter = createPresenter();
    }

    protected abstract P createPresenter();

    @Override
    @NonNull
    public P getPresenter() {
        return presenter;
    }
}
