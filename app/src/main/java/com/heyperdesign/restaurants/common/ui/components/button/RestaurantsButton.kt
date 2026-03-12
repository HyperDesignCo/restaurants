package com.heyperdesign.restaurants.common.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.heyperdesign.restaurants.common.ui.preview.PreviewAllVariants
import com.heyperdesign.restaurants.common.ui.theme.RestaurantsTheme

@Composable
fun RestaurantsButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors:  RestaurantsButtonColors = RestaurantsButtonDefaults.color(),
    isEnabled: Boolean = true,
    contentPadding: PaddingValues = RestaurantsButtonDefaults.paddingValues,
    shape: Shape = RestaurantsButtonDefaults.shape,
    labelStyle: TextStyle = RestaurantsButtonDefaults.labelStyle,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape),
        shape = shape,
        colors = ButtonColors(
            containerColor = colors.containerColor,
            contentColor = colors.contentColor,
            disabledContainerColor = colors.disabledContainerColor,
            disabledContentColor = colors.disabledContentColor
        ),
        border = BorderStroke(width = RestaurantsButtonDefaults.borderWidth, color = colors.boarderColor),
        contentPadding = contentPadding,
        enabled = isEnabled,
        onClick = onClick
    ) {
        Text(
            text = label, style = labelStyle
        )
    }
}
data class RestaurantsButtonColors(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
    val boarderColor: Color,
)
object RestaurantsButtonDefaults {
    var borderWidth = 0.dp
    var shape = RoundedCornerShape(8.dp)
    val labelStyle: TextStyle
        @Composable
        get() = RestaurantsTheme.typography.title.extraLarge
    var paddingValues = PaddingValues(0.dp)
    fun color(
        containerColor: Color = Color.Unspecified,
        contentColor: Color = Color.Unspecified,
        disabledContentColor: Color = Color.Unspecified,
        disabledContainerColor: Color = Color.Unspecified,
        boarderColor: Color = Color.Unspecified,
    ) =
        RestaurantsButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContentColor,
            disabledContentColor = disabledContainerColor,
            boarderColor = boarderColor
        )
}
@Composable
@PreviewAllVariants
@Preview(showBackground = true)
private fun RestaurantsButtonPreview() = RestaurantsTheme {
    RestaurantsButton(
        label = "login",
        onClick = {}
    )
}