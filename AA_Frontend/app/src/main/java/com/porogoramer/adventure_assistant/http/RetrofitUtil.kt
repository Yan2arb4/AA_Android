package com.porogoramer.adventure_assistant.http

import okhttp3.CookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.security.Provider.Service


open class RetrofitUtil {
    private var instance : Service? = null

     open fun get(): Service? {
        if(instance == null){
            val retrofit: Retrofit = Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client())
                .baseUrl("https://localhost:7107/api/")
                .build()
            instance = retrofit.create(Service::class.java)
            return instance
        }else{
            return instance
        }
    }

    private fun client(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val jar: CookieJar = SessionCookieJar()

        val client = OkHttpClient.Builder()
            .cookieJar(jar)
            .addInterceptor(interceptor)
            .build()

        return client
    }
}