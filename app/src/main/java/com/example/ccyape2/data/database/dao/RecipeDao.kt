package com.example.ccyape2.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.ccyape2.data.database.entities.RecipeEntity

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe_table")
    suspend fun getAllRecipes(): List<RecipeEntity>

//    @Insert(onConflict = OnConflictStrategy.REPLACE) //todo
//    suspend fun insertAll(recipes: List<RecipeItem>)

    @Query("DELETE FROM recipe_table")
    suspend fun deleteAllRecipes()

}