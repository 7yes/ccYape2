package com.example.ccyape2.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.ccyape2.R
import com.example.ccyape2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.frag_container) as NavHostFragment? ?: return

        binding.container.setOnClickListener {
            Toast.makeText(this, "Entro", Toast.LENGTH_SHORT).show()
        }

        setContentView(binding.root)
    }
}
