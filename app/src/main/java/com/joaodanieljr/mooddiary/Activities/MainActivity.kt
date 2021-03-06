package com.joaodanieljr.mooddiary.Activities

//criado por Joao Jr
//Este eh o meu primeiro App
//inicio em 11/12/2019
//Comentarios com o objetivo de ir aprendendo.

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.joaodanieljr.mooddiary.Adapter.Adapter
import com.joaodanieljr.mooddiary.R
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //declarando a view Pager
        val viewPager: ViewPager = findViewById(R.id.view_pager)

        //Instanciando um Adapter
        val fragmentAdapter =
            Adapter(supportFragmentManager)

        //passando o adapter para a view pager
        viewPager.adapter = fragmentAdapter

        //utilizar para usar o tabs no view pager
        // Documentacao: If you're using a ViewPager together with this layout, you can call
        // setupWithViewPager(ViewPager) to link the two together. This layout will be
        // automatically populated from the PagerAdapter's page titles.
        tabs.setupWithViewPager(viewPager)

    }

}

