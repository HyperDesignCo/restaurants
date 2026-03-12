package com.heyperdesign.restaurants.common.domain

import com.heyperdesign.restaurants.common.data.exception.RestaurantsException

sealed class Resource<out Model> {
    data class Success<out Model>(val model: Model) : Resource<Model>()
    data class Failure(val exception: RestaurantsException) : Resource<Nothing>()
    data class Loading(val isLoading: Boolean = false) : Resource<Nothing>()
}