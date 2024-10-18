package com.porogoramer.adventure_assistant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.porogoramer.adventure_assistant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dmServiceBtn.setOnClickListener {
            Log.i("WORKS", "The button works")
            val intent = Intent(this, DmActivity::class.java)
            startActivity(intent)
        }

        binding.playerServiceBtn.setOnClickListener {
            Log.i("WORKS", "Player button works")
            // Add intent for Player button here if needed
            val intent = Intent(this, PlayerActivity::class.java)
            startActivity(intent)
        }
    }
}
