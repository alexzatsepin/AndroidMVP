package com.androidmvp.ui.fragments;

import android.app.Fragment;

import com.androidmvp.presenters.Presenter;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public class BaseFragment<P extends Presenter> extends Fragment {
    private P presenter;

}
