package com.porogoramer.adventure_assistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.porogoramer.adventure_assistant.databinding.ActivityPlayerBinding

private lateinit var binding : ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}