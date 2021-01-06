package com.clml.clmaplication.repository.dto

data class AddressDTO(
        var street: String,
        var suite: String,
        var city: String,
        var zipcode: String,
        var geoDTO: GeoDTO
)
