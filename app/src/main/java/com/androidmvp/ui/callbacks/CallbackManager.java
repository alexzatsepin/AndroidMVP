package com.androidmvp.ui.callbacks;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.androidmvp.model.facade.BaseApplication;
import com.androidmvp.model.facade.BaseDataManager;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public class CallbackManager extends Fragment {
    public static final String TAG = "retain_fragment";
    private static final String LOG_TAG = CallbackManager.class.getName();
/*
    private Presenter presenter;*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
/*        if (context instanceof PresenterAccessor) {
            PresenterAccessor accessor = (PresenterAccessor) context;
            if (presenter == null) {
                presenter = accessor.getPresenter();
            }
            for (Detachable callback : presenter.getCallbacks()) {
                //noinspection unchecked
                callback.onAttach(context);
            }
        } else {
            throw new AssertionError("The '" + context + "' must implement the PresenterAccessor interface");
        }*/
        BaseDataManager dataManager = getBaseDataManager(context);
        for (Detachable callback: dataManager.getUiCallbacks()) {
            //FIXME: potential cce exception
            callback.onAttach(context);
        }
    }

    private BaseDataManager getBaseDataManager(Activity context) {
        BaseApplication<BaseDataManager> app = (BaseApplication<BaseDataManager>)context.getApplication();
        return app.getDataManager();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        BaseDataManager dataManager = getBaseDataManager(getActivity());
        for (Detachable callback : dataManager.getUiCallbacks()) {
            callback.onDetach();
        }
    }

/*    @Override
    @NonNull
    public Presenter getPresenter() {
        return presenter;
    }*/
}
