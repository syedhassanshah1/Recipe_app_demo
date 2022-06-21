package com.app.recipe.repository

import com.app.recipe.network.State
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel
import com.app.recipe.screens.searchRecipe.dataModels.SearchRecipeModel
import com.app.recipe.utils.fromJson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockRecipeRepository : RecipeRepository {
    private val mockSearchItems = MockResponses.searchItems.fromJson<SearchRecipeModel>()
    private val mockRecipeItem = MockResponses.recipeItem.fromJson<RecipeDetailModel>()

    override fun searchRecipes(query: String): Flow<State<SearchRecipeModel>> {
        return flow {
            if (query == "cake") {
                emit(State.error<SearchRecipeModel>("No Values found", null))
            } else {
                emit(State.success(mockSearchItems))
            }

        }
    }

    override fun getRecipeDetail(recipeId: Int?): Flow<State<RecipeDetailModel>> {
        return flow {
            if (recipeId == 637767) {
                emit(State.success(mockRecipeItem))
            } else {
                emit(State.error<RecipeDetailModel>("Some Error occurred", null))
            }
        }
    }
}