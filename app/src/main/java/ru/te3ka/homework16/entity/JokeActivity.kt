package ru.te3ka.homework16.entity

interface JokeActivity {
    val id: Int
    val type: String
    val setup: String
    val punchline: String
}