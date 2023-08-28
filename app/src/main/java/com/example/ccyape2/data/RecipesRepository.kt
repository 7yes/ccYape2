package com.example.ccyape2.data

import com.example.ccyape2.data.database.dao.RecipeDao
import com.example.ccyape2.data.network.RecipeService
import com.example.ccyape2.domain.model.RecipeItem
import com.example.ccyape2.domain.model.toDomain
import javax.inject.Inject

class RecipesRepository @Inject constructor(
    private val api: RecipeService,
    private val recipeDao: RecipeDao
) {

    suspend fun getAll(): List<RecipeItem>{
        var list = getAllFromApi()
        if(list.isEmpty()){
            list = getAllFromDB()
        } else{
            //recipeDao.deleteAllRecipes() //todo
           // recipeDao.insertAll(list)
        }
        return list
    }
    private suspend fun getAllFromApi(): List<RecipeItem> {
        val response = api.getAllRecipes()
          return response.map { it.toDomain() }
    }
    private suspend fun getAllFromDB(): List<RecipeItem>{
        val response = recipeDao.getAllRecipes()
        return response.map {
            it.toDomain()
        }
    }
}

