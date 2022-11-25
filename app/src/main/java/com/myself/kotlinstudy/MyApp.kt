package com.myself.kotlinstudy

import android.app.Application
import com.myself.kotlinstudy.network.ApiClient

/**
 * @Created by Jams
 * @Created time 2022/11/24 16:52
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2022/11/24 16:52
 * @dese todo
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ApiClient.instance.createRetrofit()
    }
}