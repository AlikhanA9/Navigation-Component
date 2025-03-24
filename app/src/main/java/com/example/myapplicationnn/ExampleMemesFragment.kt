package com.example.myapplicationnn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myapplicationnn.databinding.FragmentExampleMemesBinding
import data.RetrofitService
import kotlinx.coroutines.launch

class ExampleMemesFragment : Fragment() {

    private var _binding: FragmentExampleMemesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExampleMemesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_exampleMemesFragment_to_exampleFirstFragment)
        }

        lifecycleScope.launch {
            try {
                val response = RetrofitService.apiServiceMemes.getMemes()
                val listMemes: List<Meme> = response.data.memes
                val adapter = ExampleRecyclerAdapter()
                binding.rViewMemes.adapter = adapter
                adapter.submitList(listMemes)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
