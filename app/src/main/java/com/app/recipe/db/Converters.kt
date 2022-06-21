package com.app.recipe.db

import androidx.room.TypeConverter
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import kotlin.collections.ArrayList

class AnalyzedInstructionConverters {

    @TypeConverter
    fun fromStringToArrayList(value: String): ArrayList<RecipeDetailModel.AnalyzedInstruction> {
        val listType = object: TypeToken<ArrayList<RecipeDetailModel.AnalyzedInstruction>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayListToString(list: ArrayList<RecipeDetailModel.AnalyzedInstruction>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
class DateConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}
class ExtendedIngredientConverters {

    @TypeConverter
    fun fromStringToArrayList(value: String): ArrayList<RecipeDetailModel.ExtendedIngredient> {
        val listType = object: TypeToken<ArrayList<RecipeDetailModel.ExtendedIngredient>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayListToString(list: ArrayList<RecipeDetailModel.ExtendedIngredient>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}

class GenericConverters {

    @TypeConverter
    fun fromStringToArrayList(value: String): ArrayList<Any> {
        val listType = object: TypeToken<ArrayList<Any>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayListToString(list: ArrayList<Any>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}

class StringConverters {

    @TypeConverter
    fun fromStringToArrayList(value: String): ArrayList<String> {
        val listType = object: TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayListToString(list: ArrayList<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}

class ProductMatcheConverters {

    @TypeConverter
    fun fromStringToArrayList(value: String): ArrayList<RecipeDetailModel.ProductMatche> {
        val listType = object: TypeToken<ArrayList<RecipeDetailModel.ProductMatche>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayListToString(list: ArrayList<RecipeDetailModel.ProductMatche>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}