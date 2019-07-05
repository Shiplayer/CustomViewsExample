package com.example.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.AdapterView
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.element_custom_view.view.*


class ElementCustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {


    private var action: (View) -> Unit = {}

    init {
        val view = View.inflate(context, R.layout.element_custom_view, this)
        isFocusable = true
        isClickable = true

        view.setOnClickListener(action)

        context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.ElementCustomView,
                0, 0).apply {

            try {
                view.imageView.setImageDrawable(getDrawable(R.styleable.ElementCustomView_src))
                view.textView.text = getString(R.styleable.ElementCustomView_text)
            } finally {
                recycle()
            }
        }
    }

    fun setOnItemClickListener(action: (View) -> Unit) {
        setOnClickListener(action)
    }

    fun setOnItemClickListener(action: View.OnClickListener) {
        setOnClickListener(action)
    }

}