package com.example.ccyape2.data.model

import com.google.gson.annotations.SerializedName

data class RecipeModelItem(
   @SerializedName("description") val description: String,
   @SerializedName("ingredients")val ingredients: List<String>,
   @SerializedName("location") val location: Location,
   @SerializedName("name") val name: String,
   @SerializedName("photo") val photo: String
)
