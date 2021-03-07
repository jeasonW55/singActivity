package com.example.myapplication.proxy


/**
 *@author jeason
 *@time 21-3-6 下午3:59
 *@description 该类的作用是：用来定义View行为的协议
 */

interface ViewProxy {
    /**
     * view 将要附加到窗口上
     */
    fun onViewWillAttach()
    /**
     * view 已经附加到窗口上
     */
    fun onViewAttached()
    /**
     * view 进入后台
     */
    fun onViewBackground()
    /**
     * view 被移除掉
     */
    fun onViewRemoved()
    /**
     * view 被销毁掉用于保存一些资源
     */
    fun onViewDestroyed(res: Any?)
}