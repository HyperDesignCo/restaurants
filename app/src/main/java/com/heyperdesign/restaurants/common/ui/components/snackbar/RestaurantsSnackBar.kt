package com.heyperdesign.restaurants.common.ui.components.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.heyperdesign.restaurants.common.ui.theme.RestaurantsTheme
import com.hyperdesin.restaurants.R

@Composable
fun RestaurantsSnackbar(
    message: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    colors: RestaurantsSnackbarColors = RestaurantsSnackbarDefaults.colors(),
    shape: RoundedCornerShape = RestaurantsSnackbarDefaults.shape,
    horizontalArrangement: Dp = RestaurantsSnackbarDefaults.horizontalArrangement,
    boarderWidth: Dp = RestaurantsSnackbarDefaults.borderWidth,
    iconSize: Dp = RestaurantsSnackbarDefaults.iconSize,
) {
    Snackbar(
        modifier = modifier
            .fillMaxWidth()
            .border(width = boarderWidth, color = colors.borderColor, shape = shape),
        shape = shape,
        containerColor = colors.containerColor,
    ) {
        Row(
            Modifier
                .background(color = colors.containerColor),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(horizontalArrangement)
        ) {
            icon?.let {
                Icon(
                    modifier = Modifier.size(iconSize),
                    imageVector = icon,
                    tint = colors.iconColor,
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = message,
                style = RestaurantsTheme.typography.body.medium,
                color = RestaurantsTheme.colors.secondary
            )
        }
    }
}

data class RestaurantsSnackbarColors(
    val containerColor: Color,
    val contentColor: Color,
    val borderColor: Color,
    val iconColor: Color,
)

object RestaurantsSnackbarDefaults {
    val shape = RoundedCornerShape(16.dp)
    val horizontalArrangement = 8.dp
    val borderWidth = 1.dp
    val iconSize = 24.dp

    @Composable
    fun colors(
        containerColor: Color = Color.Unspecified,
        contentColor: Color = Color.Unspecified,
        borderColor: Color = Color.Unspecified,
        iconColor: Color = Color.Unspecified,
    ) = RestaurantsSnackbarColors(
        containerColor = containerColor,
        contentColor = contentColor,
        borderColor = borderColor,
        iconColor = iconColor
    )

}

@PreviewLightDark
@Composable
private fun RestaurantsSnackbarPreview() = RestaurantsTheme {
    RestaurantsSnackbar(
        message = "Some error happened.",
        icon = ImageVector.vectorResource(R.drawable.ic_snack_bar_fail),
        colors = RestaurantsSnackbarColors(
            containerColor = RestaurantsTheme.colors.background.surfaceHigh,
            contentColor = RestaurantsTheme.colors.secondary,
            borderColor = RestaurantsTheme.colors.secondary,
            iconColor = RestaurantsTheme.colors.status.redAccent
        ),
    )
}