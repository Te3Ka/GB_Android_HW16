package ru.te3ka.homework16.data

import ru.te3ka.homework16.entity.JokeActivity
import ru.te3ka.homework16.service.JokeApiService
import javax.inject.Inject

class JokeActivityRepository @Inject constructor(
    private val jokeApiService: JokeApiService
) {
    suspend fun getJokeActivity(): JokeActivity {
        println("Fetching joke activity...")
        try {
            val jokeActivityDto = jokeApiService.getRandomJoke()
            println("Success: $jokeActivityDto")
            return JokeActivityDto(
                id = jokeActivityDto.id,
                type = jokeActivityDto.type,
                setup = jokeActivityDto.setup,
                punchline = jokeActivityDto.punchline
            )
        } catch (ex: Exception) {
            println("Error: ${ex.message}")
            throw ex
        }
    }
}