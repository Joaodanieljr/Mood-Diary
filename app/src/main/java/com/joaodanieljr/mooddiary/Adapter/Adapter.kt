package com.joaodanieljr.mooddiary.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.joaodanieljr.mooddiary.fragments.AcompanhamentoFragment
import com.joaodanieljr.mooddiary.fragments.ConfiguracaoFragment
import com.joaodanieljr.mooddiary.fragments.HumorDiarioFragment

class Adapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {HumorDiarioFragment()}
            1 -> {AcompanhamentoFragment()}
            else ->{
                return ConfiguracaoFragment()
            }

        }
    }

    override fun getCount(): Int {
        return 3;
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Mood"
            1 -> "Graphs"
            else ->{
                return "Config"
            }
        }
    }

}