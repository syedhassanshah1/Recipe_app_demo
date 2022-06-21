package com.app.recipe.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.recipe.screens.recipeDetail.dataModels.RecipeDetailModel

@Database(entities = [RecipeDetailModel::class], version = 1, exportSchema = false)
@TypeConverters(AnalyzedInstructionConverters::class, GenericConverters::class, ExtendedIngredientConverters::class, DateConverters::class, StringConverters::class, ProductMatcheConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {
        const val dbName = "recipe_database"

        @Volatile
        private var appDatabase: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return appDatabase ?: synchronized(this) {
                appDatabase ?: buildDatabase(context).also { appDatabase = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    dbName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
        }

    }
}
