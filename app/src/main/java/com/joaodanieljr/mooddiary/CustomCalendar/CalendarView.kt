package com.joaodanieljr.mooddiary.CustomCalendar

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.joaodanieljr.mooddiary.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CalendarView : LinearLayout{
    //declarando variaveis
    //formato de data
    private var dateFormat: String? = null

    //mes mostrado na tela
    private val currentDate = Calendar.getInstance()



    //componentes
    private var header: LinearLayout? = null
    private var btnMonthBack: ImageView? = null
    private var btnNextMonth: ImageView? = null
    private var txtDate: TextView? = null
    private var gridDay: GridView? = null


    //construtores
    constructor(context: Context?) : super(context){}

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        initControl(context, attrs)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        initControl(context, attrs)
    }


    //Carregar layout control -> Retirado da internet (preciso estudar melhor)
    fun initControl(
        context: Context,
        attrs: AttributeSet?
    ){
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.custom_calendar, this)
        loadDateFormat(attrs)
        assignUiElements()
        assignClickHandlers()
        updateCalendar()
    }

    //date format que vou usar
    fun loadDateFormat(attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(
            attrs,
            R.styleable.CalendarView
        )
        try { // try to load provided date format, and fallback to default otherwise
            dateFormat = ta.getString(R.styleable.CalendarView_dateFormat)
            if (dateFormat == null) dateFormat =
                DATE_FORMAT
        } finally {
            ta.recycle()
        }
    }

    //elementos do meu calendario na view
    fun assignUiElements(){
        header = findViewById<View>(R.id.calendar_header) as LinearLayout
        btnMonthBack = findViewById<View>(R.id.buttonCalendarBack) as ImageView
        btnNextMonth = findViewById<View>(R.id.buttonCalendarnext) as ImageView
        txtDate = findViewById<View>(R.id.titleCustomCalendar) as TextView
        gridDay = findViewById<View>(R.id.calendarGrid) as GridView
    }

    //funcoes dos cliques
    fun assignClickHandlers(){
        //adiciona um mes e da refresh UI
        btnNextMonth!!.setOnClickListener{
            currentDate.add(Calendar.MONTH, 1)
            updateCalendar()
        }

        // subtrai um mes e refresh UI
        btnMonthBack!!.setOnClickListener {
            currentDate.add(Calendar.MONTH, -1)
            updateCalendar()
        }

        //click listener -> texto negrito na data que o usuario clicar.
        gridDay!!.onItemClickListener = object : AdapterView.OnItemClickListener {

            var b = rootView
            var rodarUmaVez = 0
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                if (rodarUmaVez == 0) {
                    (view as TextView).setTextColor(resources.getColor(R.color.colorPrimary))
                    view.setTypeface(null, Typeface.BOLD)
                    b = view
                    rodarUmaVez++
                }

                else{
                    (b as TextView).setTextColor(resources.getColor(R.color.colorPrimary))
                    (b as TextView).setTypeface(null, Typeface.NORMAL)
                    (view as TextView).setTextColor(resources.getColor(R.color.colorPrimary))
                    view.setTypeface(null, Typeface.BOLD)
                    b = view
                }
            }

        }
    }

    //eventos -> coloracao nos dias marcados

    fun updateCalendar(){
        val felizEvento = ArrayList<Date>()
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        try {
            var data:Date = sdf.parse("21/12/2019")
            felizEvento.add(data)
            updateCalendar(felizEvento)
        }
        catch (e: ParseException){
            e.printStackTrace()
        }
    }

    //Mostrar as datas corretamente no grid

    fun updateCalendar(events: ArrayList<Date>) {
        val cells = ArrayList<Date?>()
        val calendar = currentDate.clone() as Calendar

        //determina a cell para iniciar o inicio do mes
        calendar[Calendar.DAY_OF_MONTH] = 1
        val inicioMesCell = calendar[Calendar.DAY_OF_WEEK] - 1

        //inicio da semana
        calendar.add(Calendar.DAY_OF_MONTH, inicioMesCell)

        //preenche as celulas
        while (cells.size < 42) {
            cells.add(calendar.time)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }


        //Atualiza o grid
        gridDay!!.adapter = CalendarAdapter(context, cells , events)

        val sdf = SimpleDateFormat(dateFormat)
        txtDate!!.text = sdf.format(currentDate.time)


    }




    companion object {
        private const val DATE_FORMAT = "MMM yyyy"
    }

}