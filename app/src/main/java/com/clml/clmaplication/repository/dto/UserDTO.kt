package com.clml.clmaplication.repository.dto

data class UserDTO(
        var id: Int,
        var name: String,
        var username: String,
        var email: String,
        var addressDTO: AddressDTO
)
