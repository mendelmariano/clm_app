package com.clml.clmaplication.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clml.clmaplication.R
import com.clml.clmaplication.domain.Message
import com.clml.clmaplication.domain.Response
import kotlinx.android.synthetic.main.activity_chat_bot.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

class ChatBotActivity: AppCompatActivity() {
    private lateinit var retrofit: Retrofit
    private lateinit var dialogFlow: HerokuDialogFlow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_bot)
        retrofit = createRetrofit()
        dialogFlow= retrofit.create(HerokuDialogFlow::class.java)
        btSend.setOnClickListener { send() }

    }
    private fun send(){
        GlobalScope.launch(Dispatchers.Main){
            val question = tvQuestion.text.toString()
            val message = Message(question, "", "123")
            val response = dialogFlow.sendMessageAsync(message)
            if (response.isNotEmpty()) {
                tvResponse.text = response[0].queryResult.fulfillmentText
                tvQuestion.setText("")
            }
        }

    }
    private fun createRetrofit(): Retrofit {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(logInterceptor).build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl("https://projetoiesb.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    interface HerokuDialogFlow {

        @POST("message/text/send")
        @Headers("Content-Type: application/json")
        suspend fun sendMessageAsync(@Body message: Message): Array<Response>

    }
}