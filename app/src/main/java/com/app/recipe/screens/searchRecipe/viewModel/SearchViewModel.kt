package com.app.recipe.screens.searchRecipe.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.recipe.network.State
import com.app.recipe.network.baseModel.Event
import com.app.recipe.repository.RecipeRepository
import com.app.recipe.screens.searchRecipe.dataModels.SearchRecipeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val recipeRepository: RecipeRepository) : ViewModel() {
    private val _searchResults = MutableLiveData<Event<State<SearchRecipeModel>>>()
    val searchResults: LiveData<Event<State<SearchRecipeModel>>> get() = _searchResults

    init {
        searchRecipes("")
    }

    fun searchRecipes(query: String) {
        viewModelScope.launch {
            recipeRepository.searchRecipes(query).collect {
                    _searchResults.value = (Event(it))
            }
        }
    }
}