package com.clml.clmaplication.repository.dto

import java.util.*

data class UserDTO(
        var id: Int,
        var name: String,
        var username: String,
        var email: String,
        var address: Address
)
