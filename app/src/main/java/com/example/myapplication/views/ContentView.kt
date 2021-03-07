package com.example.myapplication.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout

class ContentView: FrameLayout {
    constructor(context: Context):super(context)
    constructor(context: Context, attributeSet: AttributeSet):super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, def: Int):super(context, attributeSet, def)


    fun setContentView(layoutId: Int) {
        LayoutInflater.from(context).inflate(layoutId, this, false)
    }

    fun addContentView(view: View) {
        addView(view)
    }

}
