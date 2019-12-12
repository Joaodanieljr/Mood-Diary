package com.joaodanieljr.mooddiary.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.joaodanieljr.mooddiary.R

/**
 * A simple [Fragment] subclass.
 */
class AcompanhamentoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acompanhamento, container, false)
    }


}
