package com.example.htetaunglwin.attractionsinmyanmar.utils;

import com.google.gson.Gson;

/**
 * Created by Htet Aung Lwin on 09-Jul-16.
 */
public class CommonInstances {

    private static Gson gson = new Gson();

    public static Gson getGsonInstance() {
        return gson;
    }
}
