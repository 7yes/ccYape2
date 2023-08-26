package com.example.ccyape2.data.network

import android.util.Log
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
          Log.d("TAG", "en el servicio getAllRecipes: ${response.body()?.get(1)}")
          val body = response.body()
          body ?: emptyList()
        }
    }
}
