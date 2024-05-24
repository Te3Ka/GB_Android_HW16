package ru.te3ka.homework16.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.te3ka.homework16.data.JokeActivityRepository
import ru.te3ka.homework16.service.JokeApiService
import javax.inject.Singleton

const val BASE_URL = "https://official-joke-api.appspot.com/"

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideJokeApiService(retrofit: Retrofit): JokeApiService {
        return retrofit.create(JokeApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideJokeActivityRepository(
        jokeApiService: JokeApiService
    ): JokeActivityRepository {
        return JokeActivityRepository(jokeApiService)
    }
}