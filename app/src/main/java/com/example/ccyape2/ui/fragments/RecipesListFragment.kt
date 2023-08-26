package com.example.ccyape2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ccyape2.databinding.FragmentRecipesListBinding
import com.example.ccyape2.viewmodel.RecipesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipesListFragment : Fragment() {
    private var _binding: FragmentRecipesListBinding? = null
    private val binding get() = _binding!!

    private val viewmodel:RecipesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipesListBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment

        binding.svSearch.setOnClickListener {
            viewmodel.getAllrecipes()
        }
       // findNavController().navigate(R.id.action_recipesListFragment_to_detailFragment)
        // proveRetro()

        return binding.root
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
