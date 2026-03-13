package com.heyperdesign.restaurants.common.ui.components.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.heyperdesign.restaurants.common.ui.preview.PreviewAllVariants
import com.heyperdesign.restaurants.common.ui.theme.RestaurantsTheme
import com.hyperdesin.restaurants.R

@Composable
fun RestaurantsPasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = stringResource(R.string.password),
    supportingText: String? = null,
) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    RestaurantsTextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = placeholder,
        colors = RestaurantsPasswordTextFieldDefaults.colors,
        onTrailingIconClicked = { isPasswordVisible = isPasswordVisible.not() },
        trailingIconRes = RestaurantsPasswordTextFieldDefaults.passwordVisibilityIcon(isVisible = isPasswordVisible),
        supportingText = supportingText,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next
        ),
        visualTransformation = RestaurantsPasswordTextFieldDefaults.passwordVisualTransformation(isPasswordVisible)
    )
}

object RestaurantsPasswordTextFieldDefaults {
    val colors
        @Composable get() = RestaurantsTextFieldDefaults.color(
            unfocusedBorderColor = RestaurantsTheme.colors.secondary,
            focusedBorderColor = RestaurantsTheme.colors.secondary,
            disabledBorderColor = RestaurantsTheme.colors.secondary,
            unfocusedContainerColor = RestaurantsTheme.colors.background.surfaceHigh,
            focusedContainerColor = RestaurantsTheme.colors.background.surfaceHigh,
            errorContainerColor = RestaurantsTheme.colors.status.redAccent,
            cursorColor = RestaurantsTheme.colors.primary
        )

    @Composable
    fun passwordVisibilityIcon(isVisible: Boolean): Int = remember(isVisible) {
        if (isVisible) R.drawable.ic_password_visible else R.drawable.ic_password_invisible
    }

    @Composable
    fun passwordVisualTransformation(isVisible: Boolean): VisualTransformation =
        remember(isVisible) { if (isVisible) VisualTransformation.None else PasswordVisualTransformation() }
}

@Composable
@PreviewAllVariants
private fun RestaurantsPasswordTextFieldPreview() = RestaurantsTheme {
    RestaurantsPasswordTextField(value = "", onValueChange = {})
} 