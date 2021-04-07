package com.clml.clmaplication.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Profile(
    //@PrimaryKey(autoGenerate = true)
    @PrimaryKey
    var id: Int = 0,
    var name: String? = "",
    var address: String? = ""
)
