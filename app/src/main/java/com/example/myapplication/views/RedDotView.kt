package com.example.myapplication.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * red dot view
 */
class RedDotView: View {

    constructor(context: Context):super(context)
    constructor(context: Context, attrs: AttributeSet?):super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, def: Int):super(context, attrs, def)

    private val mPaint: Paint = Paint()

    private val mRadius: Float = 15F

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.color = Color.RED
        canvas?.drawCircle(width/2F, height/2F, mRadius, mPaint)
    }
}