package com.example.myapplication.manager

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.param.RouteParam
import com.example.myapplication.proxy.ViewProxy
import com.example.myapplication.views.ContentView
import com.example.myapplication.views.GlobalView
import com.example.myapplication.views.NavigatorView
import com.example.myapplication.views.TitleBarView

/**
 * @author jeason
 * @time 21-3-6 下午4:58
 * @description 该类的作用是：用于处理页面事件
 */
object ViewManageHandler : Handler(Looper.getMainLooper()){

    override fun handleMessage(msg: Message) {
        var routeParam: RouteParam = msg.obj as RouteParam
        when(msg.what) {
            RouteParam.pushViewToStack -> {
                switchViewByRouteParam(routeParam)
            }
        }
    }

    /**
     * 发送 view 压栈的消息
     */
    fun sendPushViewMsg(layoutId: Int, routeParam: RouteParam){
        val msg: Message = obtainMessage()
        when(routeParam.pageType) {
            RouteParam.COMMON_PAGE ->
                msg.obj = RouteParam.createCommonPageParam(layoutId)
            RouteParam.GLOBAL_PAGE ->
                msg.obj = RouteParam.createGlobalPageParam(layoutId)
        }
        //入栈切换页面
        msg.what = RouteParam.pushViewToStack
        sendMessage(msg)
    }

    /**
     * 根据 RouteParam 切换页面
     */
    private fun switchViewByRouteParam(routeParam: RouteParam) {
        val pageType: Int = routeParam.pageType
        val layoutId: Int = routeParam.layoutId

        //找到全局view
        val globalView: GlobalView = MainActivity.App.globalActivity.findViewById<View>(R.id.global_layout) as GlobalView
        when(pageType) {
            //居中布局的普通页面
            RouteParam.COMMON_PAGE -> {
                //装载TitleBar
                loadTitleBarView(routeParam)
                //装载ContentView
                loadContentView(routeParam)
                //装载NavigatorBar
                loadNavigatorBarView(routeParam)

                if (globalView is ViewProxy) {
                    ViewStack.push(globalView)
                }
            }
            //全局页面
            RouteParam.GLOBAL_PAGE -> {
                val contentLayout: View = LayoutInflater.from(globalView.context).inflate(layoutId, globalView, false)
                if (contentLayout is ViewProxy) {
                    ViewStack.push(contentLayout)
                }
                globalView.addView(contentLayout)
            }
        }
    }

    /**
     * load navigatorBarView
     */
    private fun loadNavigatorBarView(routeParam: RouteParam):NavigatorView {
        val navigatorView: NavigatorView = MainActivity.App.globalActivity.findViewById<View>(R.id.navigation_bar) as NavigatorView
        //todo
        navigatorView.removeAllViews()
        return navigatorView
    }

    /**
     * load content View
     */
    private fun loadContentView(routeParam: RouteParam): ContentView {
        val layoutId: Int = routeParam.layoutId
        val contentView: ContentView = MainActivity.App.globalActivity.findViewById<View>(R.id.content_view) as ContentView
        val needLoadContent: View = LayoutInflater.from(contentView.context).inflate(layoutId, contentView, false)
        contentView.removeAllViews()
        contentView.addView(needLoadContent)
        return contentView
    }

    /**
     * load titleBarView
     */
    private fun loadTitleBarView(routeParam: RouteParam):TitleBarView {
        //todo
        val titleBarView: TitleBarView = MainActivity.App.globalActivity.findViewById<View>(R.id.title_bar) as TitleBarView
        titleBarView.removeAllViews()
        return titleBarView
    }
}

