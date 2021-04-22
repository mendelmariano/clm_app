package com.clml.clmaplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.clml.clmaplication.R
import com.clml.clmaplication.domain.login.LoginData
import com.clml.clmaplication.domain.login.LoginResult
import com.clml.clmaplication.interactor.LoginInteractor
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginViewModel(val app: Application) : AndroidViewModel(app), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main


    val interactor = LoginInteractor()

    val resultadoParaTela = MutableLiveData<LoginResult>()

    fun login(data: LoginData){

        launch {
            val resultado = interactor.login(data)

            if (resultado.error != null) {
                if (resultado.error == "ERRO EMAIL VAZIO") {
                    resultado.error = app.getString((R.string.email_required))
                }else if(resultado.error == "ERRO SENHA VAZIA"){
                    resultado.error = app.getString((R.string.pass_required))
                }else if(resultado.error == "ERRO SENHA MENOR QUE 6 CARACTERES"){
                    resultado.error = app.getString((R.string.pass_6_char))
                } else if(resultado.error == "LOGIN FIREBASE ERRO"){
                    resultado.error = app.getString((R.string.login_error))
                }


            }else {
                resultado.error = null
                resultado.result = "login com sucesso"
            }

            resultadoParaTela.value = resultado
        }

    }


}

