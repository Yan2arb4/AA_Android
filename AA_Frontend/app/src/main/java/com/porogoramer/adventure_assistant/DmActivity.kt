package com.porogoramer.adventure_assistant

import android.os.Bundle
import com.porogoramer.adventure_assistant.common.BaseActivity
import com.porogoramer.adventure_assistant.databinding.ContentDmBinding

private lateinit var binding: ContentDmBinding

class DmActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentDmBinding.inflate(layoutInflater)
        layoutInflater.inflate(R.layout.content_dm, findViewById(R.id.content_frame), true)
    }
}