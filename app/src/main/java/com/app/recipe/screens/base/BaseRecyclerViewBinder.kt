package com.app.recipe.screens.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewBinder<T, R : ViewDataBinding>(private val LayoutResId: Int) {
    fun createView(activity: Context): BaseViewHolder<R> {
        val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(LayoutResId, null)
        return BaseViewHolder(view)
    }

    abstract fun bindView(entity: T, position: Int, viewHolder: BaseViewHolder<R>?, context: Context, collections: MutableList<T>)
    class BaseViewHolder<R : ViewDataBinding>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var viewBinding: R? = DataBindingUtil.bind(itemView)
    }

}