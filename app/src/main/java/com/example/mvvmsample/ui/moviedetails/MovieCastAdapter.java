package com.example.mvvmsample.ui.moviedetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.example.mvvmsample.R;
import com.example.mvvmsample.data.model.api.cast.Cast;
import com.example.mvvmsample.utils.GlideApp;

import java.util.List;

public class MovieCastAdapter extends RecyclerView.Adapter<MovieCastHolder> {

    private Context mContext;
    private List<Cast> mCastList;

    public MovieCastAdapter(Context context, List<Cast> castList) {
        mContext = context;
        mCastList = castList;
    }

    @NonNull
    @Override
    public MovieCastHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_cast, parent, false);
        return new MovieCastHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieCastHolder holder, int position) {
        try {
            Cast cast = mCastList.get(position);
            holder.txtCastName.setText(String.valueOf(cast.getName()));
            GlideApp.with(mContext)
                    .load("http://image.tmdb.org/t/p/w500" + cast.getProfilePath()) // Remote URL of image.
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.imgCast);
        } catch (NullPointerException ex) {
            ex.getMessage();
        }
    }

    // show only five
    @Override
    public int getItemCount() {
        return 5;
    }
}
