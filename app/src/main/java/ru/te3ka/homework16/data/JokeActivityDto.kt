package ru.te3ka.homework16.data

import ru.te3ka.homework16.entity.JokeActivity

data class JokeActivityDto(
    override val id: Int,
    override val type: String,
    override val setup: String,
    override val punchline: String
) : JokeActivity