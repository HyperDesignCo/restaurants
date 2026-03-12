package com.heyperdesign.restaurants.common.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun RestaurantsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) RestaurantsColorsColorsDark else RestaurantsColorsColorsLight
    CompositionLocalProvider(
        localRestaurantsColors provides colors,
        localRestaurantsTypography provides interTypography
    ) {
        content()
    }
}

object RestaurantsTheme {
    val colors: RestaurantsColors
        @Composable
        @ReadOnlyComposable get() = localRestaurantsColors.current
    val typography: RestaurantsTypography
        @Composable @ReadOnlyComposable get() = localRestaurantsTypography.current
}