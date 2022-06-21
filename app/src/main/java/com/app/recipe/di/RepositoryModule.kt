package com.app.recipe.di

import com.app.recipe.repository.RecipeRepository
import com.app.recipe.repository.RecipeRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRecipeRepository(imp: RecipeRepositoryImp): RecipeRepository
}
