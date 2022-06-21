package com.app.recipe.di

import com.app.recipe.BuildConfig
import com.app.recipe.network.retrofit.OKHttpClientCreator
import com.app.recipe.network.retrofit.WebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesWebService(): WebService {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OKHttpClientCreator.createCustomInterceptorClient())
                .build()
        return retrofit.create(WebService::class.java)
    }

}