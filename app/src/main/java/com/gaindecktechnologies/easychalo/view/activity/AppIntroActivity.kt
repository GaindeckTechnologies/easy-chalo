package com.gaindecktechnologies.easychalo.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.gaindecktechnologies.easychalo.R
import com.gaindecktechnologies.easychalo.adapter.CustomPagerAdapter
import com.gaindecktechnologies.easychalo.model.AppIntroModel
import com.gaindecktechnologies.easychalo.utils.PrefManager
import kotlinx.android.synthetic.main.activity_app_intro.*


class AppIntroActivity : AppCompatActivity() {

    private var prefManager: PrefManager? = null
    private var layouts: IntArray? = null
    private var dots: Array<ImageView>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prefManager = PrefManager(this)

        if (!prefManager!!.isFirstTimeLaunch()) {

            if (prefManager!!.isLanguageSelected) {

                launchHomeScreen()
                finish()
            } else {
                startActivity(Intent(this@AppIntroActivity, LanguageSelectionActivity::class.java))
                finish()
            }

        }

        setContentView(com.gaindecktechnologies.easychalo.R.layout.activity_app_intro)
        addBottomDots(0)
        viewPagerAppIntro?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

                addBottomDots(position)
            }

        })
        viewPagerAppIntro.adapter = CustomPagerAdapter(this)

        textViewSkip.setOnClickListener {
            launchHomeScreen()
        }
        imageButtonGo.setOnClickListener {
            val current = getItem(+1)
            if (current < AppIntroModel.values().size) {
                // move to next screen
                viewPagerAppIntro.setCurrentItem(current)
            } else {
                launchHomeScreen()
            }
        }
    }

    private fun addBottomDots(currentPage: Int) {
        dots = arrayOf(ImageView(this), ImageView(this), ImageView(this), ImageView(this))
        linearLayoutDots.removeAllViews()

        for (i in 0 until dots!!.size) {
            dots!![i] = ImageView(this)
            dots!![i].setImageResource(R.drawable.ic_dot_inactive)
            dots!![i].setPadding(10, 10, 10, 10)
            linearLayoutDots.addView(dots!![i])
        }

        if (dots!!.isNotEmpty())
            dots!![currentPage].setImageResource(R.drawable.ic_dot_active)
    }


    private fun launchHomeScreen() {

        prefManager!!.setFirstTimeLaunch(false)
        if (prefManager!!.isLanguageSelected) {
            startActivity(Intent(this@AppIntroActivity, LoginActivity::class.java))
        } else {
            startActivity(Intent(this@AppIntroActivity, LanguageSelectionActivity::class.java))
        }
        finish()
    }

    private fun getItem(i: Int): Int {
        return viewPagerAppIntro.getCurrentItem() + i
    }
}
