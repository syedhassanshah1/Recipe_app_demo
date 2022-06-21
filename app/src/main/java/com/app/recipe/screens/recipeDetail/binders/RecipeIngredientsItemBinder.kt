package com.app.recipe.screens.recipeDetail.binders

import android.content.Context
import com.app.recipe.R
import com.app.recipe.databinding.RowItemRecipeIngredientsBinding
import com.app.recipe.screens.base.BaseRecyclerViewBinder
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel

class RecipeIngredientsItemBinder()
    : BaseRecyclerViewBinder<RecipeDetailModel.ExtendedIngredient, RowItemRecipeIngredientsBinding>(R.layout.row_item_recipe_ingredients) {
    override fun bindView(entity: RecipeDetailModel.ExtendedIngredient, position: Int, viewHolder: BaseViewHolder<RowItemRecipeIngredientsBinding>?, context: Context, collections: MutableList<RecipeDetailModel.ExtendedIngredient>) {
        viewHolder?.viewBinding?.let {
            it.dataItem = entity
        }
    }
}