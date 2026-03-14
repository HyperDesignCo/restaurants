package com.heyperdesign.restaurants.common.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.heyperdesign.restaurants.common.data.repository.local.LocalDataSourceProvider
import com.heyperdesign.restaurants.common.data.repository.remote.ApiService
import com.heyperdesign.restaurants.common.data.repository.remote.RemoteDataSourceProvider
import com.heyperdesign.restaurants.common.data.repository.remote.provideHttpClient
import com.heyperdesign.restaurants.common.domain.local.ILocalDataSourceProvider
import com.heyperdesign.restaurants.common.domain.remote.IRemoteDataSourceProvider
import com.heyperdesign.restaurants.common.ui.eventcontroller.EventController
import com.heyperdesign.restaurants.common.ui.eventcontroller.IEventController
import com.heyperdesign.restaurants.common.ui.language.ILanguageEvent
import com.heyperdesign.restaurants.common.ui.loading.ILoadingEvent
import com.heyperdesign.restaurants.common.ui.message.IMessageEvent
import com.heyperdesign.restaurants.common.ui.navigation.IEntryGraph
import com.heyperdesign.restaurants.common.ui.navigation.INavigator
import com.heyperdesign.restaurants.common.ui.navigation.Navigator
import com.heyperdesign.restaurants.common.ui.urlhandler.IUrlEvent
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single<INavigator> { Navigator(startGraph = IEntryGraph.RootGraph) }
    single<IEventController<IMessageEvent>>(qualifier = named("MessageEvent")) { EventController() }
    single<IEventController<ILoadingEvent>>(qualifier = named("LoadingEvent")) { EventController() }
    single<IEventController<ILanguageEvent>>(qualifier = named("LanguageEvent")) { EventController() }
    single<IEventController<IUrlEvent>>(qualifier = named("UrlEvent")) { EventController() }
    single<Json> {
        Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
            encodeDefaults = true
        }
    }
    single<DataStore<Preferences>> {
        PreferenceDataStoreFactory.create {
            get<Context>().preferencesDataStoreFile("delivary_user_datastore")
        }
    }
    singleOf(::LocalDataSourceProvider) bind ILocalDataSourceProvider::class
    single<ApiService> { ApiService(provideHttpClient(get())) }
    singleOf(::RemoteDataSourceProvider) bind IRemoteDataSourceProvider::class
}