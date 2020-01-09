package com.joaodanieljr.mooddiary.fragments


import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.joaodanieljr.mooddiary.CalendarDecorators.HappyDecorator
import com.joaodanieljr.mooddiary.R
import com.joaodanieljr.mooddiary.CalendarDecorators.SadDecorator
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView

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

        //happyDates.clear()
        /*
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
        cv.addDecorator(HappyDecorator(happyDates))
        */

        var sadDay:CalendarDay
        var sadDates = mutableListOf<CalendarDay>()

        //sadDates.clear()
/*
        sadDay = CalendarDay.from(2020,1,16)
        sadDates.add(sadDay)
        sadDay = CalendarDay.from(2020,1,17)
        sadDates.add(sadDay)
        sadDay = CalendarDay.from(2020,1,18)
        sadDates.add(sadDay)
        sadDay = CalendarDay.from(2020,1,24)
        sadDates.add(sadDay)
        cv.addDecorator( SadDecorator(sadDates))

      */

        var tx:TextView = view.findViewById(R.id.textViewjoao)
        var initDay : CalendarDay = CalendarDay.today()
        tx.setText(initDay.getDay().toString()  + "/" +  initDay.month + "/" +  initDay.year )
        //Click Listener to get Date
        cv.setOnDateChangedListener { widget, date, selected ->

            tx.setText(date.getDay().toString()  + "/" +  date.month + "/" +  date.year )

            }

        //test SeekBar - change to another class
        var seekBar: SeekBar = view.findViewById(R.id.seekBar)
        var textProgress: TextView = view.findViewById(R.id.textProgress)

        seekBar.setOnSeekBarChangeListener(object: OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                when{
                    progress == 0 -> {textProgress.setText("Dia Pessimo")
                                    seekBar?.setThumb(resources.getDrawable(R.drawable.angry))}

                    progress == 1 -> {textProgress.setText("Dia Ruim")
                                    seekBar?.setThumb(resources.getDrawable(R.drawable.bad))}

                    progress == 2 -> {textProgress.setText("Dia Normal")
                                    seekBar?.setThumb(resources.getDrawable(R.drawable.neutral))}

                    progress == 3 -> {textProgress.setText("Dia Bom")
                                    seekBar?.setThumb(resources.getDrawable(R.drawable.happy))}

                    progress == 4 -> {textProgress.setText("Dia Otimo")
                                    seekBar?.setThumb(resources.getDrawable(R.drawable.great))}
                }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        var buttonSave: Button = view.findViewById(R.id.buttonSave)
        buttonSave.setOnClickListener {
            if (seekBar.progress == 0){
                var date: CalendarDay? = cv.selectedDate
                sadDay = CalendarDay.from(date!!.year,date!!.month,date!!.day)
                sadDates.add(sadDay)
                cv.addDecorator( SadDecorator(sadDates))
                happyDates.remove(sadDay)
            }

            if (seekBar.progress == 3){
                var date: CalendarDay? = cv.selectedDate
                happyDay = CalendarDay.from(date!!.year,date!!.month,date!!.day)
                happyDates.add(happyDay)
                cv.addDecorator( HappyDecorator(happyDates))
                sadDates.remove(happyDay)
            }
        }





        // Inflate the layout for this fragment
        return view
    }




}
