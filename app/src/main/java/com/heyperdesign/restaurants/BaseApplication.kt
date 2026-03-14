package com.heyperdesign.restaurants

import android.app.Application
import com.heyperdesign.restaurants.common.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            androidLogger()
            modules(appModule)
        }
    }
}