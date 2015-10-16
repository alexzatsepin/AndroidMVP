package com.androidmvp.model.network;

import com.androidmvp.model.network.impl.UrlConnectionClient;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public class ClientFactory {
    public static  HttpClient createUrlConnectionClient(int readTimeout, int connectionTimeout) {
        return new UrlConnectionClient(readTimeout, connectionTimeout);
    }
}
