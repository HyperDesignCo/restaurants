package com.heyperdesign.restaurants.feature.authentication.base.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.heyperdesign.restaurants.common.ui.components.textfield.RestaurantsTextField
import com.heyperdesign.restaurants.common.ui.components.textfield.RestaurantsTextFieldDefaults
import com.heyperdesign.restaurants.common.ui.preview.PreviewAllVariants
import com.heyperdesign.restaurants.common.ui.theme.RestaurantsTheme

@Composable
fun AuthenticationField(
    label: String,
    hint: String,
    value: String,
    supportingText: String,
    modifier: Modifier = Modifier,
    isNumber: Boolean = false,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            modifier = Modifier,
            text = label,
            color = RestaurantsTheme.colors.text.text,
            style = RestaurantsTheme.typography.title.extraLarge,
        )
        RestaurantsTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            supportingText = supportingText,
            placeholder = hint,
            keyboardOptions = if (isNumber) RestaurantsTextFieldDefaults.keyboardOptions.copy(
                keyboardType = KeyboardType.Number
            ) else RestaurantsTextFieldDefaults.keyboardOptions
        )
    }
}

@PreviewAllVariants
@Composable
private fun AuthenticationFieldPreview() = RestaurantsTheme {
    AuthenticationField(
        label = "Phone",
        hint = "Enter Phone",
        value = "",
        onValueChange = {},
        supportingText = ""
    )
}