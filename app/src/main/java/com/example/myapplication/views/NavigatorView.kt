package com.example.myapplication.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout

/**
 *@author jeason
 *@time 21-3-6 下午10:00
 *@description 该类的作用是：
 */
class NavigatorView : RelativeLayout {
    constructor(context: Context):super(context)
    constructor(context: Context, attributeSet: AttributeSet):super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, def: Int):super(context, attributeSet, def)
}