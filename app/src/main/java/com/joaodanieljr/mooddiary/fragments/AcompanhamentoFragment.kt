package com.joaodanieljr.mooddiary.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.joaodanieljr.mooddiary.CustomCalendar.CalendarView
import com.joaodanieljr.mooddiary.R



/**
 * A simple [Fragment] subclass.
 */
class AcompanhamentoFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_acompanhamento, container, false)
        var cv: CalendarView = view.findViewById(R.id.custom_calendar)
        cv.updateCalendar()

        return view
    }





}




