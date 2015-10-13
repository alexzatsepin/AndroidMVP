package com.androidmvp.views.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.androidmvp.presenters.Presenter;
import com.androidmvp.presenters.PresenterAccessor;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public abstract class BaseActivity<P extends Presenter> extends Activity implements PresenterAccessor {

    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RetainFragment reFragment = (RetainFragment)getFragmentManager().findFragmentByTag(RetainFragment.TAG);
        if (reFragment == null) {
            presenter = createPresenter();
            reFragment = new RetainFragment();
            getFragmentManager().beginTransaction()
                    .add(reFragment, RetainFragment.TAG)
                    .commit();

        }else {
            //noinspection unchecked
            presenter = (P)reFragment.getPresenter();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected abstract P createPresenter();

    @Override
    @NonNull
    public P getPresenter() {
        return presenter;
    }
}
