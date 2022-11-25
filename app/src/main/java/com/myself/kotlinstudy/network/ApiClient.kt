package com.myself.kotlinstudy.network

import com.google.android.material.transition.Hold
import com.myself.kotlinstudy.BuildConfig
import com.myself.kotlinstudy.api.WanAndroidApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.HTTP

/**
 * @Created by Jams
 * @Created time 2022/11/24 16:12
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2022/11/24 16:12
 * @dese todo
 */
class ApiClient private constructor(){
    lateinit var service:WanAndroidApi
    private object Holder {
        val INSTANCE = ApiClient()
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
        const val BASE_URL = "https://www.wanandroid.com/"
    }

    open fun createRetrofit() {
        /*val client:OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))
            .build()*/
        val client = OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().setLevel(
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            ))
        }.build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        service = retrofit.create(WanAndroidApi::class.java)
    }


}