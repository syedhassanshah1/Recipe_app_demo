package com.app.recipe.network.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OKHttpClientCreator {

    fun createCustomInterceptorClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val networkInterceptor = Interceptor {
            val request: Request = it.request()
                    .newBuilder()
                    .build()
            it.proceed(request)

        }
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(networkInterceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
    }
}