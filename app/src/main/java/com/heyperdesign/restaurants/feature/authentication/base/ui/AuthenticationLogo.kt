package com.heyperdesign.restaurants.feature.authentication.base.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.heyperdesign.restaurants.common.ui.preview.PreviewAllVariants
import com.heyperdesign.restaurants.common.ui.theme.RestaurantsTheme
import com.hyperdesin.restaurants.R

@Composable
fun AuthenticationLogo(label: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = Modifier
                .padding(end = 22.dp)
                .weight(1f),
            text = label,
            color = RestaurantsTheme.colors.text.text,
            style = RestaurantsTheme.typography.headline.extraLarge,
            minLines = 2,
            maxLines = 2,
        )
        Image(
            modifier = Modifier.weight(1f),
            painter = painterResource(R.drawable.img_app_logo), contentDescription = null
        )
    }
}

@PreviewAllVariants
@Composable
private fun AuthenticationLogoPreview() = RestaurantsTheme {
    AuthenticationLogo(label = "Login to the good stuff")
}