
package com.example.mvvmsample.di.component;


import com.example.mvvmsample.di.PerActivity;
import com.example.mvvmsample.di.module.ActivityModule;
import com.example.mvvmsample.ui.movie.MovieActivity;
import com.example.mvvmsample.ui.moviedetails.MovieDetailsActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {


    void inject(MovieActivity activity);

    void inject(MovieDetailsActivity activity);
}
