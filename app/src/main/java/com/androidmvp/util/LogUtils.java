package com.androidmvp.util;

import android.util.Log;

import java.util.logging.Level;

/**
 * Created by Zatsepin on 14.10.2015.
 */
public class LogUtils {
    public static void d(String tag, String message) {
        d(tag, message, null);
    }

    public static void d(String tag, String message, Throwable throwable) {
//        if (Log.isLoggable(tag, Log.DEBUG)) {
            Log.d(tag, message, throwable);
//        }
    }

    public static void e(String tag, String message) {
        e(tag, message, null);
    }

    public static void e(String tag, String message, Throwable throwable) {
//        if (Log.isLoggable(tag, Log.ERROR)) {
            Log.e(tag, message, throwable);
//        }
    }
}
