package com.androidmvp.ui.activities.impl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidmvp.ui.callbacks.impl.CounterCallback;
import com.androidmvp.ui.callbacks.results.impl.CounterCallbackResult;
import com.androidmvp.model.facade.impl.CounterApplication;
import com.androidmvp.presenters.impl.TestPresenter;
import com.androidmvp.ui.activities.BaseActivity;
import com.zatsepin.androidmvc.R;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public class TestActivity extends BaseActivity<TestPresenter> {
    TextView counterView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().doSomeLong(new CounterCallback(TestActivity.this));
            }
        });
        counterView = (TextView)findViewById(R.id.counterValue);
    }

    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter((CounterApplication)getApplication());
    }

    public void updateCounter(CounterCallbackResult result) {
        counterView.setText("" + result.getCounter());
    }
}
