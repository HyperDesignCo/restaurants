package com.heyperdesign.restaurants.common.ui.fieldstate

import com.heyperdesign.restaurants.common.ui.extensions.UIText

interface FieldState {
    val value: String
    val error: UIText?
    fun isError(): Boolean = error != null
}

data class TextFieldState(
    override val value: String = "",
    override val error: UIText? = null,
) : FieldState