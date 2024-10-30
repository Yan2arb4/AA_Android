package com.porogoramer.adventure_assistant

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
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

        //Hide status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }

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
