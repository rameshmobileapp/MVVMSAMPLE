package com.example.mvvmsample.data.local.pref;

public interface PreferencesHelper {


    void setCurrentUserId(Long userId);

    Long getCurrentUserId();

    void setCurrentUserPassword(String password);

    String getCurrentUserPassword();

    String setUserToken(String tkoen);

    void getUserToken();
}
