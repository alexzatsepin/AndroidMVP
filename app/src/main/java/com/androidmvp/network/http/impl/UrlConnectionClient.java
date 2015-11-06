package com.androidmvp.network.http.impl;

import com.androidmvp.network.http.BaseClient;
import com.androidmvp.network.ServerException;
import com.androidmvp.network.http.request.Request;
import com.androidmvp.network.response.BaseResponse;
import com.androidmvp.network.response.Response;
import com.androidmvp.util.LogUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * Created by Zatsepin on 17.10.2015.
 */
public class UrlConnectionClient extends BaseClient {
    private static final String TAG = UrlConnectionClient.class.getSimpleName();
    private int readTimeout;
    private int connectionTimeout;

    public UrlConnectionClient(int readTimeout, int connectionTimeout) {
        this.readTimeout = readTimeout;
        this.connectionTimeout = connectionTimeout;
    }

    @Override
    protected Response doExecute(Request request) throws ServerException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        BaseResponse response = new BaseResponse();
        try {
            URL url = new URL(request.getUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(readTimeout);
            conn.setConnectTimeout(connectionTimeout);
            conn.setRequestMethod(request.getMethod().name());
            if (request.getMethod() == Request.METHOD.POST) {
                conn.setDoOutput(true);
            }
            conn.connect();
            int responseCode = conn.getResponseCode();
            LogUtils.d(TAG, "url = " + request.getUrl() + " responseCode = " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                if ("gzip".equals(conn.getContentEncoding())) {
                    is = new GZIPInputStream(conn.getInputStream());
                } else {
                    is = conn.getInputStream();
                }
                String bodyResponse = readIt(is);
                response.setBody(bodyResponse);
            }
            return response;
        } catch (IOException ioe) {
            throw new ServerException(ioe);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                LogUtils.e(TAG, "Cannot close input stream for " + request.getUrl());
            }
        }
    }

    private String readIt(InputStream stream) throws IOException {
        StringBuilder builder = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[2024];
        int length;
        while ((length = reader.read(buffer)) != -1) {
            builder.append(buffer, 0, length);
        }
        return builder.toString();
    }

    @Override
    protected String getUserAgent() {
        return null;
    }

}
