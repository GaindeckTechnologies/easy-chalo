package com.gaindecktechnologies.easychalo.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gaindecktechnologies.easychalo.R
import com.gaindecktechnologies.easychalo.utils.LoadFragmentManager
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*


/**
 * A simple [Fragment] subclass.
 *
 */
class EnterPhoneNumberFragment : Fragment() {

    companion object {

        fun newInstance(): EnterPhoneNumberFragment {
            return EnterPhoneNumberFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enter_phone_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonNext.setOnClickListener {

            LoadFragmentManager.replaceFragment(
                activity!!.applicationContext,
                activity!!.supportFragmentManager,
                EnterOTPFragment::class.java.getName(),
                R.id.constraintLayoutLoginPage
            )
        }

        editTextEnterPhoneNumber.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                if (s.length < 10) {

                    buttonNext.visibility = View.GONE
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {


            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {

                if (s.length in 1..9) {

                    editTextEnterPhoneNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_cancel, 0)

                } else if (s.length > 10) {

                    Toast.makeText(
                        activity!!.applicationContext,
                        "Please enter correct phone number",
                        Toast.LENGTH_LONG
                    ).show()
                } else {

                    buttonNext.visibility = View.VISIBLE
                }
            }
        })
    }


}
