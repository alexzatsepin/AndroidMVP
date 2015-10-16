package com.androidmvp.model.network;

import java.io.IOException;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public class ServerException extends IOException {

    public ServerException(String detailMessage) {
        super(detailMessage);
    }

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerException(Throwable cause) {
        super(cause);
    }
}
