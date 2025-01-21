package com.porogoramer.adventure_assistant.http.dto

class SignUpRequest {
    private var username: String? = null
    private var password: String? = null
    private var confirmPassword: String? = null

    fun signUpResponse(username: String?, password: String?, confirmPassword: String?){
        this.username = username
        this.password = password
        this.confirmPassword = confirmPassword
    }
}