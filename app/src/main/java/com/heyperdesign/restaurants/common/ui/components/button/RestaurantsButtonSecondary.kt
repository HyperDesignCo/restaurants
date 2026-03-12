package com.heyperdesign.restaurants.common.ui.components.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.heyperdesign.restaurants.common.ui.preview.PreviewAllVariants
import com.heyperdesign.restaurants.common.ui.theme.RestaurantsTheme

@Composable
fun RestaurantsButtonSecondary(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    shape: Shape = RestaurantsButtonDefaults.shape,
) {
    RestaurantsButton(
        modifier = modifier,
        label = label,
        onClick = onClick,
        shape = shape,
        colors = RestaurantsButtonSecondaryDefaults.colors,
        isEnabled = isEnabled,
        labelStyle =RestaurantsButtonSecondaryDefaults.labelStyle
    )
}

object RestaurantsButtonSecondaryDefaults {
    val labelStyle
        @Composable
        get() = RestaurantsTheme.typography.title.medium
    val colors: RestaurantsButtonColors
        @Composable get() =
            RestaurantsButtonDefaults.color(
                containerColor = RestaurantsTheme.colors.background.surfaceHigh,
                contentColor = RestaurantsTheme.colors.secondary,
                disabledContainerColor = RestaurantsTheme.colors.background.disable,
                disabledContentColor = RestaurantsTheme.colors.text.text,
                boarderColor = RestaurantsTheme.colors.secondary
            )
}

@Composable
@PreviewAllVariants
@Preview(showBackground = true)
private fun RestaurantsButtonSecondaryPreview() = RestaurantsTheme {
    RestaurantsButtonSecondary(
        label = "login",
        onClick = {},
        isEnabled = true
    )
}