package com.myself.kotlinstudy.network

import android.content.Context
import com.myself.kotlinstudy.R

/**
 * @Created by Jams
 * @Created time 2022/11/24 17:49
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2022/11/24 17:49
 * @dese todo
 */
enum class ApiErrorType(val code:Int, val messageId:Int) {
    INTERNAL_SERVER_ERROR(500, R.string.service_error),
    BAD_GATEWAY(502, R.string.service_error),
    NOT_FOUND(404, R.string.not_found),
    CONNECT_TIMEOUT(408, R.string.timeout),
    NETWORK_NOT_CONNECT(499, R.string.network_error),
    UNKNOWN_ERROR(700, R.string.unknown_error);


    private val DEFAULT_CODE = 1
    fun getApiError(context: Context):ApiError {
        return ApiError(DEFAULT_CODE,context.getString(messageId))
    }

}