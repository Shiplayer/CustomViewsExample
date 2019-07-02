package com.example.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.element_custom_view.view.*


class ElementCustomView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        val view = View.inflate(context, R.layout.element_custom_view, this)

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

    fun setOnClickListener(action: (View) -> Unit){
    }
}