package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.example.myapplication.manager.ViewManageHandler
import com.example.myapplication.manager.ViewStack
import com.example.myapplication.param.RouteParam


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.globalActivity = this

        initLogin()
    }

    /**
     * 初始化登录页面
     */
    private fun initLogin() {
        val routeParams: RouteParam = RouteParam.createGlobalPageParam(R.layout.page_login)
        ViewManageHandler.sendPushViewMsg(R.layout.page_login, routeParams)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                return if (!ViewStack.isEmpty()) {
                    println("view size: " + ViewStack.size())
                    ViewStack.backToLastView()
                    true
                } else {
                    super.onKeyDown(keyCode, event)
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    object App {
        /**
         * 设置可见性
         */
        fun setTopMiddleBottomVisibility(titleBarVisibility: Boolean, contentVisibility: Boolean, navigatorVisibility: Boolean) {
            globalActivity.findViewById<View>(R.id.title_bar).visibility = if (titleBarVisibility) View.VISIBLE else View.GONE
            globalActivity.findViewById<View>(R.id.content_view).visibility = if (contentVisibility) View.VISIBLE else View.GONE
            globalActivity.findViewById<View>(R.id.navigation_bar).visibility = if (navigatorVisibility) View.VISIBLE else View.GONE
        }

        lateinit var globalActivity: Activity
    }

    override fun onDestroy() {
        super.onDestroy()
        ViewStack.clearAllViews()
    }
}