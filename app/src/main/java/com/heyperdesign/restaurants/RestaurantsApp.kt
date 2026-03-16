package com.heyperdesign.restaurants

import android.annotation.SuppressLint
import android.app.LocaleManager
import android.os.Build
import android.os.LocaleList
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.core.os.LocaleListCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.heyperdesign.restaurants.common.ui.components.dialog.RestaurantsLoadingDialog
import com.heyperdesign.restaurants.common.ui.components.snackbar.RestaurantsSnackBarHost
import com.heyperdesign.restaurants.common.ui.components.snackbar.showSnackbar
import com.heyperdesign.restaurants.common.ui.eventcontroller.IEventController
import com.heyperdesign.restaurants.common.ui.extensions.ObserveAsEvents
import com.heyperdesign.restaurants.common.ui.extensions.UIText
import com.heyperdesign.restaurants.common.ui.language.ILanguageEvent
import com.heyperdesign.restaurants.common.ui.loading.ILoadingEvent
import com.heyperdesign.restaurants.common.ui.message.IMessageEvent
import com.heyperdesign.restaurants.common.ui.navigation.INavigator
import com.heyperdesign.restaurants.common.ui.navigation.NavigationEvent
import com.heyperdesign.restaurants.common.ui.navigation.buildNavEntryGraph
import com.heyperdesign.restaurants.common.ui.theme.RestaurantsTheme
import com.heyperdesign.restaurants.common.ui.urlhandler.IUrlEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.compose.koinInject
import org.koin.core.qualifier.named

val LocalPadding = compositionLocalOf<PaddingValues> { PaddingValues() }

@Composable
fun RestaurantsApp(
    navigator: INavigator = koinInject(),
    navHostController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
) {
    RestaurantsTheme {
        ObserveLanguageEvent()
        ObserveMessageEvent(
            snackbarHostState = snackbarHostState,
            coroutineScope = coroutineScope
        )
        ObserveLoadingEvent()
        ObserveUrlEvent()
        ObserveAsEvents(navigator.navigationEvent) { event ->
            when (event) {
                is NavigationEvent.Navigate -> navHostController.navigate(
                    route = event.destination, builder = event.builder
                )

                is NavigationEvent.NavigateUp -> navHostController.navigateUp()
            }
        }
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding(),
            snackbarHost = {
                RestaurantsSnackBarHost(SnackbarHostState = snackbarHostState)
            },
            bottomBar = {

            }
        ) { innerPadding ->
            CompositionLocalProvider(LocalPadding provides innerPadding) {
                NavHost(
                    navController = navHostController,
                    startDestination = navigator.startGraph,
                ) {
                    buildNavEntryGraph()
                }
            }
        }
    }
}

@Composable
private fun ObserveMessageEvent(snackbarHostState: SnackbarHostState, coroutineScope: CoroutineScope) {
    val context = LocalContext.current

    @SuppressLint("LocalContextGetResourceValueCall")
    fun UIText.toMessageString(): String {
        return when (this) {
            is UIText.DynamicString -> this.value
            is UIText.StringResource -> context.getString(this.id)
        }
    }

    val messageEvent: IEventController<IMessageEvent> = koinInject(qualifier = named("MessageEvent"))
    ObserveAsEvents(messageEvent.event) { event ->
        when (event) {
            is IMessageEvent.Toast -> {
                Toast.makeText(context, event.message.toMessageString(), Toast.LENGTH_LONG).show()
            }

            is IMessageEvent.Snackbar -> {
                coroutineScope.launch { snackbarHostState.showSnackbar(context = context, event = event) }
            }
        }
    }
}

@Composable
private fun ObserveLoadingEvent() {
    val loadingEvent: IEventController<ILoadingEvent> = koinInject(qualifier = named("LoadingEvent"))
    var isLoading by remember { mutableStateOf(false) }
    ObserveAsEvents(loadingEvent.event) { event ->
        Log.d("LoadingEvent", "Event received: $event")
        when (event) {
            is ILoadingEvent.CircularProgressIndicator -> isLoading = event.isLoading
        }
    }
    if (isLoading) RestaurantsLoadingDialog()
}

@Composable
private fun ObserveUrlEvent() {
    val urlEvent: IEventController<IUrlEvent> = koinInject(qualifier = named("UrlEvent"))
    val uriHandler = LocalUriHandler.current
    ObserveAsEvents(urlEvent.event) { event ->
        when (event) {
            is IUrlEvent.OpenUrl -> uriHandler.openUri(event.url)
        }
    }
}

@Composable
fun ObserveLanguageEvent() {
    val context = LocalContext.current
    val languageEvent: IEventController<ILanguageEvent> =
        koinInject(qualifier = named("LanguageEvent"))

    ObserveAsEvents(languageEvent.event) { event ->
        when (event) {
            is ILanguageEvent.ChangeLanguage -> {
                val compatLocales =
                    LocaleListCompat.forLanguageTags(event.languageCode)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    val localeManager = context.getSystemService(LocaleManager::class.java)
                    val platformLocales = compatLocales.unwrap()
                    localeManager.applicationLocales = platformLocales as LocaleList
                } else {
                    AppCompatDelegate.setApplicationLocales(compatLocales)
                }
            }
        }
    }
}