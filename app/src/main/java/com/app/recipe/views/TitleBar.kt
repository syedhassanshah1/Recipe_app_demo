package com.app.recipe.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.app.recipe.databinding.HeaderMainBinding
import com.app.recipe.utils.gone
import com.app.recipe.utils.invisible
import com.app.recipe.utils.visible

class TitleBar : FrameLayout {
    private var binding: HeaderMainBinding? = null

    private var backButtonListener: OnClickListener? = null

    constructor(context: Context) : super(context) {
        initLayout(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initLayout(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        initLayout(context)
    }


    private fun initLayout(context: Context) {
        this.binding = HeaderMainBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun hideButtons() {
        this.binding?.apply {
            btnLeft.invisible()
            txtHeading.gone()
        }
    }

    fun showBackButton() {
        this.binding?.apply {
            btnLeft.visible()
            btnLeft.setOnClickListener(backButtonListener)
        }
    }


    fun setHeading(heading: String?) {
        this.binding?.apply {
            txtHeading.visible()
            txtHeading.text = heading
        }
    }

    fun showTitleBar() {
        this.binding?.containerTitleBar?.visible()
    }

    fun hideTitleBar() {
        this.binding?.containerTitleBar?.gone()
    }


    fun setBackButtonListener(listener: OnClickListener?) {
        this.backButtonListener = listener
    }


}