package com.example.myapplication.manager

import android.widget.Toast
import com.example.myapplication.SelfApplication

/**
 *@author jeason
 *@time 21-3-6 下午5:46
 *@description 该类的作用是：
 */
fun <T> T.shortToast(msg: String) {
    Toast.makeText(SelfApplication.getApplication(), msg, Toast.LENGTH_SHORT).show()
}

fun <T> T.longToast(msg: String) {
    Toast.makeText(SelfApplication.getApplication(), msg, Toast.LENGTH_LONG).show()
}