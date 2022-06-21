package com.app.recipe.screens.recipeDetail.ui

import android.os.Bundle
import android.view.View
import com.app.recipe.R
import com.app.recipe.databinding.FragmentRecipeDetailSummeryBinding
import com.app.recipe.screens.base.BaseFragment

class RecipeSummeryFragment : BaseFragment<FragmentRecipeDetailSummeryBinding>(R.layout.fragment_recipe_detail_summery) {
    private val summery by lazy {
        arguments?.getString("summery")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.summery = summery
    }

    companion object {
        fun newInstance(summery: String?): RecipeSummeryFragment {
            val args = Bundle()
            args.putString("summery", summery)
            val fragment = RecipeSummeryFragment()
            fragment.arguments = args
            return fragment
        }
    }

}