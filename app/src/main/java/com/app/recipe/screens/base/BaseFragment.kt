package com.app.recipe.screens.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.app.recipe.MainActivity
import com.app.recipe.views.TitleBar
import dagger.hilt.android.AndroidEntryPoint

@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<T : ViewDataBinding>(@LayoutRes private val layoutId: Int) : Fragment() {


    protected lateinit var binding: T

    protected val mainActivity by lazy {
        requireActivity() as MainActivity
    }

    protected val titleBar by lazy {
        mainActivity.mTitleBar
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onResume() {
        super.onResume()
        fragmentResume()
    }

    private fun fragmentResume() {
        setTitleBar(titleBar)
    }


    /**
     * This is called in the end to modify titlebar. after all changes.
     *
     * @param
     */
    open fun setTitleBar(titleBar: TitleBar?) {
        titleBar?.showTitleBar()
        // titleBar.refreshListener();
    }

}