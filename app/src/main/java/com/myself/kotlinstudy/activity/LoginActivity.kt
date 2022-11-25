package com.myself.kotlinstudy.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.myself.kotlinstudy.R
import kotlinx.android.synthetic.main.activity_login.*

/**
 * @Created by Jams
 * @Created time 2022/11/24 14:54
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2022/11/24 14:54
 * @dese todo
 */
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initListener()
    }

    private fun initListener() {
        login.setOnClickListener(listener)
        register.setOnClickListener(listener)
    }

    private val listener = View.OnClickListener { view ->
        run {
            when (view.id) {
                R.id.login -> {
                    login()
                }
                R.id.register -> {
                    register()
                }
            }
        }
    }

    private fun login() {


    }

    private fun register() {

    }
}

