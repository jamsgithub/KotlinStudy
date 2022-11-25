package com.myself.kotlinstudy.view

import android.app.Dialog
import android.content.Context
import com.myself.kotlinstudy.R

/**
 * @Created by Jams
 * @Created time 2022/11/24 17:05
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2022/11/24 17:05
 * @dese todo
 */
object LoadingDialog {
    var dialog:Dialog? = null
    fun show(context: Context) {
        dialog = Dialog(context)
        dialog?.let {
            it.setContentView(R.layout.dialog_loading)
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            it.show()
        }
    }

    fun cancel() {
        dialog?.dismiss()
    }
}