package com.porogoramer.adventure_assistant.http.dto

class SignInRequest {
    private var username: String? = null
    private var password: String? = null
    fun signInRequest(username: String?, password: String?) {
        this.username = username
        this.password = password
    }
}