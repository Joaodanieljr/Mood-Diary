package com.joaodanieljr.mooddiary.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.joaodanieljr.mooddiary.R
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class HumorDiarioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_humor_diario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var calendar: Calendar = Calendar.getInstance()

        var textView: TextView = view.findViewById(R.id.textDatePrincipal)

        textView.setText(calendar.get(Calendar.YEAR).toString())


    }

}
