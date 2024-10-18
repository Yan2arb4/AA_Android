package com.porogoramer.adventure_assistant

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.porogoramer.adventure_assistant.databinding.ActivityPlayerBinding


private lateinit var binding : ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nv = binding.navView
        val drawer = binding.drawerLayout
        nv.setNavigationItemSelectedListener {
            Toast.makeText(this, "I AM REAL", Toast.LENGTH_SHORT).show()
            drawer.closeDrawers()
            false
        }


        binding.menuBtn.setOnClickListener{
            val drawer = binding.drawerLayout
            drawer.openDrawer(GravityCompat.START)
        }
    }
}