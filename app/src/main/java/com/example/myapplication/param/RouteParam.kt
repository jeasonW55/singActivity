package com.example.myapplication.param

/**
 *@author jeason
 *@time 21-3-6 下午8:13
 *@description 该类的作用是：路由跳转参数
 *@param pageType 页面类型
 */
class RouteParam(val pageType:Int, val layoutId: Int) {
    companion object {
        /**
         * 入栈页面
         */
        const val pushViewToStack: Int = 0x111

        /**
         * 全屏页面
         */
        const val GLOBAL_PAGE:Int = 0

        /**
         * 普通页面
         */
        const val COMMON_PAGE:Int = 1

        /**
         * 普通页面
         */
        fun createCommonPageParam(layoutId: Int): RouteParam {
            return RouteParam(COMMON_PAGE, layoutId)
        }

        /**
         * 全局页面
         */
        fun createGlobalPageParam(layoutId: Int): RouteParam {
            return RouteParam(GLOBAL_PAGE, layoutId)
        }
    }
}