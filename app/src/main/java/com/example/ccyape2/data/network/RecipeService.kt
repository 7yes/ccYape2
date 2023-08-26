package com.example.ccyape2.data.network

import com.example.ccyape2.data.model.RecipeModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.GET
import javax.inject.Inject

class RecipeService @Inject constructor (private val api : RecipeApi) {

    @GET("recetas")
    suspend fun getAllRecipes():List<RecipeModelItem>{
      return withContext(Dispatchers.IO){
          val response =   api.getAllRecipes()
          val body = response.body()
          body ?: emptyList()
        }
    }
}
