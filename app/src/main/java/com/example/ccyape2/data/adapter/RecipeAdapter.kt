package com.example.ccyape2.data.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ccyape2.R
import com.example.ccyape2.domain.model.RecipeItem

class RecipeAdapter(private val listRecipes: List<RecipeItem>) : RecyclerView.Adapter<RecipeVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecipeVH(layoutInflater.inflate(R.layout.item_small_recipe, parent, false))
    }

    override fun getItemCount(): Int = listRecipes.size

    override fun onBindViewHolder(holder: RecipeVH, position: Int) {
        val item = listRecipes[position]
        Log.d("TAG", "onBindViewHolder: ${item.name} ")
        holder.bind(item)
    }
}
