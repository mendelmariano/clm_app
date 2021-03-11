package com.clml.clmaplication.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.observe
import androidx.room.*
import com.clml.clmaplication.R
import com.clml.clmaplication.domain.login.LoginData
import com.clml.clmaplication.domain.login.LoginResult
import com.clml.clmaplication.viewmodel.LoginViewModel
import com.clml.clmaplication.view.activity.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.*

class LoginActivity : AppCompatActivity() {

    lateinit var viewmodel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnTest = findViewById<Switch>(R.id.switch1)


        btLogin.setOnClickListener { login() }
        tvForgotPassword.setOnClickListener { forgotPassword() }
        tvRegister.setOnClickListener { register() }

        btnTest.setOnCheckedChangeListener { _, isChecked ->
            if (btnTest.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                btnTest.text = "Normal"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                btnTest.text = "Dark"
            }
        }

        viewmodel = LoginViewModel(application)

        viewmodel.resultadoParaTela.observe(this){resultado ->
            processarResultadoLogin(resultado)
        }


    }



    fun processarResultadoLogin(res: LoginResult){

        if(res.error != null){
            //quando for erro:
            Toast.makeText(this, res.error, Toast.LENGTH_LONG).show()
            return
        }
        //Quando for sucesso:
        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)
        finish()

    }

    private fun login(){
        val email = etEmail.text.toString()
        val senha = etPassword.text.toString()

        val data = LoginData(email, senha, "","")

        viewmodel.login(data)

    }

    fun forgotPassword(){
        val forgotPassword = Intent(this, ForgotPassword::class.java)
        startActivity(forgotPassword)
    }

     fun register(){


        val intentRegister = Intent(this, RegisterActivity::class.java)
        startActivity(intentRegister)

    }
}
