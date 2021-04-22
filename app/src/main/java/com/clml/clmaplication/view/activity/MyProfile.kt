package com.clml.clmaplication.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.clml.clmaplication.R
import com.clml.clmaplication.domain.Profile
import com.clml.clmaplication.repository.dto.AppDatabase
import com.clml.clmaplication.repository.dto.ProfileDAO
import kotlinx.android.synthetic.main.activity_my_profile.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyProfile : AppCompatActivity() {
    private lateinit var database: AppDatabase
    private lateinit var dao: ProfileDAO

    private var profile: Profile = Profile()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)



        database = Room
            .databaseBuilder(applicationContext, AppDatabase::class.java, "CLMBD")
            .build()

        dao = database.getProfileDao()


        btEditProfile.setOnClickListener { insertProfile() }
        btCarregaPerfil.setOnClickListener { searchProfile() }
        //searchProfile()
    }

    private fun insertProfile(){
        GlobalScope.launch {


            val profile = Profile(
                name = ptNameProfile.text.toString(),
                address = ptAddressProfile.text.toString()
            )
            dao.insertProfile(profile)

        }
        searchProfile()

    }

    private fun updateProfile(){

    }

    private fun deleteProfile(){

    }

    private fun searchProfile(){
        GlobalScope.launch(Dispatchers.Main) {

            profile = dao.getProfile()
            tvNameProfile.setText(profile.name)
            tvAddressProfile.setText(profile.address)
        }
    }


}