package com.example.ccyape2.data.network

import android.util.Log
import com.example.ccyape2.data.model.RecipeModelItem
import retrofit2.http.GET
import javax.inject.Inject

class RecipeService @Inject constructor(private val api: RecipeApi) {

    @GET("recetas")
    suspend fun getAllRecipes(): List<RecipeModelItem> {
        var answer = emptyList<RecipeModelItem>()
        try {
            val response = api.getAllRecipes()
            Log.d("TAG", "si hay internet ")
            val body = response.body()
            if (body != null) {
                answer=body
            } else{
                Log.d("TAG", "error de servidor esta apagado x3")
            }
        } catch (e:Exception){
            if(e.message!!.lowercase().contains("unable to resolve")){
                Log.d("TAG", "error catch en if No internet")
            } else{
                Log.d("TAG", "error catch error ${e.message}")
            }
        }
        Log.d("TAG", "answer $answer: ")
       return answer
    }
}
