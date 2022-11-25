package com.myself.kotlinstudy.network

import android.content.Context
import com.google.gson.Gson
import com.myself.kotlinstudy.view.LoadingDialog
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException

/**
 * @Created by Jams
 * @Created time 2022/11/24 16:55
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2022/11/24 16:55
 * @dese todo
 */
abstract class ApiResponse<T>(private val context: Context) : Observer<T> {
    private var isShowLoading = true
    constructor(context: Context, isShowLoading:Boolean = false):this(context) {
        this.isShowLoading = isShowLoading
    }
    abstract fun success(data:T)
    abstract fun failure(statusCode:Int, apiError:ApiError)

    override fun onSubscribe(d: Disposable?) {
        // 加载中dialog
        if (isShowLoading) {
            LoadingDialog.show(context)
        }
    }

    override fun onNext(data : T) {
        success(data)
    }

    override fun onError(e: Throwable?) {
        // 取消加载中dialog
        LoadingDialog.cancel()
        if (e is HttpException) {
            val apiError = when(e.code()) {
                ApiErrorType.INTERNAL_SERVER_ERROR.code -> {
                    ApiErrorType.INTERNAL_SERVER_ERROR.getApiError(context)
                }
                ApiErrorType.BAD_GATEWAY.code -> {
                    ApiErrorType.BAD_GATEWAY.getApiError(context)
                }
                ApiErrorType.NOT_FOUND.code -> {
                    ApiErrorType.NOT_FOUND.getApiError(context)
                }
                else -> otherException(e)
            }
        }
    }

    override fun onComplete() {
        // 取消加载中dialog
        LoadingDialog.cancel()
    }

    private fun otherException(e:HttpException) = Gson().fromJson(e.response()?.errorBody()
        ?.charStream(), ApiError::class.java)

}
