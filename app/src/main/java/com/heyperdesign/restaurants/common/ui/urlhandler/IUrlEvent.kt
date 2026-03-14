package com.heyperdesign.restaurants.common.ui.urlhandler

sealed interface IUrlEvent {
    val url: String

    data class OpenUrl(override val url: String) : IUrlEvent
}