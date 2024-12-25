package com.porogoramer.adventure_assistant.http

import com.porogoramer.adventure_assistant.transfer.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<String>

    @GET("users/{user}")
    fun getUser(@Path("user") user: String): Call<User>
}
