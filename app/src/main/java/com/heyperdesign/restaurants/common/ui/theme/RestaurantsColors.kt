package com.heyperdesign.restaurants.common.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
val localRestaurantsColors = staticCompositionLocalOf<RestaurantsColors> { error("Cannot provide colors") }
data class RestaurantsColors(
    val primary: Color,
    val secondary : Color,
    val status: Status,
    val text: TextColors,
    val background: Background,
)

data class TextColors(
    val text: Color,
    val hint: Color,
)

data class Status(
    val redAccent: Color,
    val blueAccent: Color,
    val greenAccent: Color,
)

data class Background(
    val disable : Color, 
    val surface : Color, 
    val surfaceHigh: Color,
)

val backgroundLight = Background(
    disable = Color(0xFFE1E4E5),
    surface = Color(0xFFEEEEEE),
    surfaceHigh = Color(0xFFFBFBFB)
)

val statusLight = Status(
    redAccent = Color(0xFFEF4444),
    blueAccent = Color(0xFF0088FF),
    greenAccent = Color(0xFF10B981),
)

val textLight = TextColors(
    text = Color(0xFF292828),
    hint = Color(0x804E4E4E),
)

val backgroundDark = Background(
    disable =Color(0xFF292828),
    surface = Color(0xFF1E1E1E),
    surfaceHigh = Color(0xFF2C2C2C)
)

val statusDark = Status(
    redAccent = Color(0xFFF87171),
    blueAccent = Color(0xFF4DB0FF),
    greenAccent = Color(0xFF34D399),
)

val textDark = TextColors(
    text = Color(0xFFE0DFDF),
    hint = Color(0x80B0B0B0),
)

val RestaurantsColorsColorsLight = RestaurantsColors(
    secondary = Color(0xFF592F16),
    primary = Color(0xFFFF5215),
    status = statusLight,
    text = textLight,
    background = backgroundLight
)

val RestaurantsColorsColorsDark = RestaurantsColors(
    secondary = Color(0xFFC4632A),
    primary = Color(0xFFFF6B3D),
    status = statusDark,
    text = textDark,
    background = backgroundDark,
)