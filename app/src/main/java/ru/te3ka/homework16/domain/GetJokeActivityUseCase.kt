package ru.te3ka.homework16.domain

import ru.te3ka.homework16.data.JokeActivityRepository
import ru.te3ka.homework16.entity.JokeActivity
import javax.inject.Inject

class GetJokeActivityUseCase @Inject constructor(
    private val repository: JokeActivityRepository
) {
    suspend fun execute(): JokeActivity {
        println("Execute")
        return repository.getJokeActivity()
    }
}