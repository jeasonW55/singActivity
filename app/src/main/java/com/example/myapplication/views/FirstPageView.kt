package com.example.myapplication.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.example.myapplication.proxy.ViewProxy
/**
 *@author jeason
 *@time 21-3-6 下午10:28
 *@description 该类的作用是：
 */
class FirstPageView: LinearLayout, ViewProxy {
    constructor(context: Context):super(context)
    constructor(context: Context, attrs: AttributeSet?):super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, def: Int):super(context, attrs, def)

    override fun onViewWillAttach() {

    }

    override fun onViewAttached() {

    }

    override fun onViewBackground() {

    }

    override fun onViewRemoved() {

    }

    override fun onViewDestroyed(res: Any?) {

    }
}