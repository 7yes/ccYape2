package com.example.ccyape2.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_table")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "description") val description: String,
   // @ColumnInfo(name = "ingredients") val ingredients: List<String>, //todo
   // @ColumnInfo(name = "location") val location: Location,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "photo") val photo: String,
)