package com.clml.clmaplication.repository

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepositoy {

    private val conector: Retrofit
    // Endereço da API: exemplo: https://jsonplaceholder.typicode.com/todos/

    init {
        val jsonConfig = GsonBuilder()
                .setDateFormat("YYYY-MM-DD")

        conector = Retrofit.Builder().
        baseUrl("https://jsonplaceholder.typicode.com/todos/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }

    suspend fun chamarAPI(){
        TODO("Chamar a API")
    }
}