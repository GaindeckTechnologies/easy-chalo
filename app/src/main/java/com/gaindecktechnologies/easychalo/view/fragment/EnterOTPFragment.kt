package com.gaindecktechnologies.easychalo.view.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gaindecktechnologies.easychalo.R
import com.gaindecktechnologies.easychalo.utils.ProgressBar
import com.gaindecktechnologies.easychalo.view.activity.HomeActivity
import com.poovam.pinedittextfield.PinField
import kotlinx.android.synthetic.main.fragment_enter_otp.*


/**
 * A simple [Fragment] subclass.
 *
 */
class EnterOTPFragment : Fragment() {

    companion object {

        fun newInstance(): EnterOTPFragment {
            return EnterOTPFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enter_otp, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linePinField.onTextCompleteListener = object : PinField.OnTextCompleteListener {

            override fun onTextComplete(enteredText: String): Boolean {

                ProgressBar.setProgressBar(activity, "Logging In...")

                startActivity(Intent(activity!!.applicationContext, HomeActivity::class.java))

                return true // Return true to keep the keyboard open else return false to close the keyboard
            }
        }
    }
}
