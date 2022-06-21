package com.app.recipe.repository

import com.app.recipe.network.State
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel
import com.app.recipe.screens.searchRecipe.dataModels.SearchRecipeModel
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun searchRecipes(query: String): Flow<State<SearchRecipeModel>>
    fun getRecipeDetail(recipeId: Int?): Flow<State<RecipeDetailModel>>
}