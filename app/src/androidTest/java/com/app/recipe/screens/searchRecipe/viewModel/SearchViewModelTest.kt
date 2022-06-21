package com.app.recipe.screens.searchRecipe.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.app.recipe.getOrAwaitValue
import com.app.recipe.network.State
import com.app.recipe.repository.MockRecipeRepository
import com.app.recipe.screens.recipeDetail.viewModel.RecipeDetailViewModel
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
class SearchViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var searchViewModelTest: SearchViewModel

    @Before
    fun setup() {
        searchViewModelTest = SearchViewModel(MockRecipeRepository())
    }


    @Test
    fun fetchSearchResultSuccess(): Unit = runBlockingTest {
        searchViewModelTest.searchRecipes("")

        val item = searchViewModelTest.searchResults.getOrAwaitValue()

        Truth.assertThat(item.getContentIfNotHandled() is State.Success).isTrue()

    }
    @Test
    fun fetchSearchResultFail(): Unit = runBlockingTest {
        searchViewModelTest.searchRecipes("cake")

        val item = searchViewModelTest.searchResults.getOrAwaitValue()

        Truth.assertThat(item.getContentIfNotHandled() is State.Error).isTrue()

    }
}