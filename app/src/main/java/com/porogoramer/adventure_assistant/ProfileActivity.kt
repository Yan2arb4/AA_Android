package com.porogoramer.adventure_assistant

import android.os.Bundle
import com.porogoramer.adventure_assistant.common.BaseActivity

class ProfileActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutInflater.inflate(R.layout.content_player_profile, findViewById(R.id.content_frame), true)
    }
}