package com.example.frgment

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.frgment.databinding.ActivityMainBinding
import com.example.frgment.fragment.ChatFragment
import com.example.frgment.fragment.HomeFragment
import com.example.frgment.fragment.SearchFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val homeFragment = HomeFragment()
        loadFragment(homeFragment)

        binding.bottomNavigationView.setOnItemSelectedListener { menu ->

           when(menu.itemId){
               R.id.navHome -> loadFragment(HomeFragment())
               R.id.navSearch -> loadFragment(SearchFragment())
               R.id.navChat -> loadFragment(ChatFragment())
           }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val manager = supportFragmentManager.beginTransaction()
        val replace = manager.replace(R.id.fragmentContainer, fragment)
        manager.commit()
    }
}