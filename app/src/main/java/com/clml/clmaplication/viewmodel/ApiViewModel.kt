package com.clml.clmaplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.clml.clmaplication.domain.Tarefa
import com.clml.clmaplication.interactor.ApiInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ApiViewModel(val app: Application): AndroidViewModel(app) , CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val interactor = ApiInteractor()
    val resultadoParaTela =  MutableLiveData<List<Tarefa>>()

    suspend fun chamarAPI(){
        launch {
            val listaTarefas = interactor.chamaAPI()
            resultadoParaTela.value = listaTarefas
        }

    }


}