package com.example.ccyape2.domain.usecase

import android.util.Log
import com.example.ccyape2.data.RecipesRepository
import com.example.ccyape2.domain.model.RecipeItem
import javax.inject.Inject

class GetAllUseCase @Inject constructor(val repository: RecipesRepository){
    suspend fun getAllRecipes():List<RecipeItem>{
        val response =  repository.getAppFromApi()
        Log.d("TAG", "useCase getAllRecipes: ${response[1]}")
        return response
    }
}
