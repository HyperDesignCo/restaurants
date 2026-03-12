package com.heyperdesign.restaurants.common.ui

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hyperdesin.restaurants.R

val localRestaurantsTypography =
    staticCompositionLocalOf<RestaurantsTypography> { error("Cannot provide text style") }
val inter = FontFamily(
    Font(R.font.inter_bold, weight = FontWeight.Bold),
    Font(R.font.inter_regular, weight = FontWeight.Normal),
)

data class RestaurantsTypography(
    val headline: SizedTypography,
    val title: SizedTypography,
    val body: SizedTypography,
)

data class SizedTypography(
    val extraLarge: TextStyle,
    val large: TextStyle,
    val medium: TextStyle,
)

private val headline = SizedTypography(
    extraLarge = TextStyle(
        fontSize = 24.sp,
        lineHeight = 24.sp,
        fontFamily = inter,
        fontWeight = FontWeight.Bold
    ),
    large = TextStyle(
        fontSize = 22.sp,
        lineHeight = 22.sp,
        fontFamily = inter,
        fontWeight = FontWeight.Bold
    ),
    medium = TextStyle(
        fontSize = 20.sp,
        lineHeight = 20.sp,
        fontFamily = inter,
        fontWeight = FontWeight.Bold
    ),
)

private val title = SizedTypography(
    extraLarge = TextStyle(
        fontSize = 16.sp,
        lineHeight = 16.sp,
        fontFamily = inter,
        fontWeight = FontWeight.Bold
    ),
    large = TextStyle(
        fontSize = 14.sp,
        lineHeight = 14.sp,
        fontFamily = inter,
        fontWeight = FontWeight.Bold
    ),
    medium = TextStyle(
        fontSize = 16.sp,
        lineHeight = 16.sp,
        fontFamily = inter,
        fontWeight = FontWeight.Normal
    )
)

private val body = SizedTypography(
    extraLarge = TextStyle(
        fontSize = 14.sp,
        lineHeight = 14.sp,
        fontFamily = inter,
        fontWeight = FontWeight.Normal
    ),
    large = TextStyle(
        fontSize = 12.sp,
        lineHeight = 12.sp,
        fontFamily = inter,
        fontWeight = FontWeight.Normal
    ),
    medium = TextStyle(
        fontSize = 10.sp,
        lineHeight = 10.sp,
        fontFamily = inter,
        fontWeight = FontWeight.Normal
    )
)

val interTypography = RestaurantsTypography(
    headline = headline,
    title = title,
    body = body,
)