package com.example.gymapp

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gymapp.databinding.ActivityHomePageBinding
import com.example.gymapp.databinding.ActivityMainBinding


class homePage : AppCompatActivity() {

    lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (savedInstanceState == null){
            replaceWithFragment(Home())
        }

        binding.nagivation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item1 -> replaceWithFragment(Home())
                R.id.item2 -> replaceWithFragment(Plans())
            }
            true
        }
    }

    private fun replaceWithFragment(fragment: androidx.fragment.app.Fragment) {
        val fragmentManager =supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FrameLayout, fragment)
        fragmentTransaction.commit()
    }
}