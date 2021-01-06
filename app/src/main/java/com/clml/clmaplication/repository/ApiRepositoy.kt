package com.clml.clmaplication.repository


import com.clml.clmaplication.domain.Tarefa
import com.clml.clmaplication.repository.dto.TaskDTO

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface UserApi {


    @GET("todos")
    @Headers("Content-Type: Application/json")
    suspend fun recuperarTarefas(): List<TaskDTO>

}

class ApiRepositoy {

    private val conector: Retrofit
    // Endereço da API: exemplo: https://jsonplaceholder.typicode.com/

    init {
        /*val jsonConfig = GsonBuilder()
                .setDateFormat("YYYY-MM-DD")
                .create()*/

        conector = Retrofit.Builder().
        baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }

    suspend fun chamarAPI(): List<Tarefa>{
        val service = conector.create(UserApi::class.java)
        val listaTarefas = service.recuperarTarefas()

        val NovaLista = listaTarefas.map { dto ->
            Tarefa(
                    userId = dto.userId,
                    id = dto.id,
                    title = dto.title,
                    completed = dto.completed
            )
        }

        return NovaLista

    }
}