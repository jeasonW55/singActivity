package com.example.myapplication.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.myapplication.R
import com.example.myapplication.proxy.BarView
import com.example.myapplication.proxy.ViewProxy

/**
 *@author jeason
 *@time 21-3-6 下午3:46
 *@description 该类的作用是：顶部标题栏
 */
class TitleBarView(context: Context, attributeSet: AttributeSet?, def: Int) : FrameLayout(context, attributeSet, def),ViewProxy,BarView {
    constructor(context: Context, attributeSet: AttributeSet?):this(context, attributeSet, 0)
    constructor(context: Context):this(context,null) {
    }

    override fun initBarLayout():Unit {
        val layout: View = LayoutInflater.from(context).inflate(R.layout.layout_title_bar, this, false);
    }

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