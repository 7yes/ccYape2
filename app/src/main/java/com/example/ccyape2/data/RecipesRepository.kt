package com.example.ccyape2.data

import android.util.Log
import com.example.ccyape2.data.network.RecipeService
import com.example.ccyape2.domain.model.RecipeItem
import com.example.ccyape2.domain.model.toDomain
import javax.inject.Inject

class RecipesRepository @Inject constructor(val api:RecipeService){

    suspend fun getAppFromApi():List<RecipeItem>{
        val response = api.getAllRecipes()
        Log.d("TAG", "repo getAppFromApi: ${response[1]} ")
        return response.map { it.toDomain() }
    }
}
