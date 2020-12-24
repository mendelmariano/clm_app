package com.clml.clmaplication.interactor

import android.widget.Toast
import com.clml.clmaplication.domain.login.LoginData
import com.clml.clmaplication.domain.login.LoginResult
import com.clml.clmaplication.repository.LoginRepository

class LoginInteractor {

    val repo: LoginRepository = LoginRepository()

    suspend fun login(data: LoginData): LoginResult{
        val resultado = LoginResult()

        if(data.email.isBlank()){
            resultado.error = "ERRO EMAIL VAZIO"
            return resultado

        }

        if(data.senha.isBlank()){
            resultado.error = "ERRO SENHA VAZIA"
            return resultado
        }

        if(data.senha.length<6){
            resultado.error = "ERRO SENHA MENOR QUE 6 CARACTERES"
            return resultado
        }
        val resultadoRepo = repo.login(data)

        return resultadoRepo
    }

    fun forgotPassword(){

    }

    fun register(){

    }

}