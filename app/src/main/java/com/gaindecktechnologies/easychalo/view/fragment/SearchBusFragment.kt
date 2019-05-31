package com.gaindecktechnologies.easychalo.view.fragment


import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gaindecktechnologies.easychalo.R
import kotlinx.android.synthetic.main.fragment_search_bus.*
import java.text.SimpleDateFormat
import java.util.*


/**
 * A simple [Fragment] subclass.
 *
 */
class SearchBusFragment : Fragment() {

    val myCalendar = Calendar.getInstance()
    private var mcontext: Context? = null

    companion object {

        fun newInstance(): SearchBusFragment {
            return SearchBusFragment()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_bus, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.mcontext = context

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val date = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel()
        }

        editTextJourneyDate.setOnClickListener {

            DatePickerDialog(
                mcontext,
                date,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()

        }

    }

    private fun updateLabel() {

        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        editTextJourneyDate.setText(sdf.format(myCalendar.getTime()))
    }

}
