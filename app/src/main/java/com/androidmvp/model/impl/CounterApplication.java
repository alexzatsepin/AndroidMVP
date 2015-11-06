package com.androidmvp.model.impl;

import com.androidmvp.model.BaseApplication;
import com.androidmvp.network.ClientFactory;
import com.androidmvp.network.Network;

import java.util.concurrent.Executors;

/**
 * Created by Zatsepin on 15.10.2015.
 */
public class CounterApplication extends BaseApplication<CounterBusinessLogic> {

    @Override
    protected CounterBusinessLogic createBusinessLogic() {
        Network network = new Network(ClientFactory.createUrlConnectionClient(10000, 10000),
                Executors.newSingleThreadExecutor());
        CounterBusinessLogic logic = new CounterBusinessLogic(network);
        logic.setAsyncCommandExecutor(new AsyncCommandExecutor(Executors.newSingleThreadExecutor()));
        return logic;
    }
}
