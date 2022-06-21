package com.app.recipe.network.retrofit

import com.app.recipe.BuildConfig
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel
import com.app.recipe.screens.searchRecipe.dataModels.SearchRecipeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {
    @GET("recipes/search")
    suspend fun searchRecipes(@Query("query") query: String?, @Query("apiKey") apiKey: String? = BuildConfig.APIKEY): Response<SearchRecipeModel>

    @GET("recipes/{recipeId}/information")
    suspend fun getRecipeDetail(@Path("recipeId") recipeId: Int?, @Query("apiKey") apiKey: String? = BuildConfig.APIKEY): Response<RecipeDetailModel>

}