package ru.te3ka.homework16

import android.app.Application
import ru.te3ka.homework16.di.AppComponent
import ru.te3ka.homework16.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .build()
    }
}