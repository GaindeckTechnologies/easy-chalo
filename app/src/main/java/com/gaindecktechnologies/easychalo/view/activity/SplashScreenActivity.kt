package com.gaindecktechnologies.easychalo.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieDrawable
import com.gaindecktechnologies.easychalo.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lottieAnimationViewSplash.setAnimation("drink.json");
        lottieAnimationViewSplash.playAnimation();
        lottieAnimationViewSplash.repeatCount = LottieDrawable.INFINITE;
    }
}
