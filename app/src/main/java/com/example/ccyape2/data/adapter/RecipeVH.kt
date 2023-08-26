package com.example.ccyape2.data.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ccyape2.core.load
import com.example.ccyape2.databinding.ItemSmallRecipeBinding
import com.example.ccyape2.domain.model.RecipeItem

class RecipeVH(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSmallRecipeBinding.bind(view)
    fun bind(item: RecipeItem, onClickLis: (RecipeItem) -> Unit) {
        binding.tvName.text = item.name
        binding.ivPhoto.load(item.photo)
        binding.tvDescription.text =item.description
        itemView.setOnClickListener { onClickLis(item) }
    }
}
