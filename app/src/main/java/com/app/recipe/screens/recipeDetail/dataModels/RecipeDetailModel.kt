package com.app.recipe.screens.recipeDetail.dataModels

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*
import kotlin.collections.ArrayList

@Entity(tableName = "RecipeDetail")
data class RecipeDetailModel(
        var createdDate: Date,
        var aggregateLikes: Int? = 0,
        var analyzedInstructions: ArrayList<AnalyzedInstruction> = arrayListOf(),
        var cheap: Boolean? = false,
        var creditsText: String? = "",
        var cuisines: ArrayList<Any>? = arrayListOf(),
        var dairyFree: Boolean? = false,
        var diets: ArrayList<Any>? = arrayListOf(),
        var dishTypes: ArrayList<Any>? = arrayListOf(),
        var extendedIngredients: ArrayList<ExtendedIngredient> = arrayListOf(),
        var gaps: String? = "",
        var glutenFree: Boolean? = false,
        var healthScore: Double? = 0.0,
        @PrimaryKey
        var id: Int? = 0,
        var image: String? = "",
        var imageType: String? = "",
        var instructions: String? = "",
        var license: String? = "",
        var lowFodmap: Boolean? = false,
        var occasions: ArrayList<Any>? = arrayListOf(),
        var pricePerServing: Double? = 0.0,
        var readyInMinutes: Int? = 0,
        var servings: Int? = 0,
        var sourceName: String? = "",
        var sourceUrl: String? = "",
        var spoonacularScore: Double? = 0.0,
        var spoonacularSourceUrl: String? = "",
        var summary: String? = "",
        var sustainable: Boolean? = false,
        var title: String? = "",
        var vegan: Boolean? = false,
        var vegetarian: Boolean? = false,
        var veryHealthy: Boolean? = false,
        var veryPopular: Boolean? = false,
        var weightWatcherSmartPoints: Int? = 0,
        @Embedded
        var winePairing: WinePairing? = WinePairing()
)  {


    data class AnalyzedInstruction(
            var name: String? = "",
            var steps: List<Step>? = arrayListOf()
    )

    data class ExtendedIngredient(
            var aisle: String? = "",
            var amount: Double? = 0.0,
            var consistency: String? = "",
            var id: Int? = 0,
            var image: String? = "",
            var measures: Measures? = Measures(),
            var meta: ArrayList<String>? = arrayListOf(),
            var metaInformation: ArrayList<String>? = arrayListOf(),
            var name: String? = "",
            var nameClean: String? = "",
            var original: String? = "",
            var originalName: String? = "",
            var originalString: String? = "",
            var unit: String? = ""
    )

    data class WinePairing(
            var pairedWines: ArrayList<String>? = arrayListOf(),
            var pairingText: String? = "",
            var productMatches: ArrayList<ProductMatche>? = arrayListOf()
    )

    data class Step(
            var equipment: ArrayList<Any>? = arrayListOf(),
            var ingredients: ArrayList<Ingredient>? = arrayListOf(),
            var number: Int? = 0,
            var step: String? = ""
    )

    data class Ingredient(
            var id: Int? = 0,
            var image: String? = "",
            var localizedName: String? = "",
            var name: String? = ""
    )

    data class Measures(
            var metric: Metric? = Metric(),
            var us: Us? = Us()
    )

    data class Metric(
            var amount: Double? = 0.0,
            var unitLong: String? = "",
            var unitShort: String? = ""
    )

    data class Us(
            var amount: Double? = 0.0,
            var unitLong: String? = "",
            var unitShort: String? = ""
    )

    data class ProductMatche(
            var averageRating: Double? = 0.0,
            var description: String? = "",
            var id: Int? = 0,
            var imageUrl: String? = "",
            var link: String? = "",
            var price: String? = "",
            var ratingCount: Double? = 0.0,
            var score: Double? = 0.0,
            var title: String? = ""
    )
}