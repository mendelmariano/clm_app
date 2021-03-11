package com.clml.clmaplication.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.clml.clmaplication.R
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPassword :  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        btPassConfirm.setOnClickListener { changePass() }
//        btBack.setOnClickListener { back() }
    }

    fun changePass(){
        val newPass = etNewPass.text.toString()
        val confirmNewPass = etConfirmNewPass.text.toString()
        val senhaConfirm = btPassConfirm.text.toString()


        if(newPass.isBlank()){
            Toast.makeText(this,"A senha é obrigatória", Toast.LENGTH_LONG).show()
            return
        }

        if(newPass.length<6){
            Toast.makeText(this,"A senha deve ter pelo menos 6 caracteres", Toast.LENGTH_LONG).show()
            return
        }

        if(confirmNewPass != senhaConfirm){
            Toast.makeText(this,"A senha deve ser igual a confirmação de senha!", Toast.LENGTH_LONG).show()
            return
        }

//        val auth = FirebaseAuth.getInstance()
//        val operacao = auth.createUserWithEmailAndPassword(email, senha)

//        operacao.addOnCompleteListener { resultado->
//            if(resultado.isSuccessful){
//                Toast.makeText(this, "Usuário criado com sucesso!", Toast.LENGTH_LONG).show()
//                finish()
//
//            }else{
//                Toast.makeText(this, "Erro na criação de usuário: ${resultado.exception?.localizedMessage}", Toast.LENGTH_LONG).show()
//
//            }
//
//        }

    }

    fun back(){
        finish()
    }

}