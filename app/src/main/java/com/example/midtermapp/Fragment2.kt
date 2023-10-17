package com.example.midtermapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.midtermapp.databinding.GameFragmentTwoBinding


class Fragment2 : Fragment() {

    private var _binding: GameFragmentTwoBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MidtermAppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GameFragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.numOfAttempts.observe(viewLifecycleOwner, Observer { attempts ->
            binding.numOfAttempts.text = "$attempts"
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // To avoid memory leaks
    }

}
