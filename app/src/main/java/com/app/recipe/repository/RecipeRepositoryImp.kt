package com.app.recipe.repository

import android.util.Log
import com.app.recipe.db.RecipeDao
import com.app.recipe.network.MultiSourceResultParser
import com.app.recipe.network.NetworkResultParser
import com.app.recipe.network.State
import com.app.recipe.network.retrofit.WebService
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel
import com.app.recipe.screens.searchRecipe.dataModels.SearchRecipeModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepositoryImp @Inject constructor(private val apiService: WebService, private val recipeDao: RecipeDao) : RecipeRepository {
    @ExperimentalCoroutinesApi
    override fun searchRecipes(query: String): Flow<State<SearchRecipeModel>> {
        return object : NetworkResultParser<SearchRecipeModel>() {
            override suspend fun fetchFromRemote(): Response<SearchRecipeModel> {
                return apiService.searchRecipes(query)
            }
        }.asFlow()
    }


    @ExperimentalCoroutinesApi
    override fun getRecipeDetail(recipeId: Int?): Flow<State<RecipeDetailModel>> = object : MultiSourceResultParser<RecipeDetailModel>() {
        override suspend fun fetchFromDB(): RecipeDetailModel? {
            return recipeDao.retrieveRecipe(recipeId)
        }

        override suspend fun updateDB(item: RecipeDetailModel) {
            item.apply { createdDate = Date() }
            recipeDao.insertRecipe(item)
        }

        override suspend fun fetchFromRemote(): Response<RecipeDetailModel> {
            return apiService.getRecipeDetail(recipeId)
        }

    }.asFlow()
}
