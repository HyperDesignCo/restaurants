package com.heyperdesign.restaurants.feature.entry.onboarding.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.heyperdesign.restaurants.common.ui.components.button.RestaurantsButtonPrimary
import com.heyperdesign.restaurants.common.ui.components.button.RestaurantsButtonSecondary
import com.heyperdesign.restaurants.common.ui.preview.PreviewAllVariants
import com.heyperdesign.restaurants.common.ui.theme.RestaurantsTheme
import com.heyperdesign.restaurants.feature.entry.onboarding.ui.viewmodel.OnBoardingContract
import com.heyperdesign.restaurants.feature.entry.onboarding.ui.viewmodel.OnBoardingViewModel
import com.hyperdesin.restaurants.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun OnBoardingScreen(viewmodel: OnBoardingViewModel = koinViewModel()) {
    val state by viewmodel.state.collectAsStateWithLifecycle()
    OnBoardingContent(state = state, onAction = viewmodel::onActionTrigger)
}

@Composable
private fun OnBoardingContent(state: OnBoardingContract.State, onAction: (OnBoardingContract.Action) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = RestaurantsTheme.colors.background.surfaceHigh)
            .padding(horizontal = 16.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(
                state.currentPage.image
            ),
            contentDescription = null
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(state.currentPage.title),
            color = RestaurantsTheme.colors.text.text,
            style = RestaurantsTheme.typography.headline.medium,
            textAlign = TextAlign.Start
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(state.currentPage.description),
            color = RestaurantsTheme.colors.text.text,
            style = RestaurantsTheme.typography.body.extraLarge,
            textAlign = TextAlign.Start
        )
        if (state.isLastPage.not())
            RestaurantsButtonPrimary(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(state.currentPage.buttonLabel),
                onClick = { onAction(OnBoardingContract.Action.OnNextClicked) }
            )
        else
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RestaurantsButtonSecondary(
                    modifier = Modifier.weight(1f),
                    label = stringResource(R.string.login),
                    onClick = { onAction(OnBoardingContract.Action.OnNextClicked) }
                )
                RestaurantsButtonPrimary(
                    modifier = Modifier.weight(1f),
                    label = stringResource(R.string.signup),
                    onClick = { onAction(OnBoardingContract.Action.OnNextClicked) }
                )
            }
        Spacer(modifier = Modifier.weight(0.303f))
    }
}

@PreviewAllVariants
@Composable
private fun OnBoardingScreenPreview() = RestaurantsTheme {
    OnBoardingContent(
        state = OnBoardingContract.State(
            pages = OnBoardingContract.Page.entries,
        ),
        onAction = {}
    )
}