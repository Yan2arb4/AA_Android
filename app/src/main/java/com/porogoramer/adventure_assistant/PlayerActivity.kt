package com.porogoramer.adventure_assistant

import android.os.Bundle
import com.porogoramer.adventure_assistant.common.BaseActivity
import com.porogoramer.adventure_assistant.databinding.ContentPlayerBinding


private lateinit var binding : ContentPlayerBinding

class PlayerActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentPlayerBinding.inflate(layoutInflater)
        layoutInflater.inflate(R.layout.content_player, findViewById(R.id.content_frame), true)
    }
}