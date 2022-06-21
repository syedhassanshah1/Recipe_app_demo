package com.app.recipe.screens.recipeDetail.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.recipe.R
import com.app.recipe.databinding.FragmentRecipeDetailInstructionBinding
import com.app.recipe.screens.base.BaseFragment
import com.app.recipe.screens.base.BaseRecyclerViewAdapter
import com.app.recipe.screens.recipeDetail.binders.RecipeInstructionStepBinder
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel

class RecipeInstructionFragment : BaseFragment<FragmentRecipeDetailInstructionBinding>(R.layout.fragment_recipe_detail_instruction) {
    private var instructions: List<RecipeDetailModel.AnalyzedInstruction>? = null
    private val instructionStepAdapter by lazy {
        BaseRecyclerViewAdapter(
                arrayListOf(),
                RecipeInstructionStepBinder(),
                requireContext()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instructionStepAdapter.addAll(instructions?.firstOrNull()?.steps.orEmpty())
        binding.rvInstructions.adapter = instructionStepAdapter
        binding.rvInstructions.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
        fun newInstance(instructions: List<RecipeDetailModel.AnalyzedInstruction>): RecipeInstructionFragment {
            val fragment = RecipeInstructionFragment()
            fragment.instructions = instructions
            return fragment
        }
    }
}