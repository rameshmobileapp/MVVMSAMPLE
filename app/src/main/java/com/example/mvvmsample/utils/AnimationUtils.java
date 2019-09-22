package com.example.mvvmsample.utils;

import android.content.Context;
import android.view.animation.Animation;

import com.example.mvvmsample.R;
import com.example.mvvmsample.di.ApplicationContext;

import javax.inject.Inject;

public class AnimationUtils {

    private Context context;

    @Inject
    public AnimationUtils(@ApplicationContext Context context) {
        this.context = context;
    }

    public Animation getFadeIn() {
        return android.view.animation.AnimationUtils.loadAnimation(context, R.anim.fade_in);
    }

    public Animation getSlideUp() {
        return android.view.animation.AnimationUtils.loadAnimation(context, R.anim.slide_up);
    }

    public Animation getSlideDown() {
        return android.view.animation.AnimationUtils.loadAnimation(context, R.anim.slide_down);
    }
}
