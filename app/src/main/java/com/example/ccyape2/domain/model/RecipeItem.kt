package com.example.ccyape2.domain.model

import com.example.ccyape2.data.database.entities.RecipeEntity
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

fun RecipeEntity.toDomain() = RecipeItem(
    description = description,
    name = name,
    photo = photo,
    ingredients = listOf("aaa", "bbb"), //Todo
    location = Location(
        "bogo",
        40.0, 40.0
    )
)