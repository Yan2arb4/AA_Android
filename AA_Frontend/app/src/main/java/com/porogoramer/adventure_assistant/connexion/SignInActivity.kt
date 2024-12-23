package com.porogoramer.adventure_assistant.connexion

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity
import com.porogoramer.adventure_assistant.HomeActivity
import com.porogoramer.adventure_assistant.databinding.ActivitySigninBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Hide status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        binding.signinBtn.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.loginOption.setOnClickListener {
            startActivity(Intent(this, LogInActivitity::class.java))
        }
    }
}