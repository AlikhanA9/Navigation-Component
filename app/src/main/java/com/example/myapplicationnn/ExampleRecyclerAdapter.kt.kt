package com.example.myapplicationnn

import com.bumptech.glide.Glide
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnn.databinding.ExampleAdapterBinding

class ExampleRecyclerAdapter : RecyclerView.Adapter<ExampleRecyclerAdapter.ExampleViewHolder>() {

    private val adapterList = mutableListOf<Meme>()

    inner class ExampleViewHolder(private val binding: ExampleAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Meme) {
            binding.clasText1.text = item.name
            binding.clasText2.text = item.url.toString()

            Glide.with(binding.root.context)
                .load(item.url)
                .into(binding.memeImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val binding = ExampleAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExampleViewHolder(binding)
    }

    override fun getItemCount(): Int = adapterList.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.onBind(adapterList[position])
    }

    fun submitList(list: List<Meme>) {
        adapterList.clear()
        adapterList.addAll(list)
        notifyDataSetChanged()
    }

}







