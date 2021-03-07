package com.example.myapplication.views

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.example.myapplication.proxy.ViewProxy

/**
 *@author jeason
 *@time 21-3-7 下午2:54
 *@description 该类的作用是：
 */
class GlobalView:RelativeLayout, ViewProxy{
    constructor(context: Context):super(context)
    constructor(context: Context, attributeSet: AttributeSet):super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, def: Int):super(context, attributeSet, def)

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