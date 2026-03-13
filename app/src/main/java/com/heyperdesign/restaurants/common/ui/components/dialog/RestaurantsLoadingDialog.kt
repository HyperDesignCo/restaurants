package com.heyperdesign.restaurants.common.ui.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.heyperdesign.restaurants.common.ui.preview.PreviewAllVariants
import com.heyperdesign.restaurants.common.ui.theme.RestaurantsTheme

@Composable
fun RestaurantsLoadingDialog(modifier: Modifier = Modifier) {
    Dialog(onDismissRequest = {}) {
        Box(
            modifier = modifier
                .background(color = RestaurantsTheme.colors.background.surfaceHigh, shape = RoundedCornerShape(24.dp))
                .padding(50.dp)
        ) {
            CircularProgressIndicator(color = RestaurantsTheme.colors.primary)
        }
    }
}

@PreviewAllVariants
@Composable
private fun RestaurantsLoadingDialogPreview() = RestaurantsTheme {
    RestaurantsLoadingDialog()
}