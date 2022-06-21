package com.app.recipe.screens.searchRecipe.dataModels


data class SearchRecipeModel(
        var baseUri: String? = "",
        var expires: Long? = 0,
        var isStale: Boolean? = false,
        var number: Int? = 0,
        var offset: Int? = 0,
        var processingTimeMs: Int? = 0,
        var results: List<Result>? = listOf(),
        var totalResults: Int? = 0
) {

    data class Result(
            var id: Int? = 0,
            var image: String? = "",
            var openLicense: Int? = 0,
            var readyInMinutes: Int? = 0,
            var servings: Int? = 0,
            var sourceUrl: String? = "",
            var title: String? = ""
    )
}