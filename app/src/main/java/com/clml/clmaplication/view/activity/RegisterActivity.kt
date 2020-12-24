package com.clml.clmaplication.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.clml.clmaplication.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btRegister.setOnClickListener { register() }
        btBack.setOnClickListener { back() }
    }

    fun register(){
        val email = etEmailRegister.text.toString()
        val senha = etPasswordRegister.text.toString()
        val senhaConfirm = etPasswordConfirmRegister.text.toString()

        if(email.isBlank()){
            Toast.makeText(this,"O e-mail é obrigatório", Toast.LENGTH_LONG).show()
            return
        }

        if(senha.isBlank()){
            Toast.makeText(this,"A senha é obrigatória", Toast.LENGTH_LONG).show()
            return
        }

        if(senha.length<6){
            Toast.makeText(this,"A senha deve ter pelo menos 6 caracteres", Toast.LENGTH_LONG).show()
            return
        }

        if(senhaConfirm.isBlank()){
            Toast.makeText(this,"A senha é obrigatória", Toast.LENGTH_LONG).show()
            return
        }

        if(senhaConfirm.length<6){
            Toast.makeText(this,"A senha deve ter pelo menos 6 caracteres", Toast.LENGTH_LONG).show()
            return
        }

        if(senha != senhaConfirm){
            Toast.makeText(this,"A senha deve ser igual a confirmação de senha!", Toast.LENGTH_LONG).show()
            return
        }

        val auth = FirebaseAuth.getInstance()
        val operacao = auth.createUserWithEmailAndPassword(email, senha)

        operacao.addOnCompleteListener { resultado->
            if(resultado.isSuccessful){
                Toast.makeText(this, "Usuário criado com sucesso!", Toast.LENGTH_LONG).show()
                finish()

            }else{
                Toast.makeText(this, "Erro na criação de usuário: ${resultado.exception?.localizedMessage}", Toast.LENGTH_LONG).show()

            }

        }

    }

    fun back(){
            finish()
    }
}