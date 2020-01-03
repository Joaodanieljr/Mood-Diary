package com.joaodanieljr.mooddiary.CustomCalendar

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.joaodanieljr.mooddiary.R
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet


class CalendarAdapter(
    context: Context?,
    days: ArrayList<Date?>,
      // days with events
    private val eventDays: ArrayList<Date>
) :
    ArrayAdapter<Date?>(context!!,
        R.layout.days_custom_calendar, days as List<Date?>
    ) {
    // for view inflation
    private val inflater: LayoutInflater = LayoutInflater.from(context)

      override fun getView(
        position: Int,
        view: View?,
        parent: ViewGroup
    ): View { // day in question
        var view = view
        val date = getItem(position)
        val day = date!!.date
        val month = date.month
        val year = date.year
        // today
        val today = Date()
        // inflate item if it does not exist yet
        if (view == null) view = inflater.inflate(R.layout.days_custom_calendar, parent, false)
        // if this day has an event, specify event image
        view!!.setBackgroundResource(0)
        if (eventDays != null) {
            for (eventDate in eventDays) {
                if (eventDate.date == day && eventDate.month == month && eventDate.year == year
                ) { // mark this day for event
                    view.setBackgroundResource(R.color.colorAccent)
                    break
                }
            }
        }
        // clear styling
        (view as TextView?)!!.setTypeface(null, Typeface.NORMAL)
        (view as TextView?)!!.setTextColor(Color.BLACK)
        if (month != today.month || year != today.year) { // if this day is outside current month, grey it out
            (view as TextView).resources.getColor(R.color.colorPrimary)
        } else if (day == today.date) { // if it is today, set it to blue/bold
            (view as TextView).setTypeface(null, Typeface.BOLD)
            (view as TextView).resources.getColor(R.color.colorPrimary)
        }
        // set text
        (view as TextView).text = date.date.toString()
        return view
    }

  }
