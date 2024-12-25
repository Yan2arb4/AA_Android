package com.porogoramer.adventure_assistant.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


open class RetrofitUtil {

     open fun get(): GitHubService {
        var retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com/").build()
        var service: GitHubService = retrofit.create(GitHubService::class.java)
         return service
    }
}