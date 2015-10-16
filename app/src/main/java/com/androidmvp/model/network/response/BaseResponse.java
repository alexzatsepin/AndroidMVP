package com.androidmvp.model.network.response;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public class BaseResponse implements Response {
    private String body;

    @Override
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String getBody() {
        return body;
    }
}
