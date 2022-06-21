package com.app.recipe.screens.recipeDetail.binders

import android.content.Context
import com.app.recipe.R
import com.app.recipe.databinding.RowItemRecipeInstructionBinding
import com.app.recipe.screens.base.BaseRecyclerViewBinder
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel

class RecipeInstructionStepBinder : BaseRecyclerViewBinder<RecipeDetailModel.Step, RowItemRecipeInstructionBinding>(R.layout.row_item_recipe_instruction) {
    override fun bindView(entity: RecipeDetailModel.Step, position: Int, viewHolder: BaseViewHolder<RowItemRecipeInstructionBinding>?, context: Context, collections: MutableList<RecipeDetailModel.Step>) {
        viewHolder?.viewBinding?.let {
            it.dataItem = entity
        }
    }
}