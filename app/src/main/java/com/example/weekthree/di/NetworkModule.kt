package com.example.weekthree.di

import com.example.weekthree.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

//@Module
//class NetworkModule {
//
//
//
//    @Provides
//    @Singleton
//    @Named("HttpLoggingInterceptor")
//    fun provideHttpLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
//        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
//    }
//
//
//    @Singleton
//    @Provides
//    @Named("KeyInterceptor")
//    fun provideKeyInterceptor(): Interceptor = Interceptor {
//        val original: Request = it.request()
//        val originalHttpUrl = original.url()
//
//        val url = originalHttpUrl.newBuilder()
//            .addQueryParameter("api_key", BuildConfig.API_KEY)
//            .build()
//
//        val requestBuilder = original.newBuilder()
//            .url(url)
//        val request = requestBuilder.build()
//
//        it.proceed(request)
//    }
//
////    @Singleton
////    @Provides
////    fun provideAPI(@Named("HttpLoggingInterceptor") loggingInterceptor: Interceptor,
////                          @Named("KeyInterceptor") apiKeyInterceptor: Interceptor) = Retrofit
////        .Builder()
////        .client(
////            OkHttpClient.Builder().apply{
////                addNetworkInterceptor(apiKeyInterceptor)
////                addInterceptor(loggingInterceptor)
////            }.build()
////        ).baseUrl(BuildConfig.API_URL)
////        .addConverterFactory(GsonConverterFactory.create())
////        .build()
////
//
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(
//        @Named("keyInterceptor") keyInterceptor: Interceptor,
//        @Named("HttpLoggingInterceptor") httpLoggingInterceptor: HttpLoggingInterceptor
//    ) = OkHttpClient.Builder()
//        .addInterceptor(httpLoggingInterceptor)
//        .addNetworkInterceptor(keyInterceptor)
//        .build()
//
//
//    @Singleton
//    @Provides
//    fun provideRetrofit(
//        okHttpClient: OkHttpClient
//    ) =
//        Retrofit.Builder().client(okHttpClient).baseUrl(BuildConfig.API_URL).build()
//}