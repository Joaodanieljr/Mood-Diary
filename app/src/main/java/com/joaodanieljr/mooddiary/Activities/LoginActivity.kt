package com.joaodanieljr.mooddiary.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.joaodanieljr.mooddiary.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

       val buttonLogin: Button

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

}
