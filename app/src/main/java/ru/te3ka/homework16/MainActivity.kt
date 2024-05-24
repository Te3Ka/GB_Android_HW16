package ru.te3ka.homework16

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.te3ka.homework16.databinding.ActivityMainBinding
import ru.te3ka.homework16.di.ViewModelFactory
import ru.te3ka.homework16.presentation.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        getNewJoke()

        binding.buttonNewActivityJokeApi.setOnClickListener {
            viewModel.reloadJokeActivity()
        }
    }

    private fun getNewJoke() {
        lifecycleScope.launchWhenStarted {
            viewModel.reloadJokeActivity()
            viewModel.jokeActivity.collect { joke ->
                binding.textViewActivityJokeApi.text = joke?.setup ?: "Error"
                binding.textViewPunchline.text = ""

                binding.buttonShowPunchline.setOnClickListener {
                    binding.textViewPunchline.text = joke?.punchline ?: "Punchline"
                }
            }
        }
    }
}