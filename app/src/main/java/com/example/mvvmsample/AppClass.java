package com.example.mvvmsample;

import android.app.Application;

import com.example.mvvmsample.data.DataManager;
import com.example.mvvmsample.di.component.ApplicationComponent;
import com.example.mvvmsample.di.component.DaggerApplicationComponent;
import com.example.mvvmsample.di.module.ApplicationModule;

import javax.inject.Inject;

public class AppClass extends Application {

    @Inject
    DataManager mDataManager;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

}
