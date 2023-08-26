package com.example.ccyape2.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ccyape2.data.adapter.RecipeAdapter
import com.example.ccyape2.databinding.FragmentRecipesListBinding
import com.example.ccyape2.domain.model.RecipeItem
import com.example.ccyape2.viewmodel.RecipesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipesListFragment : Fragment() {
    private var _binding: FragmentRecipesListBinding? = null
    private val binding get() = _binding!!

    private val viewmodel:RecipesViewModel by viewModels()

    private  lateinit var adapter: RecipeAdapter
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

       // findNavController().navigate(R.id.action_recipesListFragment_to_detailFragment)
        // proveRetro()

        return binding.root
    }
    private fun initRV() {
        Log.d("TAG", "initRV: ")
        adapter = RecipeAdapter(recipesList)
        binding.rvRecipes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRecipes.adapter = adapter
        viewmodel.getAllrecipes()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
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
