package com.heyperdesign.restaurants.feature.authentication.login.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.heyperdesign.restaurants.common.ui.components.button.RestaurantsButtonPrimary
import com.heyperdesign.restaurants.common.ui.extensions.asString
import com.heyperdesign.restaurants.common.ui.extensions.clickableWithNoRipple
import com.heyperdesign.restaurants.common.ui.preview.PreviewAllVariants
import com.heyperdesign.restaurants.common.ui.theme.RestaurantsTheme
import com.heyperdesign.restaurants.feature.authentication.base.ui.AuthenticationField
import com.heyperdesign.restaurants.feature.authentication.base.ui.AuthenticationLogo
import com.heyperdesign.restaurants.feature.authentication.login.ui.viewmodel.LoginContract
import com.heyperdesign.restaurants.feature.authentication.login.ui.viewmodel.LoginScreenVM
import com.hyperdesin.restaurants.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(viewmodel: LoginScreenVM = koinViewModel()) {
    val state by viewmodel.state.collectAsStateWithLifecycle()
    LoginContent(state = state, onAction = viewmodel::onActionTrigger)
}

@Composable
private fun LoginContent(state: LoginContract.State, onAction: (LoginContract.Action) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = RestaurantsTheme.colors.background.surfaceHigh)
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AuthenticationLogo(label = stringResource(R.string.login_to_the_good_stuff))
        AuthenticationField(
            modifier = Modifier.padding(top = 21.dp),
            label = stringResource(R.string.phone),
            hint = stringResource(R.string.enter_phone),
            value = state.phone.value,
            isNumber = true,
            supportingText = state.phone.error.asString(),
            onValueChange = {
                onAction(
                    LoginContract.Action.OnPhoneChanged(it)
                )
            })
        AuthenticationField(
            label = stringResource(R.string.password),
            hint = stringResource(R.string.enter_password),
            value = state.password.value,
            supportingText = state.password.error.asString(),
            onValueChange = {
                onAction(
                    LoginContract.Action.OnPasswordChanged(it)
                )
            })
        Text(
            modifier = Modifier,
            text = stringResource(R.string.forget_your_password),
            color = RestaurantsTheme.colors.status.blueAccent,
            style = RestaurantsTheme.typography.title.medium,
            textDecoration = TextDecoration.Underline,
        )
        NotAMemberRow(onSignUpClick = { onAction(LoginContract.Action.OnSignUpClicked) })
        Spacer(
            modifier = Modifier.weight(0.05f)
        )
        RestaurantsButtonPrimary(
            modifier = Modifier.fillMaxWidth(),
            isEnabled =  state.isLoginEnabled,
            label = stringResource(R.string.login),
            onClick = { onAction(LoginContract.Action.LoginClicked) }
        )
        Spacer(
            modifier = Modifier.weight(0.230f)
        )
    }
}

@Composable
private fun NotAMemberRow(
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.not_a_member_yet),
            color = RestaurantsTheme.colors.text.text,
            style = RestaurantsTheme.typography.title.medium,
            textDecoration = TextDecoration.Underline,
        )
        Text(
            modifier = Modifier.clickableWithNoRipple { onSignUpClick() },
            text = stringResource(R.string.signup),
            color = RestaurantsTheme.colors.status.blueAccent,
            style = RestaurantsTheme.typography.title.medium,
            textDecoration = TextDecoration.Underline,
        )
    }
}
@Composable
@PreviewAllVariants
private fun LoginScreenPreview() = RestaurantsTheme {
    LoginContent(
        state = LoginContract.State(),
        onAction = {}
    )
}