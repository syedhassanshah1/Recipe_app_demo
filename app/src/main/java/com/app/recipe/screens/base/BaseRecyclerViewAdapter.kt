package com.app.recipe.screens.base

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


class BaseRecyclerViewAdapter<T, R : ViewDataBinding>(private val collections: MutableList<T>,
                                                      private val viewBinder: BaseRecyclerViewBinder<T, R>,
                                                      private val mContext: Context)
    : RecyclerView.Adapter<BaseRecyclerViewBinder.BaseViewHolder<R>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewBinder.BaseViewHolder<R> {
        return viewBinder.createView(mContext)
    }

    override fun onBindViewHolder(holder: BaseRecyclerViewBinder.BaseViewHolder<R>, position: Int) {
        viewBinder.bindView(collections[position], position, holder, mContext, collections)
    }

    override fun getItemCount(): Int {
        return collections.size
    }

    fun getItemFromList(index: Int): T {
        return collections[index]
    }

    val list: List<T>
        get() = collections

    /**
     * Clears the internal list
     */
    fun clearList() {
        collections.clear()
        notifyDataSetChanged()
    }

    /**
     * Adds a entity to the list and calls [.notifyDataSetChanged].
     * Should not be used if lots of NotificationDummy are added.
     *
     * @see .addAll
     */
    fun add(entity: T) {
        collections.add(entity)
        notifyDataSetChanged()
    }

    /**
     * Adds a NotificationDummy to the list and calls
     * [.notifyDataSetChanged]. Can be used {
     * [List.subList].
     *
     * @see .addAll
     */
    fun addAll(entityList: List<T>) {
        collections.clear()
        collections.addAll(entityList)
        notifyDataSetChanged()
    }

}