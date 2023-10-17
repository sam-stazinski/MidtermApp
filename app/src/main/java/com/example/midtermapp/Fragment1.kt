package com.example.midtermapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.midtermapp.databinding.GameFragmentOneBinding


class Fragment1 : Fragment() {

    // Declare view binding variable
    private var _binding: GameFragmentOneBinding? = null
    private val binding get() = _binding!!

    private var randomNumber = (1..100).random()
    private var guessCount = 0


    private val viewModel: MidtermAppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GameFragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Value", "Number to Guess: $randomNumber")
        setupListeners2()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*
    private fun setupListeners() {
        // Handle decrement
        binding.btnMinus.setOnClickListener {
            val currentVal = editTextNumber.text.toString().toIntOrNull()
            if (currentVal != null && currentVal > 1) {
                binding.etNumber.setText((currentVal - 1).toString())
            }
        }

        // Handle increment
        binding.btnPlus.setOnClickListener {
            val currentVal = binding.etNumber.text.toString().toIntOrNull()
            if (currentVal != null && currentVal < 100) {
                binding.etNumber.setText((currentVal + 1).toString())
            }
        }

        // Handle OK button
        binding.btnOk.setOnClickListener {
            val guess = binding.etNumber.text.toString().toIntOrNull()
            if (guess != null) {
                guessCount++
                // Update guess count in shared ViewModel
                // sharedViewModel.updateGuessCount(guessCount)

                if (guess == randomNumber) {
                    // TODO: Handle correct guess, e.g., save to database and finish screen
                } else {
                    // TODO: Update UI or sound an alarm if the guess is incorrect
                    // You can use the following logic to check if the guessed number is higher or lower
                    if (guess < randomNumber) {
                        // Show a toast saying the guessed number is lower
                    } else {
                        // Show a toast saying the guessed number is higher
                    }
                }
            }
        }
    }

     */


    private fun setupListeners2() {
        var currentGuessValue = 0

        binding.btnMinus.setOnClickListener {
            currentGuessValue = (binding.etNumber.text.toString().toIntOrNull() ?: 0) - 1
            binding.etNumber.setText(currentGuessValue.toString())
        }

        binding.btnPlus.setOnClickListener {
            currentGuessValue = (binding.etNumber.text.toString().toIntOrNull() ?: 0) + 1
            binding.etNumber.setText(currentGuessValue.toString())
        }

        binding.btnOk.setOnClickListener {
            val guessedNumber = binding.etNumber.text.toString().toIntOrNull()

            if (guessedNumber != null) {
                viewModel.guess.value = guessedNumber // Set guessed number to ViewModel.

                if (guessedNumber < randomNumber) {
                    Toast.makeText(context, "Your guess is low!", Toast.LENGTH_SHORT).show()
                    //TODO
                    // Alarm for wrong guess
                } else if (guessedNumber > randomNumber) {
                    Toast.makeText(context, "Your guess is high!", Toast.LENGTH_SHORT).show()
                    //TODO
                    // Alarm for wrong guess
                } else {
                    Toast.makeText(context, "Congratulations! Correct guess.", Toast.LENGTH_SHORT).show()
                    viewModel.incrementAttempts()
                    //TODO
                    // Store data of the users score

                    val num = viewModel.numOfAttempts.value
                    val name = binding.etName.text
                    Log.d("Value", "From Fragment1 $num $name")

                    // Had to do this inorder to have default values for safeargs
                    this.findNavController().navigate(Fragment1Directions.actionFragment1ContainerToActivityMain().apply {
                        numOfAttempts = 69
                        playerName = "test"
                    })
                    val action = Fragment1Directions.actionFragment1ContainerToActivityMain()
                    view?.findNavController()?.navigate(action)
                }

                viewModel.incrementAttempts()
            } else {
                Toast.makeText(context, "Please enter a valid guess!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
