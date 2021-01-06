package com.clml.clmaplication.interactor

import com.clml.clmaplication.domain.Tarefa
import com.clml.clmaplication.repository.ApiRepositoy

class ApiInteractor {

    private val repo = ApiRepositoy()

    suspend fun chamaAPI(): List<Tarefa>{
        return repo.chamarAPI()

    }
}
