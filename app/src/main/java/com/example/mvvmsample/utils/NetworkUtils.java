package com.example.mvvmsample.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.mvvmsample.di.ApplicationContext;

import javax.inject.Inject;

public class NetworkUtils {

    private Context mContext;

    @Inject
    public NetworkUtils(@ApplicationContext Context context) {
        mContext = context;
    }

    public  boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        }
        return false;
    }
}
