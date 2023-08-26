package com.example.ccyape2.data

import com.example.ccyape2.data.network.RecipeService
import com.example.ccyape2.domain.model.RecipeItem
import com.example.ccyape2.domain.model.toDomain
import javax.inject.Inject

class RecipesRepository @Inject constructor(val api:RecipeService){

    suspend fun getAppFromApi():List<RecipeItem>{
        val response = api.getAllRecipes()
        return response.map { it.toDomain() }
    }
}
