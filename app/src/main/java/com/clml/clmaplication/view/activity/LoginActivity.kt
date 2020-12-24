package com.clml.clmaplication.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.observe
import com.clml.clmaplication.R
import com.clml.clmaplication.domain.login.LoginData
import com.clml.clmaplication.domain.login.LoginResult
import com.clml.clmaplication.viewmodel.LoginViewModel
import com.clml.clmaplication.view.activity.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var viewmodel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btLogin.setOnClickListener { login() }
        tvForgotPassword.setOnClickListener { forgotPassword() }
        tvRegister.setOnClickListener { register() }

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

    fun login(){
        val email = etEmail.text.toString()
        val senha = etPassword.text.toString()

        val data = LoginData(email, senha, "","")

        viewmodel.login(data)

    }

    fun forgotPassword(){

    }

    fun register(){
        val intentRegister = Intent(this, RegisterActivity::class.java)
        startActivity(intentRegister)
    }
}