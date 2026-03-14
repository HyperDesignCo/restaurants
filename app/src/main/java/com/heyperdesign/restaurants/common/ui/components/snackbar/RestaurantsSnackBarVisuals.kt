package com.heyperdesign.restaurants.common.ui.components.snackbar

import androidx.annotation.DrawableRes
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.runtime.Composable
import com.heyperdesign.restaurants.common.ui.message.MessageType
import com.heyperdesign.restaurants.common.ui.theme.RestaurantsTheme
import com.hyperdesin.restaurants.R

data class RestaurantsSnackbarVisuals(
    val messageType: MessageType,
    override val actionLabel: String,
    override val duration: SnackbarDuration,
    override val message: String,
    override val withDismissAction: Boolean,
) : SnackbarVisuals {
    val colors: RestaurantsSnackbarColors
        @Composable get() = when (messageType) {
            MessageType.SUCCESS -> RestaurantsSnackbarColors(
                containerColor = RestaurantsTheme.colors.background.surfaceHigh,
                contentColor = RestaurantsTheme.colors.secondary,
                borderColor = RestaurantsTheme.colors.text.hint,
                iconColor = RestaurantsTheme.colors.status.greenAccent
            )

            MessageType.ERROR -> RestaurantsSnackbarColors(
                containerColor = RestaurantsTheme.colors.background.surfaceHigh,
                contentColor = RestaurantsTheme.colors.secondary,
                borderColor = RestaurantsTheme.colors.text.hint,
                iconColor = RestaurantsTheme.colors.status.redAccent
            )


            MessageType.RETRY -> RestaurantsSnackbarColors(
                containerColor = RestaurantsTheme.colors.background.surfaceHigh,
                contentColor = RestaurantsTheme.colors.secondary,
                borderColor = RestaurantsTheme.colors.text.hint,
                iconColor = RestaurantsTheme.colors.status.redAccent
            )

            MessageType.DEFAULT -> RestaurantsSnackbarColors(
                containerColor = RestaurantsTheme.colors.background.surfaceHigh,
                contentColor = RestaurantsTheme.colors.secondary,
                borderColor = RestaurantsTheme.colors.text.hint,
                iconColor = RestaurantsTheme.colors.status.greenAccent
            )
        }
    val iconRes: Int
        @DrawableRes get() = when (messageType) {
            MessageType.SUCCESS -> R.drawable.ic_snack_bar_success
            MessageType.ERROR -> R.drawable.ic_snack_bar_fail
            MessageType.RETRY -> R.drawable.ic_snack_bar_fail
            MessageType.DEFAULT -> R.drawable.ic_snack_bar_success
        }
}