package com.joaodanieljr.mooddiary.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.joaodanieljr.mooddiary.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import java.text.SimpleDateFormat
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class AcompanhamentoFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_acompanhamento, container, false)

        var calendar:MaterialCalendarView = view.findViewById(R.id.calendarViewAcompanha)
        var textview:TextView = view.findViewById(R.id.textViewjoao)
        var sdf:SimpleDateFormat = SimpleDateFormat("MM yyyy", Locale.getDefault())


        calendar.setOnDateChangedListener(OnDateSelectedListener(){ materialCalendarView: MaterialCalendarView, date: CalendarDay, b: Boolean ->

            var x:String = date.day.toString()
            textview.setText(x)




        })





        return view
    }





}




