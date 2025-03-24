package com.example.myapplicationnn

import com.example.myapplicationnn.Meme
import com.example.myapplicationnn.FactBackMemes

data class FactBackMemes(
    val data: Data,
    val success: Boolean
) {
    data class Data(
        val memes: List<Meme>
    ) {
        class Memes {

        }
    }
}
