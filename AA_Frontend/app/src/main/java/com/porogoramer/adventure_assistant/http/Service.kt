package com.porogoramer.adventure_assistant.http

import com.porogoramer.adventure_assistant.http.dto.SignInRequest
import com.porogoramer.adventure_assistant.http.dto.SignInResponse
import com.porogoramer.adventure_assistant.transfer.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface GitHubService {
    @POST("Users/Register")
    fun signUp(@Body signInRequest: SignInRequest): Call<SignInResponse>

    @POST("Users/Login")
    fun signIn(@Body signInRequest: SignInRequest): Call<SignInResponse>
}
