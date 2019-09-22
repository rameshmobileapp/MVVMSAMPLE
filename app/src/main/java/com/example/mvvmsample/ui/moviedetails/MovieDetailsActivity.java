package com.example.mvvmsample.ui.moviedetails;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmsample.R;
import com.example.mvvmsample.ViewModelProviderFactory;
import com.example.mvvmsample.data.remote.Status;
import com.example.mvvmsample.ui.base.BaseActivity;
import com.example.mvvmsample.utils.GlideApp;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mvvmsample.utils.AppConstant.MOVIE_ID;
import static com.example.mvvmsample.utils.CommonUtils.getRandomNumber;


public class MovieDetailsActivity extends BaseActivity implements MovieDetailsView {


    @BindView(R.id.txt_title)
    TextView txtTittle;

    @BindView(R.id.img_poster)
    ImageView imgPoster;

    @BindView(R.id.img_poster_back)
    ImageView imgBackDropPoster;

    @BindView(R.id.img_video)
    ImageView imgVideo;

    @BindView(R.id.txt_details)
    TextView txtDetails;

    @BindView(R.id.rat_rating)
    RatingBar rtbRate;

    @BindView(R.id.recy_actor)
    RecyclerView mRecyclerView;

    MovieCastAdapter movieCastAdapter;

    @Inject
    ViewModelProviderFactory factory;
    MovieDetailsModel viewModel;

    private String mMovieId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fullScreen();
        setContentView(R.layout.activity_movie_details);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        Bundle bundle = getIntent().getExtras();

        if (bundle == null)
            finish();
        else
            mMovieId = bundle.getString(MOVIE_ID, null);
        viewModel();
    }

    @OnClick(R.id.img_back)
    public void onBackPress(View view) {
        finish();
    }

    private void viewModel() {

        viewModel = ViewModelProviders.of(this, factory).get(MovieDetailsModel.class);
        viewModel.getMovieDetails(mMovieId);

        viewModel.getDetails().observe(this, response -> {
            try {

                rtbRate.setRating(getRandomNumber());
                txtDetails.setText(response.getOverview());
                txtTittle.setText(response.getOriginalTitle());

                GlideApp.with(MovieDetailsActivity.this)
                        .load("http://image.tmdb.org/t/p/original" + response.getBackdropPath()) // Remote URL of image.
                        .into(imgPoster); //ImageView to set.

                GlideApp.with(MovieDetailsActivity.this)
                        .load("http://image.tmdb.org/t/p/original" + response.getPosterPath()) // Remote URL of image.
                        .into(imgBackDropPoster); //ImageView to set.

                GlideApp.with(MovieDetailsActivity.this)
                        .load("http://image.tmdb.org/t/p/original" + response.getPosterPath()) // Remote URL of image.
                        .into(imgVideo);
            } catch (NullPointerException ex) {
                ex.getMessage();
            }
        });

        viewModel.getMovieCast().observe(this, castResponse -> {
            try {
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                movieCastAdapter = new MovieCastAdapter(getApplicationContext(), castResponse.getCast());
                mRecyclerView.setAdapter(movieCastAdapter);
            } catch (NullPointerException ex) {
                ex.getMessage();
            }
        });

        viewModel.getIsProcess().observe(this, apiResponse -> {
            if (apiResponse.status == Status.MESSAGE)
                showMessage(apiResponse.message);
            else if (apiResponse.status == Status.LOADING)
                showLoading();
            else if (apiResponse.status == Status.SUCCESS)
                hideLoading();
            else {
                showMessage(apiResponse.error.getMessage());
                hideLoading();
            }
        });
    }
}
