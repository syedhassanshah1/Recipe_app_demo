package com.app.recipe.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel
import com.app.recipe.utils.getDaysSubtracted
import java.util.*

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipe(item: RecipeDetailModel)

    @Query("Select * from RecipeDetail where id =:recipeID AND createdDate BETWEEN :startDate AND :endDate")
    fun retrieveRecipe(recipeID: Int?, startDate: Date = Calendar.getInstance().getDaysSubtracted(7),
                       endDate: Date = Date()): RecipeDetailModel?

    @Query("Select * from RecipeDetail")
    fun retrieveAllRecipes(): LiveData<List<RecipeDetailModel>>

}