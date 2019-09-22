package com.example.mvvmsample.data.local.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mvvmsample.di.ApplicationContext;
import com.example.mvvmsample.di.PreferenceInfo;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {


    private final SharedPreferences mPrefs;
    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public Long getCurrentUserId() {
        return null;
    }

    @Override
    public void setCurrentUserId(Long userId) {

    }

    @Override
    public String getCurrentUserPassword() {
        return null;
    }

    @Override
    public String setUserToken(String tkoen) {
        return null;
    }

    @Override
    public void getUserToken() {

    }

    @Override
    public void setCurrentUserPassword(String password) {

    }
}
