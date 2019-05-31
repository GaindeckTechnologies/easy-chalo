package com.gaindecktechnologies.easychalo.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton
import com.gaindecktechnologies.easychalo.R
import com.gaindecktechnologies.easychalo.utils.PrefManager
import kotlinx.android.synthetic.main.activity_language_selection.*


class LanguageSelectionActivity : AppCompatActivity() {

    private var prefManager: PrefManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_selection)
        prefManager = PrefManager(this)

        buttonContinueLanguage.setOnClickListener {

            startActivity(Intent(this@LanguageSelectionActivity, LoginActivity::class.java))
        }

    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radioButtonEnglish ->
                    if (checked) {

                        buttonContinueLanguage.visibility = View.VISIBLE
                        prefManager!!.setIsLanguageSelected(true)
                        prefManager!!.selectedLanguage = "English"

                    }
                R.id.radioButtonHindi ->
                    if (checked) {

                        buttonContinueLanguage.visibility = View.VISIBLE
                        prefManager!!.setIsLanguageSelected(true)
                        prefManager!!.selectedLanguage = "Hindi"
                    }
            }
        }
    }
}
