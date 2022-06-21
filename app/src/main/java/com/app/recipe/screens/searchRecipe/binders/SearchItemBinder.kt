package com.app.recipe.screens.searchRecipe.binders

import android.content.Context
import com.app.recipe.R
import com.app.recipe.databinding.RowItemSearchRecipeBinding
import com.app.recipe.screens.base.BaseRecyclerViewBinder
import com.app.recipe.screens.searchRecipe.dataModels.SearchRecipeModel

class SearchItemBinder(var assetURI: String?,
                       private var itemClickLister: (entity: SearchRecipeModel.Result, position: Int) -> Unit)
    : BaseRecyclerViewBinder<SearchRecipeModel.Result, RowItemSearchRecipeBinding>(R.layout.row_item_search_recipe) {
    override fun bindView(entity: SearchRecipeModel.Result, position: Int, viewHolder: BaseViewHolder<RowItemSearchRecipeBinding>?, context: Context, collections: MutableList<SearchRecipeModel.Result>) {
        viewHolder?.viewBinding?.let {
            it.assetsURI = assetURI
            it.dataItem = entity
            it.containerMain.setOnClickListener {
                itemClickLister.invoke(entity, position)
            }
        }
    }
}