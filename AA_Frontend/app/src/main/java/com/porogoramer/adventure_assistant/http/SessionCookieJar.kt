package com.porogoramer.adventure_assistant.http

import android.util.Log
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull

class SessionCookieJar : CookieJar {

    private var cookies: MutableList<Cookie>? = null

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        this.cookies = ArrayList(cookies)
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        val validCookies: MutableList<Cookie> = java.util.ArrayList()
        if (cookies != null) {
            for (cookie in cookies!!) {
                if (cookie.matches(url) && !cookieExpire(cookie)) {
                    validCookies.add(cookie)
                    Log.i("RETROFIT", "Using cookie: $cookie")
                } else {
                    cookies!!.remove(cookie)
                }
            }
        }
        return validCookies
    }

    private fun cookieURLMatch(cookie: Cookie, url: HttpUrl): Boolean {
        return "http://${cookie.domain}".toHttpUrlOrNull()?.host == url.host
    }

    private fun cookieExpire(cookie: Cookie): Boolean {
        return cookie.expiresAt < System.currentTimeMillis()
    }
}