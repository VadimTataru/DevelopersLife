package com.example.developerslife.app

import android.app.Application
import com.example.developerslife.di.ApplicationComponent
import com.example.developerslife.di.DaggerApplicationComponent

class App: Application() {
    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent
            .builder()
            .build()
    }
}