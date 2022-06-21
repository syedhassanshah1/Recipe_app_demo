package com.app.recipe.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.app.recipe.getOrAwaitValue
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel
import com.app.recipe.utils.getDaysSubtracted
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class RecipeDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase
    private lateinit var dao: RecipeDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.recipeDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertRecipeItem(): Unit = runBlockingTest {
        val recipeItem = RecipeDetailModel(createdDate = Date(), id = 1, title = "This is test recipe")
        dao.insertRecipe(recipeItem)

        val insertedItems = dao.retrieveAllRecipes().getOrAwaitValue()

        assertThat(insertedItems).contains(recipeItem)
    }

    @Test
    fun getIDedItemsSuccess() = runBlockingTest {
        val recipeItem = RecipeDetailModel(createdDate = Calendar.getInstance().getDaysSubtracted(1), id = 1, title = "This is test recipe")

        dao.insertRecipe(recipeItem)
        val insertedItem = dao.retrieveRecipe(1)

        assertThat(insertedItem).isEqualTo(recipeItem)
    }

    @Test
    fun getIDedItemsFail() = runBlockingTest {
        val recipeItem = RecipeDetailModel(createdDate = Calendar.getInstance().getDaysSubtracted(8), id = 1, title = "This is test recipe")

        dao.insertRecipe(recipeItem)

        val insertedItem = dao.retrieveRecipe(1)

        assertThat(insertedItem).isNotEqualTo(recipeItem)
    }

}