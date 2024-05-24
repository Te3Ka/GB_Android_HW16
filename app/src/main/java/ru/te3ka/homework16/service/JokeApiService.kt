package ru.te3ka.homework16.service
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import ru.te3ka.homework16.data.JokeActivityDto

interface JokeApiService {
    @GET("/random_joke")
    suspend fun getRandomJoke(): JokeActivityDto
}