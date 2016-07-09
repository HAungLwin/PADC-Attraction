package com.example.htetaunglwin.attractionsinmyanmar;

import android.app.Application;
import android.content.Context;

/**
 * Created by Htet Aung Lwin on 08-Jul-16.
 */
public class AttractionsinMyanmar extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
