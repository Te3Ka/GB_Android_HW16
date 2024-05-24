package ru.te3ka.homework16.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.te3ka.homework16.domain.GetJokeActivityUseCase
import ru.te3ka.homework16.entity.JokeActivity
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getJokeActivityUseCase: GetJokeActivityUseCase
) : ViewModel() {

    private val _jokeActivity = MutableStateFlow<JokeActivity?>(null)
    val jokeActivity: StateFlow<JokeActivity?> = _jokeActivity

    fun reloadJokeActivity() {
        viewModelScope.launch {
            try {
                val activity = getJokeActivityUseCase.execute()
                _jokeActivity.value = activity
            } catch (ex: Exception) {
                _jokeActivity.value = null
                println("Error: ${ex.message}")
                ex.printStackTrace()
            }
        }
    }
}