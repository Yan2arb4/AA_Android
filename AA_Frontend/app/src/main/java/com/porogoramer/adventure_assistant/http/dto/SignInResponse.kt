package com.porogoramer.adventure_assistant.http.dto

import android.util.Log

class SignInResponse(val username : String?){
    init {
        Log.i("BACKEND_SIGNIN", "SignupRequest completed for user: $username")
    }
}