package com.example.ccyape2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ccyape2.domain.model.RecipeItem
import com.example.ccyape2.domain.usecase.GetAllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(private val getAllUseCase: GetAllUseCase):ViewModel() {

    private var _recipes = MutableLiveData<List<RecipeItem>>()
    val recipes: LiveData<List<RecipeItem>> = _recipes

     fun getAllrecipes(){
         viewModelScope.launch() {
             val response = getAllUseCase.getAllRecipes()
             _recipes.postValue(response)
             Log.d("TAG", "view model getAllrecipes: llego ${response[1]}")
         }
     }
}
