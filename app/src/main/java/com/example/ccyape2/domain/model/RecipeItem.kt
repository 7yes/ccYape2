package com.example.ccyape2.domain.model

import com.example.ccyape2.data.model.Location
import com.example.ccyape2.data.model.RecipeModelItem

data class RecipeItem(
    val description: String,
    val ingredients: List<String>,
    val location: Location,
    val name: String,
    val photo: String
)

fun RecipeModelItem.toDomain() =
    RecipeItem(description = description, ingredients, location, name, photo)
