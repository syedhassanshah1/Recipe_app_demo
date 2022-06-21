package com.app.recipe.screens.searchRecipe

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.app.recipe.R
import com.app.recipe.databinding.FragmentSearchRecipeBinding
import com.app.recipe.network.State
import com.app.recipe.network.baseModel.EventObserver
import com.app.recipe.screens.base.BaseFragment
import com.app.recipe.screens.base.BaseRecyclerViewAdapter
import com.app.recipe.screens.recipeDetail.ui.RecipeItemDetailFragment
import com.app.recipe.screens.searchRecipe.binders.SearchItemBinder
import com.app.recipe.screens.searchRecipe.viewModel.SearchViewModel
import com.app.recipe.utils.invisible
import com.app.recipe.utils.showToast
import com.app.recipe.utils.visible
import com.app.recipe.views.TitleBar
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class SearchRecipeFragment : BaseFragment<FragmentSearchRecipeBinding>(R.layout.fragment_search_recipe) {
    private var timer: Timer? = null
    private val viewModel by viewModels<SearchViewModel>()
    private var assetURI: String = ""
    private val searchItemBinder by lazy {
        SearchItemBinder(assetURI) { entity, position ->
            mainActivity.navigateTo(RecipeItemDetailFragment.newInstance(entity.id))
        }
    }
    
    private val searchItemAdapter by lazy {
        BaseRecyclerViewAdapter(
                arrayListOf(),
                searchItemBinder,
                requireContext()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()

        binding.rvRecipes.adapter = searchItemAdapter
        binding.rvRecipes.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun setTitleBar(titleBar: TitleBar?) {
        super.setTitleBar(titleBar)
        titleBar?.hideButtons()
        titleBar?.setHeading("Search Recipes")
    }

    private fun setListeners() {
        binding.apply {
            edtSearch.doAfterTextChanged {
                timer = Timer()
                timer?.schedule(object : TimerTask() {
                    override fun run() {
                        viewModel.searchRecipes(it.toString())
                    }
                }, 400)

            }
            edtSearch.doOnTextChanged { _, _, _, _ ->
                timer?.cancel()
            }
        }
        viewModel.searchResults.observe(viewLifecycleOwner, EventObserver {
            when (it) {
                is State.Error -> showToast(it.message)
                is State.Exception -> {
                    it.exception.printStackTrace()
                    showToast(it.exception.message)
                }
                is State.Loading -> mainActivity.showLoader(it.isLoading)
                is State.Success -> {
                    it.body?.apply {
                        if (results.isNullOrEmpty()) {
                            binding.txtNoData.visible()
                            binding.rvRecipes.invisible()
                        } else {
                            binding.txtNoData.invisible()
                            binding.rvRecipes.visible()
                            searchItemBinder.assetURI = baseUri
                            searchItemAdapter.addAll(results ?: arrayListOf())
                        }
                    }
                }
            }
        })
    }
}