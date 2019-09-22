
package com.example.mvvmsample.di.component;


import com.example.mvvmsample.di.PerService;
import com.example.mvvmsample.di.module.ServiceModule;
import com.example.mvvmsample.service.SyncService;

import dagger.Component;


@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}
