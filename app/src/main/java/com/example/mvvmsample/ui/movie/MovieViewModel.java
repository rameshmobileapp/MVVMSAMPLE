package com.example.mvvmsample.ui.movie;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmsample.BuildConfig;
import com.example.mvvmsample.data.DataManager;
import com.example.mvvmsample.data.model.api.movielist.MovieList;
import com.example.mvvmsample.data.remote.ApiResponse;
import com.example.mvvmsample.ui.base.BaseViewModel;
import com.example.mvvmsample.utils.NetworkUtils;
import com.example.mvvmsample.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MovieViewModel extends BaseViewModel {

    private static final String TAG = "MovieViewModel";

    private MutableLiveData<List<MovieList>> mutableLiveData;
    private MutableLiveData<ApiResponse> apiResponse;

    public MovieViewModel(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, NetworkUtils networkUtils) {
        super(dataManager, schedulerProvider, compositeDisposable, networkUtils);

        if (mutableLiveData == null)
            mutableLiveData = new MutableLiveData<>();
        if (apiResponse == null)
            apiResponse = new MutableLiveData<>();
    }

    void getMovieListFromServer() {
        try {
            apiResponse.setValue(ApiResponse.message(null));
            if (!getNetworkUtils().isNetworkConnected())
                apiResponse.setValue(ApiResponse.message("No internet connection"));
            else {
                apiResponse.setValue(ApiResponse.loading(null));
                getCompositeDisposable().add(
                        getDataManager().getMovieListDetails(
                                BuildConfig.API_KEY,
                                "2019-01-01",
                                "2019-03-31")
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(movieListResponse -> {
                                    if (movieListResponse.getResults().size() > 0)
                                        mutableLiveData.setValue(movieListResponse.getResults());
                                    apiResponse.setValue(ApiResponse.success(null));
                                }, throwable -> {
                                    apiResponse.setValue(ApiResponse.error(throwable, null));
                                }));
            }
        } catch (Exception ex) {
            apiResponse.setValue(ApiResponse.error(ex, null));
        }
    }

    public MutableLiveData<List<MovieList>> getMutableLiveData() {
        return mutableLiveData;
    }

    public MutableLiveData<ApiResponse> getIsProcess() {
        return apiResponse;
    }


}
