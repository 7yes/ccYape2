package com.example.ccyape2.data.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ccyape2.data.database.dao.RecipeDao
import com.example.ccyape2.data.database.entities.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 1)
abstract class RecipeDB : RoomDatabase() {
    abstract fun getRecipeDao(): RecipeDao
}