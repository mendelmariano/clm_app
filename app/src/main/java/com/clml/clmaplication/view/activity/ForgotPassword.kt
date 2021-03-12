package com.clml.clmaplication.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.clml.clmaplication.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPassword :  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        btPassConfirm.setOnClickListener { changePass() }
        btBack2.setOnClickListener { back() }
    }

    fun changePass(){
        val email = etEmailForgot.text.toString()

        if(email.isBlank()){
            Toast.makeText(this,"O email é obrigatória", Toast.LENGTH_LONG).show()
            return
        }

        val autenticacao = FirebaseAuth.getInstance();
        val operacao = autenticacao.sendPasswordResetEmail(email);
        operacao.addOnCompleteListener { resultado ->
            if(resultado.isSuccessful){
                Toast.makeText(this, "CERTO: Senha enviada para usuario cadastrado", Toast.LENGTH_LONG).show();
                val goToLogin = Intent(this, LoginActivity::class.java);
                startActivity(goToLogin);
            }else{
                Toast.makeText(this, "Erro: Usuário inexistentes", Toast.LENGTH_LONG).show();
            }
        }

    }

    fun back(){
        finish()
    }

}