package com.example.ccyape2.data.network

import com.example.ccyape2.data.model.RecipeModelItem
import retrofit2.Response
import retrofit2.http.GET

interface RecipeApi {

    @GET("recetas")
    suspend fun getAllRecipes():Response<List<RecipeModelItem>>
}
