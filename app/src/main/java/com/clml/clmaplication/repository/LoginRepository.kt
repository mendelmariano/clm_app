package com.clml.clmaplication.repository

import com.google.firebase.auth.FirebaseAuth
import com.clml.clmaplication.domain.login.LoginData
import com.clml.clmaplication.domain.login.LoginResult
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LoginRepository {

    suspend fun login(data: LoginData): LoginResult= suspendCoroutine{ resultadoPromisse ->

        //LOGIN COM FIREBASE

        val auth = FirebaseAuth.getInstance()
        val operacao = auth.signInWithEmailAndPassword(data.email,data.senha)
        operacao.addOnCompleteListener { resultado ->
            val resLogin = LoginResult()
            if(resultado.isSuccessful){
                resLogin.result = "LOGIN FIREBASE COM SUCESSO"
            }else{
                resLogin.error = "LOGIN FIREBASE ERRO"
            }
            resultadoPromisse.resume(resLogin)
        }


    }

    fun forgotPassword(data: LoginData){

    }

   fun register(data: LoginData){

   }
}