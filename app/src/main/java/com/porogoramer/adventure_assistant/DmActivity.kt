package com.porogoramer.adventure_assistant

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.porogoramer.adventure_assistant.databinding.ActivityDmBinding
import com.porogoramer.adventure_assistant.databinding.ActivityHomeBinding

private lateinit var binding: ActivityDmBinding

class DmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDmBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}