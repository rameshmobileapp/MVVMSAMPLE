package com.example.mvvmsample;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmsample.data.DataManager;
import com.example.mvvmsample.di.PerActivity;
import com.example.mvvmsample.ui.movie.MovieViewModel;
import com.example.mvvmsample.ui.moviedetails.MovieDetailsModel;
import com.example.mvvmsample.utils.NetworkUtils;
import com.example.mvvmsample.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


@PerActivity
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;
    private final CompositeDisposable compositeDisposable;
    private final NetworkUtils networkUtils;

    @Inject
    public ViewModelProviderFactory(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable,
            NetworkUtils networkUtils) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = compositeDisposable;
        this.networkUtils = networkUtils;

    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
      if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(dataManager, schedulerProvider, compositeDisposable, networkUtils);
        } else if (modelClass.isAssignableFrom(MovieDetailsModel.class)) {
            return (T) new MovieDetailsModel(dataManager, schedulerProvider, compositeDisposable, networkUtils);
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
        }
    }
}