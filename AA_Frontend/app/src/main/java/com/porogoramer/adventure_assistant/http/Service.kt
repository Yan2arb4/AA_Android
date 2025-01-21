package com.porogoramer.adventure_assistant.http

import com.porogoramer.adventure_assistant.http.dto.LoginRequest
import com.porogoramer.adventure_assistant.http.dto.LoginResponse
import com.porogoramer.adventure_assistant.http.dto.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AdventureService {
    @POST("Users/Register")
    fun register(@Body registerRequest: RegisterRequest): Call<LoginResponse>

    @POST("Users/Login")
    fun Login(@Body loginRequest: LoginRequest): Call<LoginResponse>
}
