package com.myself.kotlinstudy.api

import com.myself.kotlinstudy.bean.LoginBean
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @Created by Jams
 * @Created time 2022/11/24 11:50
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2022/11/24 11:50
 * @dese todo
 */
interface WanAndroidApi {
    @POST("user/login")
    @FormUrlEncoded
    fun login(@Field("username") username:String, @Field("password")password:String):Observable<LoginBean>

    @POST("user/register")
    @FormUrlEncoded
    fun register(@Field("username") username: String, @Field("password") password: String, @Field("repassword")repassword:String):Observable<LoginBean>
}