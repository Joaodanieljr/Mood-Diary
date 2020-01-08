package com.joaodanieljr.mooddiary.CalendarDecorators

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade

class HappyDecorator (var dates: MutableList<CalendarDay>): DayViewDecorator  {


    var drawable: ColorDrawable? = ColorDrawable(Color.GREEN)


    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return dates.contains(day)
    }

    override fun decorate(view: DayViewFacade?) {

        view?.setBackgroundDrawable(drawable!!)
    }
}

