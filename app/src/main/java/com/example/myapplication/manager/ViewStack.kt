package com.example.myapplication.manager

import android.view.View
import android.view.ViewGroup
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.proxy.ViewProxy

/**
 *@author jeason
 *@time 21-3-6 下午6:07
 *@description 该类的作用是：页面堆栈，管理View
 */
object ViewStack {

    private val viewStack: MutableList<ViewProxy?> = mutableListOf()

    private val viewContent: ViewGroup by lazy {
        MainActivity.App.globalActivity.findViewById<ViewGroup>(R.id.content_view)
    }

    fun push(viewProxy: ViewProxy) {
        val view: ViewProxy? = getTopView()
        if (view != null && view is View) {
            view.visibility = View.GONE
        }
        viewProxy.onViewWillAttach()
        viewStack.add(viewProxy)
        viewProxy.onViewAttached()
        println("view size: " + viewStack.size )
    }

    private fun getTopView(): ViewProxy? {
        if(viewStack.size < 1) {
            return null
        }
        return viewStack[viewStack.size - 1]
    }

    /**
     * 返回上一级页面
     */
    fun backToLastView() {
        var view: ViewProxy? = getTopView()
        if (view is View) {
            viewContent.removeView(view)
        }
        viewStack.remove(view)
        println("view size: " + view?.javaClass)
        val needShowView: ViewProxy? = getTopView()
        if (needShowView is View) {
            needShowView.visibility =  View.VISIBLE
        }
    }

    /**
     * 返回该viewStack是否空
     */
    fun isEmpty(): Boolean {
        return viewStack.size <= 1
    }

    fun size(): Int {
        return viewStack.size
    }

    fun clearAllViews() {
        viewStack.clear()
    }

}