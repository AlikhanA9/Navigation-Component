package com.example.myapplicationnn

import com.example.myapplicationnn.ExampleRecyclerAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplicationnn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate
                (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment


        val listOfProduct = listOf(
            MyClass("Aidyn", 24),
            MyClass("Aydana", 24),
            MyClass("Olzhas", 26),
            MyClass("Dana", 24),
            MyClass("Bekzat", 24),
            MyClass("Albina", 24),
            MyClass("Aiko", 24),
            MyClass("Diana", 25),
            MyClass("Alikhan", 25),
            MyClass("Nurik", 25)
        )
        val alikhanAdapter = ExampleRecyclerAdapter()
        binding.recyclerView.adapter = alikhanAdapter
        val memeList = listOfProduct.map { myClassItem ->
            Meme(myClassItem.name, myClassItem.age.toString())
        }
        alikhanAdapter.submitList(memeList)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

data class MyClass(val name: String, val age: Int)


