package com.heyoh.appdata.di

import com.heyoh.appdata.data.api.APIUrl
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return  Retrofit.Builder()
            .baseUrl(APIUrl.BASE)
            .client(OkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }
}