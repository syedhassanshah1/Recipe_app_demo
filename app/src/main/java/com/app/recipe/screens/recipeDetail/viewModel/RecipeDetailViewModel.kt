package com.app.recipe.screens.recipeDetail.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.recipe.network.State
import com.app.recipe.network.baseModel.Event
import com.app.recipe.repository.RecipeRepository
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(private val recipeRepository: RecipeRepository) : ViewModel() {
    private val _recipeDetailResult = MutableLiveData<Event<State<RecipeDetailModel>>>()
    val recipeDetailResult: LiveData<Event<State<RecipeDetailModel>>> get() = _recipeDetailResult

    fun getRecipeDetail(recipeId: Int?) {
        viewModelScope.launch {
            recipeRepository.getRecipeDetail(recipeId).collect {
                _recipeDetailResult.postValue(Event(it))
            }
        }
    }

}