package com.clml.clmaplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.clml.clmaplication.interactor.ApiInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class ApiViewModel(val app: Application): AndroidViewModel(app) , CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val interactor = ApiInteractor()

    suspend fun chamarAPI(){
        interactor.chamaAPI()
    }


}