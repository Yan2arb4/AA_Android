package com.porogoramer.adventure_assistant.activities.player

import android.os.Bundle
import com.porogoramer.adventure_assistant.R
import com.porogoramer.adventure_assistant.common.BaseActivity
import com.porogoramer.adventure_assistant.databinding.ContentPlayerProfileBinding

class PlayerActivity : BaseActivity() {
    private lateinit var binding: ContentPlayerProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentPlayerProfileBinding.inflate(layoutInflater)
        layoutInflater.inflate(R.layout.content_player_profile, findViewById(R.id.content_frame), true)
        setTitle("{{Character.name}}")
    }
}