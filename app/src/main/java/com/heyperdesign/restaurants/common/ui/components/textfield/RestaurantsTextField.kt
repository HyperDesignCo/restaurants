package com.heyperdesign.restaurants.common.ui.components.textfield

import com.heyperdesign.restaurants.common.ui.theme.RestaurantsTheme
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.heyperdesign.restaurants.common.ui.extensions.autoMirror
import com.heyperdesign.restaurants.common.ui.extensions.clickableWithNoRipple
import com.heyperdesign.restaurants.common.ui.preview.PreviewAllVariants

@Composable
fun RestaurantsTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = RestaurantsTextFieldDefaults.isEnabled,
    textStyle: TextStyle = RestaurantsTextFieldDefaults.textStyle,
    placeholder: String? = null,
    @DrawableRes leadingIconRes: Int? = null,
    @DrawableRes trailingIconRes: Int? = null,
    readOnly: Boolean = RestaurantsTextFieldDefaults.isReadOnly,
    leadingIconColor: Color? = null,
    trailingIconColor: Color? = null,
    supportingText: String? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = RestaurantsTextFieldDefaults.keyboardOptions,
    keyboardActions: KeyboardActions = RestaurantsTextFieldDefaults.keyboardActions,
    singleLine: Boolean = RestaurantsTextFieldDefaults.singleLine,
    maxLines: Int = RestaurantsTextFieldDefaults.maxLines,
    minLines: Int = RestaurantsTextFieldDefaults.minLines,
    shape: Shape = RestaurantsTextFieldDefaults.shape,
    colors: DeliveryUserTextInputFieldColors = RestaurantsTextFieldDefaults.color(),
    textAlign: TextAlign = RestaurantsTextFieldDefaults.textAlign,
    onTrailingIconClicked: () -> Unit = {},
    onLeadingIconClicked: () -> Unit = {},
) {

    OutlinedTextField(
        modifier = modifier,
        enabled = enabled,
        value = value,
        readOnly = readOnly,
        textStyle = RestaurantsTheme.typography.body.medium,
        leadingIcon = leadingIconRes?.let {
            {
                leadingIconColor?.let {
                    RestaurantsTextFieldIcon(
                        contentColor = it,
                        leadingIconRes = leadingIconRes,
                        onIconClicked = onLeadingIconClicked
                    )
                } ?: RestaurantsTextFieldIcon(
                    contentColor = colors.contentColor,
                    leadingIconRes = leadingIconRes,
                    onIconClicked = onLeadingIconClicked
                )
            }
        },
        trailingIcon = trailingIconRes?.let {
            {
                trailingIconColor?.let {
                    RestaurantsTextFieldIcon(
                        contentColor = it,
                        leadingIconRes = trailingIconRes,
                        onIconClicked = onTrailingIconClicked
                    )
                } ?: RestaurantsTextFieldIcon(
                    contentColor = colors.contentColor,
                    leadingIconRes = trailingIconRes,
                    onIconClicked = onTrailingIconClicked
                )

            }
        },
        supportingText = {
            supportingText?.let {
                Text(
                    text = it,
                    color = colors.errorContainerColor,
                    style = RestaurantsTextFieldDefaults.supportingTextStyle,
                    minLines = 1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = textAlign
                )
            }
        },
        onValueChange = { newValue ->
            onValueChange(newValue)
        },
        placeholder = {
            placeholder?.let {
                Text(
                    text = it,
                    style = textStyle,
                    color = colors.contentColor,
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = colors.contentColor,
            unfocusedTextColor = colors.contentColor,
            disabledTextColor = colors.contentColor,
            unfocusedBorderColor = colors.unfocusedBorderColor,
            cursorColor =colors.cursorColor ,
            focusedBorderColor = colors.focusedBorderColor,
            disabledBorderColor = colors.disabledBorderColor,
            unfocusedContainerColor = colors.unfocusedContainerColor,
            focusedContainerColor = colors.focusedContainerColor,
            disabledContainerColor = colors.disabledContainerColor,
            errorContainerColor = colors.errorContainerColor,
        ),
        shape = shape,
        minLines = minLines,
        maxLines = maxLines,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        singleLine = singleLine,
        isError = isError
    )
}

data class DeliveryUserTextInputFieldColors(
    val focusedBorderColor: Color = Color.Unspecified,
    val unfocusedBorderColor: Color = Color.Unspecified,
    val disabledBorderColor: Color = Color.Unspecified,
    val focusedContainerColor: Color = Color.Unspecified,
    val unfocusedContainerColor: Color = Color.Unspecified,
    val disabledContainerColor: Color = Color.Unspecified,
    val errorContainerColor: Color = Color.Unspecified,
    val contentColor: Color = Color.Unspecified,
    val cursorColor: Color = Color.Unspecified,
)

object RestaurantsTextFieldDefaults {
    val textStyle
        @Composable
        get() = RestaurantsTheme.typography.title.medium
    val supportingTextStyle
        @Composable
        get() = RestaurantsTheme.typography.body.medium
    val shape = RoundedCornerShape(8.dp)
    val singleLine: Boolean = false
    val minLines = 1
    val maxLines = if (singleLine) 1 else Int.MAX_VALUE
    val keyboardOptions: KeyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next
    )
    val keyboardActions: KeyboardActions = KeyboardActions.Default
    val iconSize = 20.dp
    val isEnabled = true
    val isReadOnly = false
    val textAlign = TextAlign.Start

    @Composable
    fun color(
        focusedBorderColor: Color = RestaurantsTheme.colors.secondary,
        unfocusedBorderColor: Color = RestaurantsTheme.colors.secondary,
        disabledBorderColor: Color = RestaurantsTheme.colors.secondary,
        focusedContainerColor: Color = RestaurantsTheme.colors.background.surfaceHigh,
        unfocusedContainerColor: Color = RestaurantsTheme.colors.background.surfaceHigh,
        disabledContainerColor: Color = RestaurantsTheme.colors.background.surfaceHigh,
        errorContainerColor: Color = RestaurantsTheme.colors.status.redAccent,
        contentColor: Color = RestaurantsTheme.colors.secondary,
        cursorColor: Color = RestaurantsTheme.colors.primary
    ) = DeliveryUserTextInputFieldColors(
        focusedBorderColor = focusedBorderColor,
        unfocusedBorderColor = unfocusedBorderColor,
        disabledBorderColor = disabledBorderColor,
        focusedContainerColor = focusedContainerColor,
        unfocusedContainerColor = unfocusedContainerColor,
        disabledContainerColor = disabledContainerColor,
        errorContainerColor = errorContainerColor,
        contentColor = contentColor,
        cursorColor = cursorColor
    )
}

@Composable
private fun RestaurantsTextFieldIcon(
    @DrawableRes leadingIconRes: Int,
    contentColor: Color,
    onIconClicked: () -> Unit,
) {
    Icon(
        modifier = Modifier
            .size(RestaurantsTextFieldDefaults.iconSize)
            .autoMirror()
            .clickableWithNoRipple {
                onIconClicked()
            },
        tint = contentColor,
        imageVector = ImageVector.vectorResource(leadingIconRes),
        contentDescription = null
    )
}

@PreviewAllVariants
@Composable
@Preview(showBackground = true)
fun RestaurantsTextFieldPreview() = RestaurantsTheme {
    RestaurantsTextField(
        value = "password",
        onValueChange = {},
        placeholder = "password",
        colors = RestaurantsTextFieldDefaults.color(
            unfocusedBorderColor = RestaurantsTheme.colors.secondary,
            focusedBorderColor = RestaurantsTheme.colors.secondary,
            disabledBorderColor = RestaurantsTheme.colors.secondary,
            unfocusedContainerColor = RestaurantsTheme.colors.background.surfaceHigh,
            focusedContainerColor = RestaurantsTheme.colors.background.surfaceHigh,
            errorContainerColor = RestaurantsTheme.colors.status.redAccent,
        ),
        supportingText = "password does not match"
    )
}