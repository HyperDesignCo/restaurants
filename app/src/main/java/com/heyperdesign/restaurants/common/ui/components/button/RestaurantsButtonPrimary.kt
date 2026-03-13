package com.heyperdesign.restaurants.common.ui.components.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.heyperdesign.restaurants.common.ui.preview.PreviewAllVariants
import com.heyperdesign.restaurants.common.ui.theme.RestaurantsTheme

@Composable
fun RestaurantsButtonPrimary(
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
        colors = RestaurantsButtonPrimaryDefaults.colors,
        isEnabled = isEnabled,
    )
}

object RestaurantsButtonPrimaryDefaults {
    val colors: RestaurantsButtonColors
        @Composable get() =
            RestaurantsButtonDefaults.color(
                containerColor = RestaurantsTheme.colors.primary,
                contentColor = RestaurantsTheme.colors.background.surfaceHigh,
                disabledContainerColor = RestaurantsTheme.colors.background.disable,
                disabledContentColor = RestaurantsTheme.colors.text.text,
                boarderColor = RestaurantsTheme.colors.primary
            )
}

@Composable
@PreviewAllVariants
@Preview(showBackground = true)
private fun RestaurantsButtonPrimaryPreview() = RestaurantsTheme {
    RestaurantsButtonPrimary(
        label = "login",
        onClick = {},
        isEnabled = true
    )
}