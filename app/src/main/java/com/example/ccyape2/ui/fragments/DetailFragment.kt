package com.example.ccyape2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ccyape2.R
import com.example.ccyape2.core.load
import com.example.ccyape2.databinding.FragmentDetailBinding
import com.example.ccyape2.viewmodel.RecipesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewmodel: RecipesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)

        binding.btnMaps.setOnClickListener { findNavController().navigate(R.id.action_detailFragment_to_mapsFragment) }
        fillData()
        return binding.root
    }
    private fun fillData() {
        val recipe = viewmodel.lastRecipe.value
        recipe?.let {
            binding.tvName.text = it.name
            binding.imPhoto.load(it.photo)
            binding.tvDescription.text=it.description
            var s = ""
            it.ingredients.forEach {
                s+=" * $it \n"
            }
            binding.tvIngredients.text= s
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
