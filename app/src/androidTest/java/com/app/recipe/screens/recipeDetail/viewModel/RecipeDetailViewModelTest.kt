package com.app.recipe.screens.recipeDetail.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.app.recipe.getOrAwaitValue
import com.app.recipe.network.State
import com.app.recipe.repository.MockRecipeRepository
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class RecipeDetailViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var recipeDetailViewModelTest: RecipeDetailViewModel

    @Before
    fun setup() {
        recipeDetailViewModelTest = RecipeDetailViewModel(MockRecipeRepository())
    }


    @Test
    fun fetchRecipeDetailSuccess(): Unit = runBlockingTest {
        recipeDetailViewModelTest.getRecipeDetail(637767)

        val item = recipeDetailViewModelTest.recipeDetailResult.getOrAwaitValue()

        Truth.assertThat(item.getContentIfNotHandled() is State.Success).isTrue()

    }


    @Test
    fun fetchRecipeDetailFail(): Unit = runBlockingTest {
        recipeDetailViewModelTest.getRecipeDetail(62337)

        val item = recipeDetailViewModelTest.recipeDetailResult.getOrAwaitValue()

        Truth.assertThat(item.getContentIfNotHandled() is State.Error).isTrue()

    }
}