package ru.te3ka.homework16.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.internal.Provider
import dagger.multibindings.IntoMap
import ru.te3ka.homework16.domain.GetJokeActivityUseCase
import ru.te3ka.homework16.presentation.MainViewModel
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}