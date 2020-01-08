package com.joaodanieljr.mooddiary.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.joaodanieljr.mooddiary.CalendarDecorators.HappyDecorator
import com.joaodanieljr.mooddiary.R
import com.joaodanieljr.mooddiary.CalendarDecorators.SadDecorator
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener



/**
 * A simple [Fragment] subclass.
 */
class HumorDiarioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_humor_diario, container, false)

        var cv:MaterialCalendarView = view.findViewById(R.id.CalendarDiario)

        var today: CalendarDay = CalendarDay.today()
        cv.setDateSelected(today,true)

        //Examples for Test
        var happyDay: CalendarDay
        var happyDates = mutableListOf<CalendarDay>()
        happyDates.clear()
        happyDay = CalendarDay.from(2020,1,25)
        happyDates.add(happyDay)
        happyDay = CalendarDay.from(2020,1,22)
        happyDates.add(happyDay)
        happyDay = CalendarDay.from(2020,1,24)
        happyDates.add(happyDay)
        happyDay = CalendarDay.from(2020,1,26)
        happyDates.add(happyDay)
        happyDay = CalendarDay.from(2020,1,15)
        happyDates.add(happyDay)
        cv.addDecorator(
            HappyDecorator(
                happyDates
            )
        )

        var sadDay:CalendarDay
        var sadDates = mutableListOf<CalendarDay>()
        sadDates.clear()
        sadDay = CalendarDay.from(2020,1,19)
        sadDates.add(sadDay)
        sadDay = CalendarDay.from(2020,1,16)
        sadDates.add(sadDay)
        sadDay = CalendarDay.from(2020,1,17)
        sadDates.add(sadDay)
        sadDay = CalendarDay.from(2020,1,18)
        sadDates.add(sadDay)
        sadDay = CalendarDay.from(2020,1,24)
        sadDates.add(sadDay)
        cv.addDecorator(
            SadDecorator(
                sadDates
            )
        )



        //Click Listener to get Date
            cv.setOnDateChangedListener(OnDateSelectedListener { widget, date, selected ->
                var tx:TextView = view.findViewById(R.id.textViewjoao)
                tx.setText(date.getDay().toString()  + "/" +  date.month + "/" +  date.year )
            })



        // Inflate the layout for this fragment
        return view
    }




}
