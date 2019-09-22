
package com.example.mvvmsample.di.component;

import android.app.Application;
import android.content.Context;

import com.example.mvvmsample.AppClass;
import com.example.mvvmsample.data.DataManager;
import com.example.mvvmsample.di.ApplicationContext;
import com.example.mvvmsample.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AppClass app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}