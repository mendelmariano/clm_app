package com.clml.clmaplication.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clml.clmaplication.R
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btOpenProfile.setOnClickListener { profile() }

        btMaps.setOnClickListener { Maps() }
    }


    private fun profile(){
        val intentProfile = Intent(this, MyProfile::class.java)
        startActivity(intentProfile)
    }
    private fun Maps(){
        val intentMapsActivity = Intent(this, MapsActivity::class.java)
        startActivity(intentMapsActivity)
    }
}