package com.clml.clmaplication.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.observe
import androidx.room.*
import com.clml.clmaplication.R
import com.clml.clmaplication.domain.login.LoginData
import com.clml.clmaplication.domain.login.LoginResult
import com.clml.clmaplication.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.GlobalScope

class LoginActivity : AppCompatActivity() {

//    private lateinit var database: AppDatabase
//    private lateinit var dao: PersonDao

    lateinit var viewmodel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnTest = findViewById<Switch>(R.id.switch1)
//
//        database = Room
//            .databaseBuilder(applicationContext, AppDatabase::class.java, "base")
//            .build()
//
//        dao = database.getPersonDao()


        btLogin.setOnClickListener { login() }
        tvForgotPassword.setOnClickListener { forgotPassword() }
        tvRegister.setOnClickListener { register() }
        btChatbot.setOnClickListener { chatBot() }

        btnTest.setOnCheckedChangeListener { _, isChecked ->
            if (btnTest.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                btnTest.text = "Normal"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                btnTest.text = "Dark"
            }
        }

        viewmodel = LoginViewModel(application)

        viewmodel.resultadoParaTela.observe(this){resultado ->
            processarResultadoLogin(resultado)
        }


    }



    fun processarResultadoLogin(res: LoginResult){

        if(res.error != null){
            //quando for erro:
            Toast.makeText(this, res.error, Toast.LENGTH_LONG).show()
            return
        }
        //Quando for sucesso:
        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)
        finish()

    }

    private fun login(){
        val email = etEmail.text.toString()
        val senha = etPassword.text.toString()

        val data = LoginData(email, senha, "","")

        viewmodel.login(data)

    }

    fun forgotPassword(){
        val intentPass = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(intentPass)
    }

     private fun register(){
//         GlobalScope.launch {
//             val p = Person(
//                 email = etEmail.text.toString(),
//                 password = etPassword.text.toString()
//             )
//
//             dao.insertPerson(p)
//         }

        val intentRegister = Intent(this, RegisterActivity::class.java)
        startActivity(intentRegister)

    }


    private fun chatBot(){
        val intentChatBot = Intent(this, ChatBotActivity::class.java);
        startActivity(intentChatBot);
    }
}
///* Entidade Pessoa do banco de dados*/
//
//@Entity
//data class Person(
//    @PrimaryKey(autoGenerate = true)
//    var id: Int? = null,
//
//    var email: String = "",
//    var password: String = ""
//)
//
///* Data Access Object(DAD) de Pessoa*/
//
//@Dao
//interface PersonDao {
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertPerson(p: Person)
//
//    @Update
//    suspend fun updatePerson(p: Person)
//
//}
//
///*Banco de dados do aplicativo*/
//
//@Database(entities = [Person::class], version = 1)
//abstract class AppDatabase: RoomDatabase() {
//    abstract fun getPersonDao(): PersonDao
//}

