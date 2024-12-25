package com.porogoramer.adventure_assistant

import android.util.Log
import com.porogoramer.adventure_assistant.http.GitHubService
import com.porogoramer.adventure_assistant.http.RetrofitUtil
import com.porogoramer.adventure_assistant.transfer.User
import org.junit.Test
import retrofit2.Call
import retrofit2.Response

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testRetrofit() {
        val service: GitHubService = RetrofitUtil().get()
        val call: Call<String> = service.listRepos("Yan2arb4")

        val response: Response<String> = call.execute()
        Log.i("RETROFIT", response.body().toString())
    }

    @Test
    fun testRetrofitUser() {
        val service: GitHubService = RetrofitUtil().get()
        val call: Call<User> = service.getUser("Yan2arb4")

        val response: Response<User> = call.execute()
        Log.i("RETROFIT", response.body().toString())
    }
}