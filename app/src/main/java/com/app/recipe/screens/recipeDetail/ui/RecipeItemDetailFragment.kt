package com.app.recipe.screens.recipeDetail.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.app.recipe.R
import com.app.recipe.databinding.FragmentRecipeDetailBinding
import com.app.recipe.network.State
import com.app.recipe.network.baseModel.EventObserver
import com.app.recipe.screens.base.BaseFragment
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel
import com.app.recipe.screens.recipeDetail.viewModel.RecipeDetailViewModel
import com.app.recipe.utils.showToast
import com.app.recipe.views.TitleBar
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeItemDetailFragment : BaseFragment<FragmentRecipeDetailBinding>(R.layout.fragment_recipe_detail) {
    private val viewModel by viewModels<RecipeDetailViewModel>()

    private val recipeID by lazy {
        arguments?.getInt("recipeID")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRecipeDetail(recipeID)

        viewModel.recipeDetailResult.observe(viewLifecycleOwner, EventObserver {
            when (it) {
                is State.Error -> showToast(it.message)
                is State.Exception -> {
                    it.exception.printStackTrace()
                    showToast(it.exception.message)
                }
                is State.Loading -> mainActivity.showLoader(it.isLoading)
                is State.Success -> {
                    it.body?.apply {
                        bindViews(this)
                    }
                }
            }
        })
    }

    private fun bindViews(model: RecipeDetailModel) {
        binding.recipe = model
        binding.itemViewPager.adapter = RecipeViewpagerAdapter(model, requireActivity())
        TabLayoutMediator(binding.tablayout, binding.itemViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Summery"
                1 -> tab.text = "Ingredients"
                2 -> tab.text = "instructions"
            }
        }.attach()
    }

    override fun setTitleBar(titleBar: TitleBar?) {
        super.setTitleBar(titleBar)
        titleBar?.hideButtons()
        titleBar?.showBackButton()
        titleBar?.setHeading("Recipe Detail")
    }

    companion object {
        fun newInstance(recipeID: Int?): RecipeItemDetailFragment {
            val args = Bundle()
            recipeID?.let { args.putInt("recipeID", it) }
            val fragment = RecipeItemDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private inner class RecipeViewpagerAdapter(val itemDetail: RecipeDetailModel, fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> RecipeSummeryFragment.newInstance(itemDetail.summary)
                1 -> RecipeIngredientFragment.newInstance(itemDetail.extendedIngredients)
                else -> RecipeInstructionFragment.newInstance(itemDetail.analyzedInstructions)
            }
        }
    }
}