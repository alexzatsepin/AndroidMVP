package com.androidmvp.model.network.request;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public interface Request {
    String getUrl();

    METHOD getMethod();

    enum METHOD {
        GET, POST, DELETE, PUT;
    }
}
