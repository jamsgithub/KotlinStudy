package com.myself.kotlinstudy.bean

/**
 * @Created by Jams
 * @Created time 2022/11/24 16:06
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2022/11/24 16:06
 * @dese todo
 */
data class ResponseWrapper<T>(var errorCode:Int, var errorMsg:String,var data:T)