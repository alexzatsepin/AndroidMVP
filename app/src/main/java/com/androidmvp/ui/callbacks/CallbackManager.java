package com.androidmvp.ui.callbacks;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.androidmvp.model.BaseApplication;
import com.androidmvp.model.BaseBusinessLogic;
import com.androidmvp.model.BusinessLogic;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public class CallbackManager extends Fragment {
    public static final String TAG = "retain_fragment";
    private static final String LOG_TAG = CallbackManager.class.getName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        BaseBusinessLogic dataManager = getBusinessLogic(context);
        for (Detachable callback: dataManager.getUiCallbacks()) {
            //FIXME: potential cce exception
            callback.onAttach(context);
        }
    }

    private static BaseBusinessLogic getBusinessLogic(Activity context) {
        @SuppressWarnings("unchecked")
        BaseApplication app = (BaseApplication)context.getApplication();
        return (BaseBusinessLogic)app.getBusinessLogic();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        BaseBusinessLogic dataManager = getBusinessLogic(getActivity());
        for (Detachable callback : dataManager.getUiCallbacks()) {
            callback.onDetach();
        }
    }
}
