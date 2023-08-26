package com.example.ccyape2.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ccyape2.R
import com.example.ccyape2.core.hideKeyboard
import com.example.ccyape2.data.adapter.RecipeAdapter
import com.example.ccyape2.databinding.FragmentRecipesListBinding
import com.example.ccyape2.domain.model.RecipeItem
import com.example.ccyape2.viewmodel.RecipesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipesListFragment : Fragment(), SearchView.OnQueryTextListener {
    private var _binding: FragmentRecipesListBinding? = null
    private val binding get() = _binding!!

    private val viewmodel: RecipesViewModel by activityViewModels()

    private lateinit var adapter: RecipeAdapter
    private var recipesList = mutableListOf<RecipeItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipesListBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment

        binding.svSearch.setOnClickListener {
            //
        }
        initRV()
        viewmodel.recipes.observe(viewLifecycleOwner) {
            Log.d("TAG", " cambio onCreateView: ${it[1]} ")
            recipesList.clear()
            recipesList.addAll(it)
            adapter.notifyDataSetChanged()
        }

        binding.svSearch.setOnQueryTextListener(this)

        return binding.root
    }

    private fun initRV() {
        Log.d("TAG", "initRV: ")
        adapter = RecipeAdapter(recipesList) {
            Log.d("TAG", "${it.name} selected ")
            viewmodel.updateLastRecipe(it)
            findNavController().navigate(R.id.action_recipesListFragment_to_detailFragment)
        }
        binding.rvRecipes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRecipes.adapter = adapter
        viewmodel.getAllrecipes()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        hideKeyboard()
        return true
    }
    override fun onQueryTextChange(newText: String): Boolean {
        if (newText.isEmpty()) hideKeyboard()
        val recipesFiltered =
            recipesList.filter { recipe ->
                recipe.name.lowercase().contains(newText.lowercase())
                recipe.description.lowercase().contains(newText.lowercase())
            }
        adapter.updateListByFilter(recipesFiltered)
        return true
    }

//    private fun proveRetro() {
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = getRetrofit().create(RecipeApi::class.java).getAllRecipes()
//            val body = response.body()
//            Log.d("TAG", "onCreateView: $body")
//        }
//    }
//    fun getRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https://demo3038897.mockable.io/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }

}
