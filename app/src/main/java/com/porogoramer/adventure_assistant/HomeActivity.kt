package com.porogoramer.adventure_assistant

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.porogoramer.adventure_assistant.connexion.LogInActivitity
import com.porogoramer.adventure_assistant.databinding.ActivityHomeBinding
import com.porogoramer.adventure_assistant.player.PlayersActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.hideStatusBar()
        val toolbar: Toolbar = findViewById(R.id.toolbar_home)
        setSupportActionBar(toolbar)
        setTitle("Home Page")

        binding.dmBtn.setOnClickListener {
            startActivity(Intent(this, DmActivity::class.java))
        }

        binding.playersBtn.setOnClickListener {
            startActivity(Intent(this, PlayersActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_disconnect) {
            startActivity(Intent(this, LogInActivitity::class.java))
        }
        return true
    }


    fun hideStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }
}
