package com.gaindecktechnologies.easychalo.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gaindecktechnologies.easychalo.R
import com.gaindecktechnologies.easychalo.utils.LoadFragmentManager
import com.gaindecktechnologies.easychalo.view.fragment.EnterPhoneNumberFragment


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        LoadFragmentManager.addFragment(
            this, supportFragmentManager, EnterPhoneNumberFragment::class.java.getName(),
            R.id.constraintLayoutLoginPage
        )
    }


}
