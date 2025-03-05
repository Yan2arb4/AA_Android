package com.porogoramer.adventure_assistant

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.porogoramer.adventure_assistant.http.AdventureService
import com.porogoramer.adventure_assistant.http.RetrofitUtil
import com.porogoramer.adventure_assistant.http.dto.LoginResponse
import com.porogoramer.adventure_assistant.http.dto.RegisterRequest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Call
import retrofit2.Response
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    var service: AdventureService? = RetrofitUtil().get()
    var testSU: RegisterRequest = RegisterRequest("yan", "yan", "yan")

    @Test
    fun testSignUp() {
        val call: Call<String>? = service?.register(testSU)
        val response: Response<String>? = call?.execute()
        Log.i("RETROFIT", response?.body().toString())
    }
}