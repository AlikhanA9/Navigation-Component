package com.example.myapplicationnn

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myapplicationnn.databinding.FragmentExampleSecondBinding
import data.RetrofitService
import kotlinx.coroutines.launch

class ExampleSecondFragment : Fragment() {
    private lateinit var binding: FragmentExampleSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentExampleSecondBinding.inflate(inflater, container, false)
        return binding.root
        binding.pauk1.setImageResource(R.drawable.pauk1)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.secondEx.setOnClickListener {
            findNavController().navigate(R.id.action_exampleSecondFragment_to_exampleFirstFragment)
        }
        binding.button2.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val data = RetrofitService.apiService.getFact()
                    binding.textViewFact1.text = data.text
                } catch (e: Exception) {
                    Log.d("AAA", e.message.toString())
                }

            }

        }
    }
}

