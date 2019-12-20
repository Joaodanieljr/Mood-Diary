package com.joaodanieljr.mooddiary.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.joaodanieljr.mooddiary.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val buttonLogin: Button
        val textCadastro: TextView
        val textEsqueceu: TextView

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin = findViewById(R.id.buttonLogin)
        textCadastro = findViewById(R.id.textCadastro)
        textEsqueceu = findViewById(R.id.textEsqueceuSenha)

        buttonLogin.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


        textCadastro.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)

        }

        textEsqueceu.setOnClickListener{
            val intent = Intent(this,EsqueceuSenhaActivity::class.java)
            startActivity(intent)
        }
    }

}
