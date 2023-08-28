package com.example.ccyape2.domain.usecase

import com.example.ccyape2.data.RecipesRepository
import com.example.ccyape2.domain.model.RecipeItem
import javax.inject.Inject

class GetAllUseCase @Inject constructor(val repository: RecipesRepository){
    suspend fun getAllRecipes(): List<RecipeItem> {
        return repository.getAll()
    }
}
