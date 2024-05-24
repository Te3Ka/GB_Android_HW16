package ru.te3ka.homework16.di

import androidx.lifecycle.ViewModelProvider
import dagger.Component
import ru.te3ka.homework16.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

    fun viewModelFactory(): ViewModelProvider.Factory
}