package com.androidmvp.network;

import com.androidmvp.network.http.impl.UrlConnectionClient;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public class ClientFactory {
    public static Client createUrlConnectionClient(int readTimeout, int connectionTimeout) {
        return new UrlConnectionClient(readTimeout, connectionTimeout);
    }
}
