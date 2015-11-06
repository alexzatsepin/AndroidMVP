package com.androidmvp.ui.activities.impl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidmvp.model.impl.CounterBusinessLogic;
import com.androidmvp.ui.callbacks.impl.AndroidDeveloperCallback;
import com.androidmvp.ui.callbacks.impl.CounterCallback;
import com.androidmvp.ui.callbacks.results.impl.CounterCallbackResult;
import com.androidmvp.model.impl.CounterApplication;
import com.androidmvp.presenters.impl.TestPresenter;
import com.androidmvp.ui.activities.BaseActivity;
import com.zatsepin.androidmvc.R;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public class TestActivity extends BaseActivity<TestPresenter> {
    TextView counterView;
    TextView pageView;

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
        Button button = (Button)findViewById(R.id.load_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().loadAndroidPage(new AndroidDeveloperCallback(TestActivity.this));
            }
        });
        pageView = (TextView)findViewById(R.id.page_text);
    }

    @Override
    protected TestPresenter createPresenter() {
        CounterBusinessLogic businessLogic = ((CounterApplication)getApplication()).getBusinessLogic();
        return new TestPresenter(businessLogic);
    }

    public void updateCounter(CounterCallbackResult result) {
        counterView.setText("" + result.getCounter());
    }

    public void showAndroidPage(String page) {
        pageView.setText(page);
    }
}
