package com.example.myapplication.views

import android.content.Context
import android.os.Message
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.RelativeLayout
import com.example.myapplication.R
import com.example.myapplication.manager.ViewManageHandler
import com.example.myapplication.param.RouteParam
import com.example.myapplication.proxy.ViewProxy

/**
 *@author jeason
 *@time 21-3-6 下午9:17
 *@description 该类的作用是：用于用户进行登录到应用内部
 */
class LoginPageView: RelativeLayout, ViewProxy, View.OnClickListener {
    constructor(context: Context):super(context)
    constructor(context: Context, attrs: AttributeSet?):super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, def: Int):super(context, attrs, def)

    override fun onViewWillAttach() {
        LayoutInflater.from(context).inflate(R.layout.page_login, this, false)
    }

    override fun onViewAttached() {
        findViewById<View>(R.id.user_login).setOnClickListener(this)
        findViewById<View>(R.id.user_name).setOnClickListener(this)
        findViewById<View>(R.id.user_passwd).setOnClickListener(this)
    }

    override fun onViewBackground() {

    }

    override fun onViewRemoved() {

    }

    override fun onViewDestroyed(res: Any?) {

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.user_login -> {
                if (findViewById<EditText>(R.id.user_name).getText().toString().isEmpty()) {
                    return
                }
                val routParam = RouteParam.createCommonPageParam(R.layout.page_first_page)
                ViewManageHandler.sendPushViewMsg(R.layout.page_first_page, routParam)
            }
        }
    }
}