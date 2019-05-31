package com.gaindecktechnologies.easychalo.model

import com.gaindecktechnologies.easychalo.R

enum class AppIntroModel constructor(val titleResId: Int, val layoutResId: Int) {

    RED(R.string.one, R.layout.fragment_app_intro_one),
    BLUE(R.string.two, R.layout.fragment_app_intro_two),
    GREEN(R.string.three, R.layout.fragment_app_intro_three),
    YELLOW(R.string.four, R.layout.fragment_app_intro_four)

}