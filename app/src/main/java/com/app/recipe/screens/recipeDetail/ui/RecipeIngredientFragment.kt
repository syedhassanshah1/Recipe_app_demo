package com.app.recipe.screens.recipeDetail.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.recipe.R
import com.app.recipe.databinding.FragmentRecipeDetailIngredientsBinding
import com.app.recipe.screens.base.BaseFragment
import com.app.recipe.screens.base.BaseRecyclerViewAdapter
import com.app.recipe.screens.recipeDetail.binders.RecipeIngredientsItemBinder
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel

class RecipeIngredientFragment : BaseFragment<FragmentRecipeDetailIngredientsBinding>(R.layout.fragment_recipe_detail_ingredients) {
    private var ingredientList: List<RecipeDetailModel.ExtendedIngredient>? = null
    private val ingredientItemAdapter by lazy {
        BaseRecyclerViewAdapter(
                arrayListOf(),
                RecipeIngredientsItemBinder(),
                requireContext()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ingredientItemAdapter.addAll(ingredientList.orEmpty())
        binding.rvIngredients.adapter = ingredientItemAdapter
        binding.rvIngredients.layoutManager = LinearLayoutManager(requireContext())

    }

    companion object {
        fun newInstance(ingredientList: List<RecipeDetailModel.ExtendedIngredient>): RecipeIngredientFragment {
            val fragment = RecipeIngredientFragment()
            fragment.ingredientList = ingredientList
            return fragment
        }
    }
}